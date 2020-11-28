package learn.junitia.ch08mocks.account;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManager {
    private final Map<String, Account> accounts = new HashMap<>();

    public void add(String userId, Account account) {
        accounts.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        // does nothing
    }
}
