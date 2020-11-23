package learn.junitia.ch02core.lifecycle;

public class ResourceForAll {
    private final String name;

    public ResourceForAll(String name) {
        this.name = name;
        log("is initializing");
    }

    public void close() {
        log("is closing");
    }

    private void log(String action) {
        System.out.println("Resource " + name + " from class " + getClass().getSimpleName() + " " + action + ".");
    }
}
