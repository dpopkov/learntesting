package learn.junitia.ch02core.assumptions.environment;

public class JavaSpec implements Comparable<JavaSpec> {
    private final String version;

    public JavaSpec(String version) {
        this.version = version;
    }

    String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "JavaSpec{" +
                "version='" + version + '\'' +
                '}';
    }

    @Override
    public int compareTo(JavaSpec other) {
        double versionThis = Double.parseDouble(this.version);
        double versionThat = Double.parseDouble(other.version);
        return Double.compare(versionThis, versionThat);
    }
}
