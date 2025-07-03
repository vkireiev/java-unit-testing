package ua.vkireiev.testing.module08.exercise0802;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;
import org.junit.jupiter.api.Test;
import ua.vkireiev.testing.module08.exercise0802.annotation.MyCustomAnnotation;
import ua.vkireiev.testing.module08.exercise0802.repository.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

/**
 * @author Viktor Kireiev
 */
class ArchitectureTest {

    @Test
    void task1_ServicesShouldNotDependOnControllers() {
        ArchRule rule = noClasses()
            .that().resideInAPackage("ua.vkireiev.testing.module08.exercise0802.service..")
            .should().dependOnClassesThat()
            .resideInAPackage("ua.vkireiev.testing.module08.exercise0802.controller..")
            .because("Services should not depend on controllers to maintain proper layering");

        rule.check(new ClassFileImporter().importPackages("ua.vkireiev.testing.module08.exercise0802"));
    }

    @Test
    void task2_ServicesClassesShouldHaveProperNames() {
        ArchRule rule = classes()
            .that().resideInAPackage("ua.vkireiev.testing.module08.exercise0802.service..")
            .and().areNotInterfaces()
            .should().haveSimpleNameEndingWith("Service")
            .because("Service classes should follow naming convention and end with 'Service'");

        rule.check(new ClassFileImporter().importPackages("ua.vkireiev.testing.module08.exercise0802"));
    }

    @Test
    void task3_CustomMethodsInServicesShouldBeAnnotatedWithMyCustomAnnotation() {
        ArchRule rule = methods()
            .that().areDeclaredInClassesThat().resideInAPackage("ua.vkireiev.testing.module08.exercise0802.service..")
            .and().arePublic()
            .and().haveNameContaining("custom")
            .should().beAnnotatedWith(MyCustomAnnotation.class)
            .because("Method custom() in service classes should be annotated with '@MyCustomAnnotation'");

        rule.check(new ClassFileImporter().importPackages("ua.vkireiev.testing.module08.exercise0802"));
    }

    @Test
    void task4_NoCycles() {
        ArchRule noCyclesRule = SlicesRuleDefinition.slices()
            .matching("..exercise0802.(*)..")
            .should().beFreeOfCycles();

        noCyclesRule.check(new ClassFileImporter().importPackages("ua.vkireiev.testing.module08.exercise0802"));
    }

    @Test
    void task5_RepositoryClassesShouldImplementRepositoryInterface() {
        ArchRule rule = classes()
            .that().resideInAPackage("ua.vkireiev.testing.module08.exercise0802.repository..")
            .and().areNotInterfaces()
            .should().implement(Repository.class)
            .because("Repository classes should implement Repository<T, V> interface");

        rule.check(new ClassFileImporter().importPackages("ua.vkireiev.testing.module08.exercise0802"));
    }
}
