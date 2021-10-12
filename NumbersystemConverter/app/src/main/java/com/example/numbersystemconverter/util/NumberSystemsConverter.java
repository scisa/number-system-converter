package com.example.numbersystemconverter.util;


import com.example.numbersystemconverter.model.Number;

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

        if (isValidNumber()) {
            // TODO: calc Numbers here
        }

        return number;
    }

    private boolean isValidNumber() {
                
        return true;
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
