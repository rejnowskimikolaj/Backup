package com.example.rent.daggerapplication;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by RENT on 2017-01-19.
 */

@Singleton
public class Economy {


    private Buildings buildings;
    private Army army;
    private Population population;

    @Inject
    public Economy(Buildings buildings, Army army, Population population) {
        this.buildings = buildings;
        this.army = army;
        this.population = population;
    }

    public Buildings getBuildings() {
        return buildings;
    }

    public void setBuildings(Buildings buildings) {
        this.buildings = buildings;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public int countGain() {
        return buildings.countProduction() + population.countTaxes();
    }

    public int countCost() {
        return army.countCost()+buildings.countCost();
    }
}
