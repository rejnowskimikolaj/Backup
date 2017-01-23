package com.example.rent.daggerapplication;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by RENT on 2017-01-19.
 */

@Singleton
public class Population {


    @Inject
    public Population(){

    }
    private int count =1000;

    public int countCost() {
        return count*-1;
    }

    public int countGain() {
        return 15;
    }

    public int getCount(){
        return count;
    }

    public int countTaxes(){
        return count*3;
    }

    public void setCount(int count){
        this.count=count;
    }
}
