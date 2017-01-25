package pl.sdacademy.materialdesign;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private String email;

    private Fragment viewPagerFragment;


    @BindView(R.id.main_activity_tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.activity_main_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ButterKnife.bind(this);


        tabLayout.setupWithViewPager(viewPager);

        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch(position)
                {
                    case 0: return new SpaceFragment();
                    case 1: return new OceanFragment();
                    case 2: return new ForestFragment();

                    default : return new ForestFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch(position)
                {
                    case 0: return "Space";
                    case 1: return "Ocean";
                    case 2: return "Forest";

                    default : return "";
                }
            }
        };
        viewPager.setAdapter(pagerAdapter);


//        this.viewPagerFragment = new SpaceFragment();

//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.main_activity_fragment_frame, viewPagerFragment).commit();

        //this.email = savedInstanceState.getString(LoginActivity.LOGIN_EMAIL);

    }

}
