package com.semler.challenge;

public class StringValidator {
    private char validatingCharacter;
    private int expectedCount;
    public StringValidator(char validatingCharacter, int expectedCount) {
        this.validatingCharacter = validatingCharacter;
        this.expectedCount = expectedCount;
    }

    public boolean validate(String text) {
        boolean startCounting = false;
        boolean validStatement = false;
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
            if(Character.isDigit(text.charAt(i))) {
                if(!startCounting) {
                    startCounting = true;
                    count = 0;
                } else {
                    startCounting = false;
                    validStatement = isValidCount(count);
                }
            } else if(startCounting && text.charAt(i) == validatingCharacter) {
                count += 1;
            }
        }
        return validStatement;
    }

    private boolean isValidCount(int count) {
        if (count == expectedCount) {
            return true;
        }
        return false;
    }

}
