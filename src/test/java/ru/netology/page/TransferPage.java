package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    private SelenideElement buttonFirstCard = $$("[data-test-id=action-deposit]").first();
    private SelenideElement buttonSecondCard = $$("[data-test-id=action-deposit]").last();
    private SelenideElement reloadButton = $$("[data-test-id=action-deposit]").last();
    private static SelenideElement balanceFirstCard = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private static SelenideElement balanceSecondCard = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

    public BalancePage transferFromFirstCard() {
        buttonFirstCard.click();
        return new BalancePage();
    }

    public BalancePage transferFromSecondCard() {
        buttonSecondCard.click();
        return new BalancePage();
    }

    public static int getCurrentBalanceFirstCard() {
        String selectedValue = balanceFirstCard.getText();
        String balanceCard1 = selectedValue.substring(29, selectedValue.indexOf(" ", 29));
        return Integer.parseInt(balanceCard1);
    }

    public static int getCurrentBalanceSecondCard() {
        String selectedValue = balanceSecondCard.getText();
        String balanceCard1 = selectedValue.substring(29, selectedValue.indexOf(" ", 29));
        return Integer.parseInt(balanceCard1);
    }
}