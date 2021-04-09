package com.wazny.phone;

public class Galaxy extends Phone implements Ringeable{
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }

    @Override
    public void displayInfo() {
        System.out.println("Galaxy " +versionNumber+ " from " + carrier);

    }

    @Override
    public String ring() {
        return "Galaxy " + versionNumber+ " says " + ringTone;
    }

    @Override
    public String unlock() {
        return "Unlocking via finger print";
    }
}
