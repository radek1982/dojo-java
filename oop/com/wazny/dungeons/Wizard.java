package com.wazny.dungeons;

public class Wizard extends  Human{

    Wizard() {
        super();
        intelligence = 8;
        health = 50;
    }

    public void heal(Human other) {

        other.health+=this.intelligence;

    }

    public void fireball(Human other) {
        other.health-=this.intelligence*3;
    }
}
