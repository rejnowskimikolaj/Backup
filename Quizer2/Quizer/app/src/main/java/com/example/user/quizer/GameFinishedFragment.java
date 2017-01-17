package com.example.user.quizer;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import utils.Question;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFinishedFragment extends Fragment {

    TextView correctAnswerTextView;
    LinearLayout layout;
    Button goToMenuButton;
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
       correctAnswerTextView = (TextView) view.findViewById(R.id.game_finished_correct_answer) ;

        layout = (LinearLayout) view.findViewById(R.id.fragmet_game_finished_frame_layout);

        Bundle bundle = this.getArguments();

        goToMenuButton = (Button) view.findViewById(R.id.game_finished_go_to_menu_button);

        goToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MenuActivity.class);
                startActivity(intent);
            }
        });

        if (bundle != null) {
            Log.d("bundle", bundle.getString(QuestionFragment.RESULT_TAG));



            if(bundle.getString(QuestionFragment.RESULT_TAG).equals(GAME_WON_TAG)){

            }
           else{


                Question question= bundle.getParcelable(GameActivity.QUESTION_TAG);
                String correctAnswer = question.getQuestionText()+" ";
                String[] answersArr = {question.getAnswerA(),question.getAnswerB(),question.getAnswerC(),question.getAnswerD()};
                correctAnswer+=answersArr[question.getCorrectAnswerPointer()];

                correctAnswerTextView.setText(correctAnswer);


            }
        }

        return view;
    }

}
