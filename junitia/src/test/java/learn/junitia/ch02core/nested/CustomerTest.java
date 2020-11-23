package learn.junitia.ch02core.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";

    @Nested
    @DisplayName("Customer.Builder должен")
    class BuilderTest {
        private final String MIDDLE_NAME = "Michael";

        @Test
        @DisplayName("корректно строить объект Customer")
        void customerBuilder() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .withMiddleName(MIDDLE_NAME)
                    .withBecomeCustomer(LocalDate.of(2020, 11, 21))
                    .build();
            assertAll(() -> {
                assertEquals(Gender.MALE, customer.getGender());
                assertEquals(FIRST_NAME, customer.getFirstName());
                assertEquals(LAST_NAME, customer.getLastName());
                assertEquals(MIDDLE_NAME, customer.getMiddleName());
                assertEquals(LocalDate.of(2020, 11, 21), customer.getBecomeCustomer());
            });
        }
    }

    @Nested
    @DisplayName("Customer::equals должен")
    class CustomerEqualsTest {
        private static final String OTHER_FIRST_NAME = "John";
        private static final String OTHER_LAST_NAME = "Doe";

        @Test
        @DisplayName("различать по именам")
        void testDifferentCustomers() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
            Customer other = new Customer.Builder(Gender.MALE, OTHER_FIRST_NAME, OTHER_LAST_NAME).build();
            assertNotEquals(customer, other);
        }

        @Test
        @DisplayName("различать разные объекты с одинаковыми именами")
        void testSameCustomer() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
            Customer other = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();

            assertAll(() -> {
                assertEquals(customer, other);
                assertNotSame(customer, other);
            });
        }
    }

    @Nested
    @DisplayName("Customer::hashCode должен")
    class CustomerHashCodeTest {
        private static final String OTHER_FIRST_NAME = "John";
        private static final String OTHER_LAST_NAME = "Doe";

        @Test
        @DisplayName("возвращать разный хэш для объектов с разными именами")
        void testDifferentCustomers() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
            Customer other = new Customer.Builder(Gender.MALE, OTHER_FIRST_NAME, OTHER_LAST_NAME).build();
            assertNotEquals(customer.hashCode(), other.hashCode());
        }

        @Test
        @DisplayName("возвращать одинаковый хэш для объектов с одинаковыми именами")
        void testSameCustomer() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
            Customer other = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
            assertEquals(customer.hashCode(), other.hashCode());
        }
    }
}
