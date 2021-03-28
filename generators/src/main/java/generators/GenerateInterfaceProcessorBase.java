package generators;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import org.jetbrains.annotations.NotNull;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenerateInterfaceProcessorBase extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        System.out.println("GenerateInterfaceProcessorBase::process");
        @NotNull Map<String, Set<Element>> classesWithMethods = getMethodsGroupedByClass(annotations, roundEnv);
        System.out.println("classesWithMethods.size() = " + classesWithMethods.size());

        for (Map.Entry<String, Set<Element>> entry : classesWithMethods.entrySet()) {
            if (entry.getValue().size() == 0) {
                continue;
            }


            try {
                JavaFileObject builderFile = processingEnv.getFiler()
                        .createSourceFile(entry.getKey() + "IF");

                try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
                    StringBuilder b = new StringBuilder();
                    if (getPackageName(entry.getKey()) != null) {
                        b.append("package ");
                        b.append(getPackageName(entry.getKey()));
                        b.append(";");
                        b.append("\n");
                    }

                    b.append("public interface ");
                    b.append(getSimpleClassName(entry.getKey() + "IF"));
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

    @SuppressWarnings("UnstableApiUsage")
    private @NotNull Map<String, Set<Element>> getMethodsGroupedByClass(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        SetMultimap<String, Element> classesToMethods = HashMultimap.create();

        for (TypeElement annotation : annotations) {
            Set<? extends Element> annotatedMethods = roundEnv.getElementsAnnotatedWith(annotation);

            if (annotatedMethods.size() == 0) {
                continue;
            }

            Set<Element> annotatedMethodsSet = new HashSet<>(annotatedMethods);

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
        return className.substring(lastDot + 1);
    }
}
