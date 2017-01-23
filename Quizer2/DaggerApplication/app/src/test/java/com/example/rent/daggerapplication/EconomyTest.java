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
public class EconomyTest {

    @Mock
    private Buildings buildings;
    @Mock
    private Army army;
    @Mock
    private Population population;

    @InjectMocks
    private Economy economy;

    @Test
    public void testCountGain(){
        Mockito.when(buildings.countProduction()).thenReturn(1000);
        Mockito.when(population.countTaxes()).thenReturn(500);

        assert economy.countGain()==1500;

    }

    @Test
    public void testCountCost(){
        Mockito.when(army.countCost()).thenReturn(100);
        Mockito.when(buildings.countCost()).thenReturn(200);

        assert economy.countCost()==300;

    }
}
