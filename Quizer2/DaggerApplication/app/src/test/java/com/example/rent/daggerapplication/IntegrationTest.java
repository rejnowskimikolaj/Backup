package com.example.rent.daggerapplication;

import org.junit.Test;

/**
 * Created by RENT on 2017-01-19.
 */

public class IntegrationTest  {

    @Test
    public void test(){

        Buildings buildings = new Buildings();
        Population population = new Population();
        Army army = new Army(population);
        Economy economy = new Economy(buildings,army,population);
        State state = new State(economy);

        System.out.println(state.getGold());
        state.countBalance();
        System.out.println(state.getGold());

    }
}
