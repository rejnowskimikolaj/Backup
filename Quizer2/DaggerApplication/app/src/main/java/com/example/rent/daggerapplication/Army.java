package com.example.rent.daggerapplication;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by RENT on 2017-01-19.
 */

@Singleton
public class Army {


    private int costPerSoldier=2;
    private double percentOfActiveSoldiers=0.1;
    private Population population;

    @Inject
    public Army(Population population) {
        this.population = population;
    }

    public int countCost() {

        return(int) (costPerSoldier*percentOfActiveSoldiers*population.getCount());
    }

    public int countGain() {
        return 1;
    }
}
