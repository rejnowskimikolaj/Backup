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
public class StateTest {

    @InjectMocks
    private State state;

    @Mock
    private Economy economy;

    @Test
    public void countBalanceTest(){

        Mockito.when(economy.countCost()).thenReturn(100);
        Mockito.when(economy.countGain()).thenReturn(10000);
        int gold = state.getGold();
        state.countBalance();
        assert state.getGold()==10000-100+gold;


    }

}
