package com.wazny.dungeons;

public class Ninja  extends  Human{
    Ninja() {
        super();
        stealth = 10;
    }

    void steal(Human other) {
        other.health-=this.stealth;
        this.health+=this.stealth;


    }
    void runAway() {
        this.health-=10;
    }
}
