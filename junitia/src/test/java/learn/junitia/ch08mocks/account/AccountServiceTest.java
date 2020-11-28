package learn.junitia.ch08mocks.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void testTransferOk() {
        Account sender = new Account("1", 200);
        Account beneficiary = new Account("1", 100);

        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.add("1", sender);
        mockAccountManager.add("2", beneficiary);

        AccountService service = new AccountService();
        service.setAccountManager(mockAccountManager);

        service.transfer("1", "2", 50);
        assertEquals(150, sender.getBalance());
        assertEquals(150, beneficiary.getBalance());
    }
}