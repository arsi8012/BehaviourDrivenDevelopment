package ru.netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class DataCard {
        private String numberCard;
        private String balanceCard;
    }

    public static DataCard getDataFirstCard() {
        return new DataCard("5254111122220001", "10000");
    }

    public static DataCard getDataSecondCard() {
        return new DataCard("5254111122220002", "10000");
    }

    public static int balanceFirstCard(int balance, int amountTransfer) {
        int endBalance = balance - amountTransfer;
        return endBalance;
    }

    public static int balanceSecondCard(int balance, int amountTransfer) {
        int endBalance = balance + amountTransfer;
        return endBalance;
    }
}