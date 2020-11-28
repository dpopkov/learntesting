package learn.junitia.ch08mocks.account;

/**
 * An interface for all the manager implementations.
 */
public interface AccountManager {
    /**
     * A method to find an account by the given userId.
     */
    Account findAccountForUser(String userId);

    /**
     * A method to update the given accout.
     */
    void updateAccount(Account account);
}
