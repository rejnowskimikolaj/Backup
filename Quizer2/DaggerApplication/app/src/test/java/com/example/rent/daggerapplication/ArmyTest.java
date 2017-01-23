package com.example.rent.daggerapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by RENT on 2017-01-21.
 */

@RunWith(MockitoJUnitRunner.class)
public class ArmyTest {

    @Mock
    private Population population;

    @InjectMocks
    private Army army;

    @Test
    public void countCostTest(){

        Mockito.when(population.getCount()).thenReturn(1000);
        assert army.countCost() == 200;
    }
}
