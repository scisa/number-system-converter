package de.chsc.numbersystemconverter.model;

public class Number {
    private String decNumber;
    private String binNumber;
    private String octNumber;
    private String hexNumber;
    private final String BIN_PREFIX = "0b";
    private final String OCT_PREFIX = "0o";
    private final String HEX_PREFIX = "0x";

    public Number() {
        this.decNumber = "0";
        this.binNumber = BIN_PREFIX + "0";
        this.octNumber = OCT_PREFIX + "0";
        this.hexNumber = HEX_PREFIX + "0";
    }

    public Number(String decNumber, String binNumber, String octNumber, String hexNumber) {
        this.decNumber = decNumber;
        this.binNumber = BIN_PREFIX + binNumber;
        this.octNumber = OCT_PREFIX + octNumber;
        this.hexNumber = HEX_PREFIX + hexNumber;
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
        this.binNumber = BIN_PREFIX + binNumber;
    }

    public String getOctNumber() {
        return octNumber;
    }

    public void setOctNumber(String octNumber) {
        this.octNumber = OCT_PREFIX + octNumber;
    }

    public String getHexNumber() {
        return hexNumber;
    }

    public void setHexNumber(String hexNumber) {
        this.hexNumber = HEX_PREFIX + hexNumber;
    }
}
