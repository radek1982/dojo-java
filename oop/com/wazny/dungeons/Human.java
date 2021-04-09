package com.wazny.dungeons;

public class Human {
    int strength = 3, stealth = 3,  intelligence=3;
    int health = 100;

    public void attack(Human other) {
        other.health-=this.strength;
        System.out.println("other health: " + other.health);
    }
}
