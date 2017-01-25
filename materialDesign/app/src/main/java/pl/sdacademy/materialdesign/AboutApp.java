package pl.sdacademy.materialdesign;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutApp extends AppCompatActivity {

    @BindView(R.id.aboutApp_fab)
    FloatingActionButton actionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        Toolbar toolbar = (Toolbar) findViewById(R.id.aboutApp_toolbar);
        toolbar.setTitle("About app");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.aboutApp_fab)
    public void fabClicked(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
