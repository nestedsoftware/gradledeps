package generators;

import com.google.common.collect.*;
import org.jetbrains.annotations.NotNull;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("generators.InterfaceProperty")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class GenerateInterfaceProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        @NotNull Map<String, Set<Element>> classesWithMethods = getMethodsGroupedByClass(annotations, roundEnv);

        for (Map.Entry<String, Set<Element>> entry : classesWithMethods.entrySet()) {
            if (entry.getValue().size() == 0) {
                continue;
            }

            String className = entry.getKey();
            String packageName = getPackageName(className);

            String builderClassName = className + "IF";
            String builderSimpleClassName = getSimpleGeneratedClassName(builderClassName);

            try {
                JavaFileObject builderFile = processingEnv.getFiler()
                        .createSourceFile(builderClassName);

                try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
                    StringBuilder b = new StringBuilder();
                    if (packageName != null) {
                        b.append("package ");
                        b.append(packageName);
                        b.append(";");
                        b.append("\n");
                    }

                    b.append("public interface ");
                    b.append(builderSimpleClassName);
                    b.append(" {");
                    b.append("\n");

                    entry.getValue().forEach(method -> {
                        String methodName = method.getSimpleName().toString();
                        TypeMirror returnType = ((ExecutableType) method.asType()).getReturnType();

                        b.append(returnType.toString());
                        b.append(" ");
                        b.append(methodName);

                        b.append("();");
                        b.append("\n");
                    });

                    b.append("}");
                    b.append("\n");
                    System.out.println(b);
                    out.println(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return true;
    }

    private @NotNull Map<String, Set<Element>> getMethodsGroupedByClass(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        SetMultimap<String, Element> classesToMethods = HashMultimap.create();

        for (TypeElement annotation : annotations) {
            Set<? extends Element> annotatedMethods = roundEnv.getElementsAnnotatedWith(annotation);

            if (annotatedMethods.size() == 0) {
                continue;
            }

            Set<Element> annotatedMethodsSet = annotatedMethods.stream().collect(Collectors.toSet());

            for (Element method : annotatedMethodsSet) {
                String className = ((TypeElement) method.getEnclosingElement()).getQualifiedName().toString();

                classesToMethods.put(className, method);
            }
        }

        return Multimaps.asMap(classesToMethods);
    }

    private String getPackageName(String className) {
        String packageName = null;
        int lastDot = className.lastIndexOf('.');
        if (lastDot > 0) {
            packageName = className.substring(0, lastDot);
        }
        return packageName;
    }

    private String getSimpleClassName(String className) {
        int lastDot = className.lastIndexOf('.');
        String simpleClassName = className.substring(lastDot + 1);
        return simpleClassName;
    }

    private String getSimpleGeneratedClassName(String generatedClassName) {
        int lastDot = generatedClassName.lastIndexOf('.');
        String simpleGeneratedClassName = generatedClassName.substring(lastDot + 1);
        return simpleGeneratedClassName;
    }


    private void addMethod(Element method) {
        System.out.println("generating method: " + method.getSimpleName());
    }

    private void generateInterface(String className) {
        System.out.println("generating interface for: " + className);
    }
}
