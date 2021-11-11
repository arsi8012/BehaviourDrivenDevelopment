package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement buttonCard1 = $$("[data-test-id=action-deposit]").first();
    private SelenideElement buttonCard2 = $$("[data-test-id=action-deposit]").last();
    private static SelenideElement balanceCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private static SelenideElement balanceCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public BalancePage transferFromFirstCard() {
        buttonCard1.click();
        return new BalancePage();
    }

    public BalancePage transferFromSecondCard() {
        buttonCard2.click();
        return new BalancePage();
    }

    public static int getCurrentBalanceFirstCard() {
        String selectedValue = balanceCard1.getText();
        String balanceFirstCard = selectedValue.substring(29, selectedValue.indexOf(" ", 29));
        return Integer.parseInt(balanceFirstCard);
    }

    public static int getCurrentBalanceSecondCard() {
        String selectedValue = balanceCard2.getText();
        String balanceFirstCard = selectedValue.substring(29, selectedValue.indexOf(" ", 29));
        return Integer.parseInt(balanceFirstCard);
    }
}