package com.wazny.zoo;

public class Bat extends  Mammal{
    Bat() {
        super();
        energyLevel = 300;
    }

    public void fly() {

        energyLevel-=50;
        System.out.println("Flying " + energyLevel );
    }
    public void eatHumans() {
        energyLevel+=25;
        System.out.println("Ate a human " + energyLevel);
    }
    public void attackTown() {
        energyLevel-=100;
        System.out.println("Attacked town" + energyLevel);
    }
}
