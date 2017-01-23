package com.example.rent.daggerapplication;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by RENT on 2017-01-19.
 */
@Singleton
public class State {

    private int gold=1000;
    private Economy economy;


    public Economy getEconomy() {
        return economy;
    }

    public void setEconomy(Economy economy) {
        this.economy = economy;
    }

    @Inject
    public State(Economy economy) {
        this.economy=economy;
    }

    public int getGold
            () {
        return gold;
    }

    public void setMoney(int money) {
        this.gold= money;
    }

    public void countBalance(){
        gold= gold-economy.countCost()+economy.countGain();
    }
}
