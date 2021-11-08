package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.BalancePage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {
    private int amount = 500;

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferFromFirstCardToSecondCard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val transferPage = verificationPage.validVerify(verificationCode);
        int balanceStartFirstCard = TransferPage.getCurrentBalanceFirstCard();
        int balanceStartSecondCard = TransferPage.getCurrentBalanceSecondCard();
        val balancePage = transferPage.transferFromFirstCard();
        val dataCard = DataHelper.getDataSecondCard();
        balancePage.balanceCard(dataCard);
        int balanceCardAfterTransfer = DataHelper.balanceSecondCard(balanceStartFirstCard, amount);
        int balanceCardAfterDebit = DataHelper.balanceFirstCard(balanceStartSecondCard, amount);
        int balanceFinishFirstCard = TransferPage.getCurrentBalanceFirstCard();
        int balanceFinishSecondCard = TransferPage.getCurrentBalanceSecondCard();
        assertEquals(balanceCardAfterTransfer, balanceFinishFirstCard );
        assertEquals(balanceCardAfterDebit, balanceFinishSecondCard );
    }

    @Test
    void shouldTransferFromSecondCardToFirstCard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        int balanceStartFirstCard = TransferPage.getCurrentBalanceFirstCard();
        int balanceStartSecondCard = TransferPage.getCurrentBalanceSecondCard();
        val balancePage = transferPage.transferFromSecondCard();
        val dataCard = DataHelper.getDataFirstCard();
        balancePage.balanceCard(dataCard);
        int balanceCardAfterTransfer = DataHelper.balanceFirstCard(balanceStartSecondCard, amount);
        int balanceCardAfterDebit = DataHelper.balanceSecondCard(balanceStartFirstCard, amount);
        int balanceFinishFirstCard = TransferPage.getCurrentBalanceSecondCard();
        int balanceFinishSecondCard = TransferPage.getCurrentBalanceFirstCard();
        assertEquals(balanceCardAfterTransfer, balanceFinishFirstCard );
        assertEquals(balanceCardAfterDebit, balanceFinishSecondCard );
    }
}