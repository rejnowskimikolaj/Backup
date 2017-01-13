package com.example.user.quizer;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFinishedFragment extends Fragment {

    TextView resultTextView;
    FrameLayout layout;
    public static final String GAME_WON_TAG = "won";
    public static final String GAME_LOST_TAG = "lost";




    public GameFinishedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_game_finished, container, false);
       // resultTextView = (TextView)view.findViewById(R.id.game_finished_result_textview);

        layout = (FrameLayout) view.findViewById(R.id.fragmet_game_finished_frame_layout);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            Log.d("bundle", bundle.getString(QuestionFragment.RESULT_TAG));



            if(bundle.getString(QuestionFragment.RESULT_TAG).equals(GAME_WON_TAG)){
                layout.setBackgroundColor(getResources().getColor(R.color.green));
            }
           else{
                layout.setBackgroundColor(getResources().getColor(R.color.red));


            }
        }

        return view;
    }

}
