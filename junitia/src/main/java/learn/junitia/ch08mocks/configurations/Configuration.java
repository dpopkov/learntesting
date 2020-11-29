package learn.junitia.ch08mocks.configurations;

/**
 * This configuration interface is added as part of the refactoring process.
 */
public interface Configuration {
    /**
     * Getter method to get the SQL query to execute.
     */
    String getSQL(String sqlString);
}
