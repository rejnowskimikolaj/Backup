package com.example.rent.daggerapplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by RENT on 2017-01-21.
 */
@Singleton
@Component
public interface EconomyComponent {



    State state();

    Population population();

}
