package learn.junitia.ch08mocks.account;

public class Account {
    private final String id;
    private long balance;

    public Account(String id, long initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public void debit(long amount) {
        balance -= amount;
    }

    public void credit(long amount) {
        balance += amount;
    }

    public long getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }
}
