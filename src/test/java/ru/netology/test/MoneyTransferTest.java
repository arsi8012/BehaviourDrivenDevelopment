package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {
    int amountTransfer = 500;

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTransferFromFirstCardToSecondCard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode(authInfo);
        val dashboardPage = verificationPage.verify(verificationCode);
        int balanceStartFirstCard = DashboardPage.getCurrentBalanceFirstCard();
        int balanceStartSecondCard = DashboardPage.getCurrentBalanceSecondCard();
        val balancePage = dashboardPage.transferFromFirstCard();
        val dataCard = DataHelper.getSecondCardData();
        balancePage.balanceCard(dataCard);
        int balanceCard1AfterTransfer = DataHelper.balanceSecondCard(balanceStartFirstCard, amountTransfer);
        int balanceCard2AfterTransfer = DataHelper.balanceFirstCard(balanceStartSecondCard, amountTransfer);
        int balanceFinishFirstCard = DashboardPage.getCurrentBalanceFirstCard();
        int balanceFinishSecondCard = DashboardPage.getCurrentBalanceSecondCard();
        assertEquals(balanceCard1AfterTransfer, balanceFinishFirstCard);
        assertEquals(balanceCard2AfterTransfer, balanceFinishSecondCard);
    }

    @Test
    void shouldTransferFromSecondCardToFirstCard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode(authInfo);
        val dashboardPage = verificationPage.verify(verificationCode);
        int balanceStartFirstCard = DashboardPage.getCurrentBalanceFirstCard();
        int balanceStartSecondCard = DashboardPage.getCurrentBalanceSecondCard();
        val balancePage = dashboardPage.transferFromSecondCard();
        val dataCard = DataHelper.getFirstCardData();
        balancePage.balanceCard(dataCard);
        int balanceCard1AfterTransfer = DataHelper.balanceSecondCard(balanceStartSecondCard, amountTransfer);
        int balanceCard2AfterTransfer = DataHelper.balanceFirstCard(balanceStartFirstCard, amountTransfer);
        int balanceFinishFirstCard = DashboardPage.getCurrentBalanceSecondCard();
        int balanceFinishSecondCard = DashboardPage.getCurrentBalanceFirstCard();
        assertEquals(balanceCard1AfterTransfer, balanceFinishFirstCard);
        assertEquals(balanceCard2AfterTransfer, balanceFinishSecondCard);
    }
}