package learn.junitia.ch02core.lifecycle;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SystemUnderTestTest {
    private static ResourceForAll resource;
    private SystemUnderTest sut;

    @BeforeAll
    static void setUpClass() {
        resource = new ResourceForAll("Resource for all tests");
    }

    @AfterAll
    static void tearDownClass() {
        resource.close();
    }

    @BeforeEach
    void setUp() {
        sut = new SystemUnderTest("System under test");
    }

    @AfterEach
    void tearDown() {
        sut.close();
    }

    @Test
    void testRegular() {
        boolean canReceiveRegular = sut.canReceiveRegular();
        assertTrue(canReceiveRegular);
    }

    @Test
    void testAdditional() {
        boolean canReceiveAdditional = sut.canReceiveAdditional();
        assertFalse(canReceiveAdditional);
    }
}