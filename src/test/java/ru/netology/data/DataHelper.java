package ru.netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

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

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class DataCard {
        private String numberCard;
        private String balanceCard;
        private String amountTransfer;
    }

    public static DataCard getFirstCardData() {
        return new DataCard("5559000000000001", "10000", "1000");
    }

    public static DataCard getSecondCardData() {
        return new DataCard("5559000000000002", "10000", "1000");
    }



    public static int balanceFirstCard(int balance, int sumForTransfer) {
        int endBalance = balance - sumForTransfer;
        return endBalance;

    }

    public static int balanceSecondCard(int balance, int sumForTransfer) {
        int endBalance = balance + sumForTransfer;
        return endBalance;
    }
}