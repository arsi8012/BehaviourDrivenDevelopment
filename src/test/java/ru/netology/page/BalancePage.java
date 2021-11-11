package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class BalancePage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement whereFromField = $("[data-test-id=from] input");
    private SelenideElement addButton = $("[data-test-id=action-transfer]");

    public void balanceCard(DataHelper.DataCard fromDataCard) {
        String amountTransfer = "500";
        amountField.setValue(amountTransfer);
        whereFromField.setValue(fromDataCard.getNumberCard());
        addButton.click();
    }
}