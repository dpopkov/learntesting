package learn.junitia.ch02core.di;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

class TestInfoTest {
    /* TestInfo is injected into the constructor. */
    TestInfoTest(TestInfo testInfo) {
        System.out.println("Constructor TestInfoTest");
        assertEquals("TestInfoTest", testInfo.getDisplayName());
    }

    /* TestInfo is injected into the method. */
    @BeforeEach
    void setUp(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("testGetNameOfTheMethod(TestInfo)")
                || displayName.equals("display name of the method"));
    }

    /* TestInfo is injected into the method. */
    @Test
    void testGetNameOfTheMethod(TestInfo testInfo) {
        assertEquals("testGetNameOfTheMethod(TestInfo)", testInfo.getDisplayName());
    }

    /* TestInfo is injected into the method. */
    @Test
    @DisplayName("display name of the method")
    void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
        assertEquals("display name of the method", testInfo.getDisplayName());
    }
}
