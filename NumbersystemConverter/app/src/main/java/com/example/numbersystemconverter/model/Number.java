package com.example.numbersystemconverter.model;

public class Number {
    private String decNumber;
    private String binNumber;
    private String octNumber;
    private String hexNumber;

    public Number() {
        this.decNumber = "0";
        this.binNumber = "0b0";
        this.octNumber = "0o0";
        this.hexNumber = "0x0";
    }

    public Number(String decNumber, String binNumber, String octNumber, String hexNumber) {
        this.decNumber = decNumber;
        this.binNumber = binNumber;
        this.octNumber = octNumber;
        this.hexNumber = hexNumber;
    }

    public String getDecNumber() {
        return decNumber;
    }

    public void setDecNumber(String decNumber) {
        this.decNumber = decNumber;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getOctNumber() {
        return octNumber;
    }

    public void setOctNumber(String octNumber) {
        this.octNumber = octNumber;
    }

    public String getHexNumber() {
        return hexNumber;
    }

    public void setHexNumber(String hexNumber) {
        this.hexNumber = hexNumber;
    }
}
