package learn.junitia.ch02core.hamcrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Эти тесты приведены только для сравнения теста без Hamcrest и с ним.")
class HamcrestListTest {
    private List<String> values;

    @BeforeEach
    public void setUp() {
        values = new ArrayList<>();
        values.add("Michael");
        values.add("John");
        values.add("Edwin");
    }

    @Test
    @DisplayName("Список без Hamcrest")
    void testWithoutHamcrest() {
        assertEquals(3, values.size());
        assertTrue(values.contains("Oliver")
                || values.contains("Jack")
                || values.contains("Harry"));
    }

    @Test
    @DisplayName("Список с Hamcrest")
    void testWithHamcrest() {
        assertThat(values, hasSize(3));
        assertThat(values, hasItem(anyOf(equalTo("Oliver"), equalTo("Jack"), equalTo("Harry"))));
    }
}
