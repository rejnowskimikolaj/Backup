package com.example.rent.daggerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Buildings buildings;
    private Population population;
    private Army army;
    private Economy economy;
    private State state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button=(Button) findViewById(R.id.button);
        this.textView = (TextView) findViewById(R.id.textView);


        EconomyComponent economyComponent = DaggerEconomyComponent.create();


//        buildings = new Buildings();
//        population = new Population();
//        army = new Army(population);
//        economy = new Economy(buildings, army, population);
        state = economyComponent.state();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state.countBalance();
                textView.setText(state.getGold()+"");
            }
        });
    }
}
