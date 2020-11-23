package learn.junitia.ch02core.lifecycle;

public class SystemUnderTest {
    private final String name;

    public SystemUnderTest(String name) {
        this.name = name;
        log("is initializing");
    }

    public boolean canReceiveRegular() {
        log("can receive regular work");
        return true;
    }

    public boolean canReceiveAdditional() {
        log("cannot receive additional work");
        return false;
    }

    public void close() {
        log("is closing");
    }

    private void log(String action) {
        System.out.println("Resource " + name + " from class " + getClass().getSimpleName() + " " + action + ".");
    }
}
