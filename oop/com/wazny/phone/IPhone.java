package com.wazny.phone;

public class IPhone  extends Phone implements Ringeable{
    private String model;
    private String carrier;
    private String ringTone;
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {

        super(versionNumber, batteryPercentage, carrier, ringTone);
        model = versionNumber;
        this.carrier = carrier;
        this.ringTone = ringTone;

    }

    @Override
    public void displayInfo() {
        System.out.println("iPhone " + model + " from " + carrier);

    }

    @Override
    public String ring() {
        return "iPhone " + model + " says " + ringTone;
    }

    @Override
    public String unlock() {
        return "Unlocking via facial recognition";
    }
}
