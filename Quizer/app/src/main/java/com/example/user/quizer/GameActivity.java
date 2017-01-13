package com.example.user.quizer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.Question;
import utils.QuestionLoader;

public class GameActivity extends AppCompatActivity {

    public static final String QUESTION_TAG = "question";
    private List<Question> questions;
    QuestionFragment questionFragment;
    GameInfoFragment gameInfoFragment;
    private int questionNumber;
    final private int QUESTIONMAXDIFFICULTY=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questions = new ArrayList<>();
        QuestionLoader questionLoader= new QuestionLoader(R.raw.questions,this);
        questionLoader.loadQuestions();
        questions=questionLoader.getQuestionList();

        Log.d("QUESTIONSLIST", questions.size()+"");

        Bundle questionArguments = new Bundle();
        questionArguments.putParcelable(QUESTION_TAG,getDifficultyQuestion(questionNumber));
        questionFragment = new QuestionFragment();
        questionFragment.setArguments(questionArguments);

        questionNumber=0;

        gameInfoFragment=new GameInfoFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.game_activity_game_info_frame, gameInfoFragment).commit();

        getFragmentManager().beginTransaction()
                .add(R.id.game_activity_question_frame, questionFragment).commit();
    }

    public void onAnswerSelected(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();


        Log.d("question number", questionNumber+"");
        Log.d("max diff", QUESTIONMAXDIFFICULTY+"");

        if(text.equals(QuestionFragment.CORRECT_ANSWER_TAG)) {

            if(questionNumber==QUESTIONMAXDIFFICULTY){
                ///WIN

                GameFinishedFragment gameFinishedFragment = getNewFinishedFragmentWithResult(GameFinishedFragment.GAME_WON_TAG);
                getFragmentManager().beginTransaction()
                        .replace(R.id.game_activity_question_frame, gameFinishedFragment).commit();
                    gameInfoFragment.endGame();

            }


            else {
                ///NEXT QUESTION
                questionNumber++;
                Bundle questionArguments = new Bundle();
                questionArguments.putParcelable(QUESTION_TAG, getDifficultyQuestion(questionNumber));
                questionFragment = new QuestionFragment();
                questionFragment.setArguments(questionArguments);

                getFragmentManager().beginTransaction()
                        .replace(R.id.game_activity_question_frame, questionFragment).commit();
            }
        }

        else {

            //LOST

            GameFinishedFragment gameFinishedFragment = getNewFinishedFragmentWithResult(GameFinishedFragment.GAME_LOST_TAG);
            getFragmentManager().beginTransaction()
                    .replace(R.id.game_activity_question_frame, gameFinishedFragment).commit();
            gameInfoFragment.endGame();
        }

        gameInfoFragment.displayQuestionNumber(questionNumber);


    }

    public Question getDifficultyQuestion(int questionNumber){


        List<Question> difficultyQuestions = new ArrayList<>();
        Random r = new Random();
        for(Question q: questions){
            if (q.getDifficulty()<=questionNumber) {
                if (q.getDifficulty() == questionNumber) {
                    difficultyQuestions.add(q);
                }
            }

            else break;

        }

        return difficultyQuestions.get(r.nextInt(difficultyQuestions.size()));
    }

    public GameFinishedFragment getNewFinishedFragmentWithResult(String text){

            Bundle gameFinishedArguments = new Bundle();
            gameFinishedArguments.putString(QuestionFragment.RESULT_TAG,text);

            GameFinishedFragment gameFinishedFragment = new GameFinishedFragment();

            gameFinishedFragment.setArguments(gameFinishedArguments);

            return  gameFinishedFragment;

    }
}
