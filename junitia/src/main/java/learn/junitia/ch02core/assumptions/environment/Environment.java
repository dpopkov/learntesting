package learn.junitia.ch02core.assumptions.environment;

public class Environment {
    private final JavaSpec javaSpecification;
    private final OperationSystem operationSystem;

    public Environment(JavaSpec javaSpec, OperationSystem os) {
        this.javaSpecification = javaSpec;
        this.operationSystem = os;
    }

    public boolean isWindows() {
        return operationSystem.getName().contains("Windows");
    }

    public boolean isLinux() {
        return operationSystem.getName().contains("Linux");
    }

    public boolean isAmd64Architecture() {
        return operationSystem.getArchitecture().equals("amd64");
    }

    public JavaSpec getJavaSpecification() {
        return javaSpecification;
    }
}
