package com.example.user.quizer;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameInfoFragment extends Fragment {

    TextView gameInfoPointsTextView;
    TextView levelTextview;

    public GameInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_game_info, container, false);
        gameInfoPointsTextView = (TextView) view.findViewById(R.id.game_info_points_textview);
        levelTextview = (TextView) view.findViewById(R.id.fragment_game_LEVEL_textview);

        return view;
    }


    public void displayQuestionNumber(int number){

        gameInfoPointsTextView.setText(number+"");
    }

    public void endGame(){
        levelTextview.setText("Your max level");
    }
}
