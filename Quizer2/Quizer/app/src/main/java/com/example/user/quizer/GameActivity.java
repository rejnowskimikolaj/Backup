package com.example.user.quizer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.Question;
import utils.QuestionLoader;

public class GameActivity extends AppCompatActivity {

    public static final String QUESTION_TAG = "question";
    private List<Question> questions;
    private ListView levelListView;
    AlertDialog levelAlert;

    private List<String> levelList;

    QuestionFragment questionFragment;
    GameInfoFragment gameInfoFragment;
    LifeBeltFragment lifeBeltFragment;
    private int questionNumber;
    final private int QUESTIONMAXDIFFICULTY=14;

    public void setLevelList(){
        levelList = new ArrayList<>();
        int [] arr = {100,200,300,500,1000,2000,4000,8000,16000,32000,64000,125000,500000,1000000};

        for(int i:arr){
            levelList.add(i+"");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        setLevelList();
        questions = new ArrayList<>();
        QuestionLoader questionLoader= new QuestionLoader(R.raw.questions,this);
        questionLoader.loadQuestions();
        questions=questionLoader.getQuestionList();

       // Log.d("QUESTIONSLIST", questions.size()+"");

        Bundle questionArguments = new Bundle();
        questionArguments.putParcelable(QUESTION_TAG,getDifficultyQuestion(questionNumber));
        questionFragment = new QuestionFragment();
        questionFragment.setArguments(questionArguments);

        questionNumber=0;

        gameInfoFragment=new GameInfoFragment();

        lifeBeltFragment = new LifeBeltFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.game_activity_game_info_frame, gameInfoFragment).commit();

        getFragmentManager().beginTransaction()
                .add(R.id.game_activity_question_frame, questionFragment).commit();
        getFragmentManager().beginTransaction()
                .add(R.id.activity_game_lifeBelt_frame, lifeBeltFragment).commit();
    }

    public void onAnswerSelected(String text,Question question){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();


        Log.d("question number", questionNumber+"");
        Log.d("max diff", QUESTIONMAXDIFFICULTY+"");

        if(text.equals(QuestionFragment.CORRECT_ANSWER_TAG)) {

            if(questionNumber==QUESTIONMAXDIFFICULTY){
                ///WIN

                GameFinishedFragment gameFinishedFragment = getNewFinishedFragmentWithResult(GameFinishedFragment.GAME_WON_TAG,question);
                getFragmentManager().beginTransaction()
                        .replace(R.id.game_activity_question_frame, gameFinishedFragment).commit();
                    gameInfoFragment.endGame();

            }


            else {
                ///NEXT QUESTION

                displayDialog(questionNumber);
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

            GameFinishedFragment gameFinishedFragment = getNewFinishedFragmentWithResult(GameFinishedFragment.GAME_LOST_TAG,question);
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

    public GameFinishedFragment getNewFinishedFragmentWithResult(String text,Question question){

            Bundle gameFinishedArguments = new Bundle();
            gameFinishedArguments.putString(QuestionFragment.RESULT_TAG,text);
            gameFinishedArguments.putParcelable(QUESTION_TAG,question);



            GameFinishedFragment gameFinishedFragment = new GameFinishedFragment();

            gameFinishedFragment.setArguments(gameFinishedArguments);

            return  gameFinishedFragment;

    }

        public QuestionFragment getQuestionFragment(){
            return this.questionFragment;
        }

        public void useCallLifebelt() {
            this.questionFragment.useCallLifebelt();
        }

        public void useAskLifebelt() {
            this.questionFragment.useAskLifeBelt();
        }

        public void useFiftyLifebelt() {
            this.questionFragment.useFiftyLifebelt();
        }

        public void displayDialog(final int level){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            levelListView = new ListView(this);

            ArrayAdapter adapter = new ArrayAdapter(this,R.layout.level_dialog_item,levelList) {



                @NonNull
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);


                    textView.setText(levelList.get(position));
                    if(position<=level) {
                        textView.setTextColor(getResources().getColor(R.color.green));
                    }
                    return textView;
                }
            };



            levelListView.setAdapter(adapter);


            builder.setView(levelListView);
            levelAlert = builder.create();
            levelAlert.show();
        }

}
