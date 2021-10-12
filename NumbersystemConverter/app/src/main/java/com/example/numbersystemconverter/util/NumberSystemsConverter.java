package com.example.numbersystemconverter.util;


import com.example.numbersystemconverter.model.Number;

import java.math.BigInteger;

public class NumberSystemsConverter {
    private CurrentNSType currentNSType;
    private String value;

    public NumberSystemsConverter(String nsType, String value) {
        this.calculateEnumType(nsType);
        this.value = value;
    }

    private void calculateEnumType(String nsType) {
        if (nsType.equals("Dec")) {
            this.currentNSType = CurrentNSType.decimal;
        } else if (nsType.equals("Bin")) {
            this.currentNSType = CurrentNSType.binary;
        } else if (nsType.equals("Oct")) {
            this.currentNSType = CurrentNSType.octal;
        } else {
            this.currentNSType = CurrentNSType.hexadecimal;
        }
    }

    public Number calculateNumber() {
        Number number = new Number();

        if (this.isValidNumber()) {
            BigInteger bigInteger = null;
            switch (this.currentNSType) {
                case decimal:
                    bigInteger = new BigInteger(value, 10);
                    break;
                case binary:
                    bigInteger = new BigInteger(value, 2);
                    break;
                case octal:
                    bigInteger = new BigInteger(value, 8);
                    break;
                case hexadecimal:
                    bigInteger = new BigInteger(value, 16);
                    break;
            }
            number.setDecNumber(bigInteger.toString(10));
            number.setBinNumber(bigInteger.toString(2));
            number.setOctNumber(bigInteger.toString(8));
            number.setHexNumber(bigInteger.toString(16));
        }

        return number;
    }

    private boolean isValidNumber() {
        boolean isValid = false;
        if (!value.isEmpty()) {
            switch (this.currentNSType) {
                case decimal:
                    isValid = this.isValidDecNumber();
                    break;
                case binary:
                    isValid = this.isValidBinNumber();
                    break;
                case octal:
                    isValid = this.isValidOctNumber();
                    break;
                case hexadecimal:
                    isValid = this.isValidHexNumber();
                    break;
                default:
                    break;
            }
        }
        return isValid;
    }

    private boolean isValidDecNumber() {
        return true;
    }

    private boolean isValidBinNumber() {
        return true;
    }

    private boolean isValidOctNumber() {
        return true;
    }

    private boolean isValidHexNumber() {
        return true;
    }
}
