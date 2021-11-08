package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class BalancePage {
    private SelenideElement balanceField = $("[data-test-id=amount] [class=input__control]");
    private SelenideElement whereFromCardField = $("[data-test-id=from] [class=input__control]");
    private SelenideElement addButton = $("[data-test-id=action-transfer]");
    private SelenideElement toCardField = $("[data-test-id=to] input");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");

    public void balanceCard(DataHelper.DataCard fromDataCard) {
        String amount = "500";
        balanceField.setValue(amount);
        whereFromCardField.setValue(fromDataCard.getNumberCard());
        addButton.click();
    }
}