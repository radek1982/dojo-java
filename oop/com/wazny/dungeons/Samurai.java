package com.wazny.dungeons;

public class Samurai  extends Human {
    Samurai() {
        health=200;
    }
    public  void deathBlow(Human other) {

        other.health =0;

    }

    public void mediate() {
        health+=health / 2;
    }


    public int howMany() {
        return 0;
    }

}
