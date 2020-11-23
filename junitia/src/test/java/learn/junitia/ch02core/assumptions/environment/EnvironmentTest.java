package learn.junitia.ch02core.assumptions.environment;

import learn.junitia.ch02core.assumptions.Job;
import learn.junitia.ch02core.assumptions.SystemUT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class EnvironmentTest {
    private static final JavaSpec expectedJava = new JavaSpec("8");

    private final Environment environment = new Environment(
            new JavaSpec(System.getProperty("java.vm.specification.version")),
            new OperationSystem(System.getProperty("os.name"), System.getProperty("os.arch"))
    );
    private final SystemUT sut = new SystemUT();

    @BeforeEach
    void setUp() {
        assumeTrue(environment.isLinux());
    }

    @Test
    void testNoJobToRun() {
        assumingThat(
                () -> environment.getJavaSpecification().compareTo(expectedJava) >= 0,
                () -> assertFalse(sut.hasJobToRun()));
    }

    @Test
    void testJobToRun() {
        assumeTrue(environment.isAmd64Architecture());
        sut.run(new Job());
        assertTrue(sut.hasJobToRun());
    }
}
