package learn.junitia.ch02core.nested;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    /* Fields that must be initialized. */
    private final Gender gender;
    private final String firstName;
    private final String lastName;

    /* Fields that may be null. */
    private final String middleName;
    private final LocalDate becomeCustomer;

    private Customer(Builder builder) {
        this.gender = builder.gender;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.becomeCustomer = builder.becomeCustomer;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBecomeCustomer() {
        return becomeCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return gender == customer.gender &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(middleName, customer.middleName) &&
                Objects.equals(becomeCustomer, customer.becomeCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, firstName, lastName, middleName, becomeCustomer);
    }

    public static class Builder {
        /* Required fields */
        private final Gender gender;
        private final String lastName;
        private final String firstName;
        /* Non-required fields */
        private String middleName;
        private LocalDate becomeCustomer;

        public Builder(Gender gender, String firstName, String lastName) {
            this.gender = gender;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }


        public Builder withBecomeCustomer(LocalDate becomeCustomer) {
            this.becomeCustomer = becomeCustomer;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
