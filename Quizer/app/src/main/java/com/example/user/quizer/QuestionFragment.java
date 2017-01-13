package com.example.user.quizer;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utils.Question;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    Question question;
    TextView questionTextView;
    Button answerAButton;
    Button answerBButton;
    Button answerCButton;
    Button answerDButton;

    public static final String CORRECT_ANSWER_TAG = "correct";
    public static final String NOT_CORRECT_ANSWER_TAG = "notCorrect";
    public static final String RESULT_TAG = "result";





    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_question, container, false);
        questionTextView = (TextView) view.findViewById(R.id.question_fragment_questionTextView);
        answerAButton = (Button) view.findViewById(R.id.question_fragment_answer_a);
        answerBButton = (Button) view.findViewById(R.id.question_fragment_answer_b);
        answerCButton = (Button) view.findViewById(R.id.question_fragment_answer_c);
        answerDButton = (Button) view.findViewById(R.id.question_fragment_answer_d);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            question = bundle.getParcelable(GameActivity.QUESTION_TAG);
        }


        questionTextView.setText(question.getQuestionText());
        answerAButton.setText(question.getAnswerA());
        answerBButton.setText(question.getAnswerB());
        answerCButton.setText(question.getAnswerC());
        answerDButton.setText(question.getAnswerD());

        setOnclickListeners();

        return view;
    }


    public void setOnclickListeners(){
        AnswerButtonOnClickListener abocl = new AnswerButtonOnClickListener();
        answerAButton.setOnClickListener(abocl);
        answerBButton.setOnClickListener(abocl);
        answerCButton.setOnClickListener(abocl);
        answerDButton.setOnClickListener(abocl);
    }


    public class AnswerButtonOnClickListener implements View.OnClickListener{


        @Override
        public void onClick(View view) {

            int buttonID = view.getId();
            int answerClickedIndex = 100;

            switch (buttonID){
                case R.id.question_fragment_answer_a: answerClickedIndex=0;
                    break;
                case R.id.question_fragment_answer_b: answerClickedIndex=1;
                    break;
                case R.id.question_fragment_answer_c: answerClickedIndex=2;
                    break;
                case R.id.question_fragment_answer_d: answerClickedIndex=3;

            }

            displayMessage(answerClickedIndex);

        }
    }

    public void displayMessage(int answerClickedIndex){

        GameActivity gameActivity = (GameActivity)getActivity();
        if(answerClickedIndex==question.getCorrectAnswerPointer()){
            gameActivity.onAnswerSelected(CORRECT_ANSWER_TAG);

        }

        else{
            gameActivity.onAnswerSelected(NOT_CORRECT_ANSWER_TAG);
        }
    }
}
