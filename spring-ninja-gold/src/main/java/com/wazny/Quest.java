package com.wazny;

import java.util.List;
import java.util.Random;

public class Quest {
    public String name;;
    public Integer minGold;
    public Integer maxGold;

    public Quest(String name, Integer minGold, Integer maxGold) {
        this.name = name;
        this.minGold = minGold;
        this.maxGold = maxGold;
    }

    public static Quest findQuest(String name, List<Quest> quests) {

        Quest res = quests.stream().filter(q-> q.name.equalsIgnoreCase(name)).findFirst().get();

        return res;
    }


    public String getDescription() {

        String op = minGold<0 ? "Earns or loses" : "Earns";
        int mgold = minGold <0? 0:minGold;
        return  String.format(" ( %s %d-%d gold )", op, mgold, maxGold);
    }

    public Integer getResult() {
        return new Random().nextInt(this.maxGold) + minGold;
    }
}
