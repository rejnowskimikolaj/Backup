package com.example.rent.daggerapplication;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by RENT on 2017-01-19.
 */

@Singleton
public class Buildings {

    @Inject
    public Buildings() {
    }

    public int countCost() {
        return 3;
    }



    public int countProduction() {
        return 2000;
    }
}
