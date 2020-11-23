package learn.junitia.ch02core.tags;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("individual")
@DisplayName("Customer должен")
class CustomerTest {
    public static final String NAME = "Jane Doe";

    @Test
    @DisplayName("возвращать имя, заданное при создании")
    void testCustomer() {
        Customer customer = new Customer(NAME);
        assertEquals(NAME, customer.getName());
    }
}
