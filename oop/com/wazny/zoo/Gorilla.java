package com.wazny.zoo;

public class Gorilla extends  Mammal {
    public void throwSomething() {
        energyLevel-=5;
        System.out.println("I am throwing something " + energyLevel);

    }

    public void eatBanana() {
        energyLevel+=10;
        System.out.println("I am eating a banana " + energyLevel);

    }

    public void climb() {
        energyLevel-=10;
        System.out.println("I am climbing " + energyLevel);

    }
}
