package ua.vkireiev.testing.module08.exercise0803.model.exercise0803;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

/**
 * @author Viktor Kireiev
 */
class UserTest {

    @Test
    void task2_AllFieldsInModelClassesShouldBePrivateAndFinal() {
        ArchRule rule = fields().that()
            .areDeclaredInClassesThat().resideInAPackage("ua.vkireiev.testing.module08.exercise0803.model..")
            .and().areDeclaredInClassesThat().areNotAnonymousClasses()
            .and().haveNameNotMatching(".*this\\$.*")
            .should().bePrivate()
            .andShould().beFinal()
            .because("Fields should be private and final to ensure immutability and encapsulation");

        rule.check(new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ua.vkireiev.testing.module08.exercise0803"));
    }

    @Test
    void task3_ModelClassesShouldBeFinal() {
        ArchRule rule = classes().that()
            .resideInAPackage("ua.vkireiev.testing.module08.exercise0803.model..")
            .should().bePublic()
            .andShould(beFinal())
            .because("Class should be final");

        rule.check(new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ua.vkireiev.testing.module08.exercise0803"));
    }

    @Test
    void task4_ModelClassesShouldNotHaveSetters() {
        ArchRule rule = methods().that()
            .areDeclaredInClassesThat().resideInAPackage("ua.vkireiev.testing.module08.exercise0803.model..")
            .and().haveNameMatching("^set[A-Z].*")
            .and(haveAtLeastOneParameter())
            .should().notBePublic()
            .because("Class should not have setters")
            .allowEmptyShould(true);

        rule.check(new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ua.vkireiev.testing.module08.exercise0803"));
    }

    @Test
    void test5_ensureCollectionsAreImmutableInModelClasses() {
        ArchRule rule = classes()
            .that().resideInAPackage("ua.vkireiev.testing.module08.exercise0803.model..")
            .should(haveUnmodifiableCollections())
            .because("Collections should be unmodifiable to ensure immutability");

        rule.check(new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ua.vkireiev.testing.module08.exercise0803.model"));
    }

    private ArchCondition<? super JavaClass> beFinal() {
        return new ArchCondition<>("be final") {

            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                if (!javaClass.getModifiers().contains(JavaModifier.FINAL)) {
                    String message = String.format(
                        "Class %s is not final",
                        javaClass.getName());
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

    private ArchCondition<JavaClass> haveUnmodifiableCollections() {
        return new ArchCondition<>("use unmodifiable collections in constructors") {

            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                for (JavaConstructor constructor : javaClass.getConstructors()) {
                    boolean hasCollectionParam = constructor.getRawParameterTypes().stream()
                        .anyMatch(c -> isCollectionType(c));

                    if (hasCollectionParam) {
                        boolean hasUnmodifiableCall = constructor.getMethodCallsFromSelf().stream()
                            .anyMatch(call -> call.getTargetOwner().isAssignableTo(Collections.class)
                                && call.getTarget().getName().startsWith("unmodifiable"));

                        if (!hasUnmodifiableCall) {
                            events.add(SimpleConditionEvent.violated(constructor, String.format(
                                "Constructor in %s uses collections but doesn't wrap them as unmodifiable",
                                javaClass.getName())));
                        }
                    }
                }
            }
        };
    }

    private boolean isCollectionType(JavaType type) {
        if (!(type instanceof JavaClass clazz)) {
            return false;
        }

        return clazz.isAssignableTo(Collection.class) || clazz.isAssignableTo(Map.class);
    }

    private DescribedPredicate<JavaMethod> haveAtLeastOneParameter() {
        return new DescribedPredicate<>("have at least one parameter") {

            @Override
            public boolean test(JavaMethod method) {
                return !method.getRawParameterTypes().isEmpty();
            }
        };
    }
}
