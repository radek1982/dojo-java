package com.wazny.phone;

public class PhoneTester {
    public static void main(String[] args) {
        Galaxy galaxy = new Galaxy("S9", 99, "Verizon", "Ring Ring Ring");
        IPhone ten = new IPhone("X", 100,"AT&T","Zing");

        galaxy.displayInfo();
        System.out.println(galaxy.ring());
        System.out.println(galaxy.unlock());

        ten.displayInfo();
        System.out.println(ten.ring());
        System.out.println(ten.unlock());
    }
}
