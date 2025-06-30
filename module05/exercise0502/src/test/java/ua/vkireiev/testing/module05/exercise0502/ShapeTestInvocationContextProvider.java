package ua.vkireiev.testing.module05.exercise0502;

import org.junit.jupiter.api.extension.*;

import java.util.List;
import java.util.stream.Stream;

public class ShapeTestInvocationContextProvider implements TestTemplateInvocationContextProvider {

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        return Stream.of(
            new Circle("Small Circle", 1.0d),
            new Circle("Middle Circle", 2.0d),
            new Circle("Big Circle", 3.0d),

            new Square("Small Square", 1.0d),
            new Square("Big Square", 3.0d)
        ).map(shape -> new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return shape.getName();
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return List.of(
                    new ParameterResolver() {
                        @Override
                        public boolean supportsParameter(ParameterContext paramCtx, ExtensionContext extCtx) {
                            return paramCtx.getParameter().getType().equals(Shape.class);
                        }

                        @Override
                        public Object resolveParameter(ParameterContext paramCtx, ExtensionContext extCtx) {
                            return shape;
                        }
                    },
                    new ShapeTestExecutionCallback(shape)
                );
            }
        });
    }
}
