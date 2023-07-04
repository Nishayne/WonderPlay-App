package com.example.childrengame;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Eitan_game extends AppCompatActivity {
    String SentencesOpt[][] ={{"In the morning we __ to work", "get up", "go", "go"},
        {"After class I __ exercise", "will", "will go", "will"},
        {"Are you __ to grandma's in the evening?", "coming", "will come", "coming"},
        {"We __ to the north tomorrow", "went", "will go", "will go"},
        {"Tomorrow __ wine", "we'll drink", "drink", "we'll drink"}};
//        {"Will you __ a pizza with olives in the evening?", "will order", "order", "ordered"},
//        {"He __ to class tomorrow don't worry", "will come", "come", "came"},
//        {"She __ the pots in the morning", "watered", "kissed", "water"},
//        {"We __ to the party tomorrow", "will go out", "went out", "go out"},
//        {"The baby __ milk before bed", "drank", "drinks", "drunk"},
//        {"__ the message when I turn", "I will listen", "I will listen to", "Will Look"},
//        {"We __ you later", "will join", "join", "joined"},
//        {"you __ later?", "call", "I'll call", "called"}};
//        {"I'll __ you at 8 p.m.", "I'll pick up", "I'll pick up", "I'll pick up"},
//        {"Are you __ ready on time?", "Be", "I will be", "Be"},
//        {"Alex and David __ the rest of the work", "will do", "will do", "will do"},
//        {"Dor and Linui __ at the end of the year", "they will get married", "we will get married", "they will get married"},
//        {"Yossi __ the DJ for Dor's wedding", "will close", "will close", "will close"},
//        {"Yovel and Roy __ from the army at the end of the year", "will be released", "will be released", "will be released"},
//        {"they __ belt soon", "will cut", "we will cut", "will cut"},
//        {"So __ appointment for another two weeks?", "to be determined", "to be determined", "to be determined"},
//        {"The doctor __ a prescription for treatment", "will give", "will give", "will give"},
//        {"The children __ to Noa's birthday", "will be invited", "will be invited", "will be invited"},
//        {"We __ the job successfully", "we will finish", "finish", "we will finish"},
//        {"Soon we will __ the degree", "we will finish", "they will finish", "we will finish"},
//        {"When __ is big", "I will be", "will be", "I will be"},
//        {"We __ for grades at work", "we will wait", "I will wait", "we will wait"},
//        {"we all __ work at the end", "found", "found", "found"} };
//    String SentencesOpt[][] = {{"בבוקר אנחנו __ לעבודה", "נקום", "תקום", "נקום"},
//            {"אחרי השיעור אני __ להתאמן", "אלך", "ילך", "אלך"},
//            {"אתם __ לסבתא בערב ?", "תבואו", "יבואו", "תבואו"},
//            {"אנחנו __ מחר לצפון", "נסע", "אסע", "נסע"},
//            {"מחר __ יין", "אשתה", "ישתה", "אשתה"},
//            {"אתה __ תזמין פיצה עם זיתים בערב ?", "תזמין", "נזמין", "תזמין"},
//            {"הוא __ לשיעור מחר אל תדאג", "יבוא", "תבוא", "יבוא"},
//            {"היא __ את העציצים בבוקר", "תשקה", "נשקה", "תשקה"},
//            {"אנחנו __ מחר למסיבה", "נצא", "יצאו", "נצא"},
//            {"התינוק __ חלב לפני השינה", "ינק", "אנק", "ינק"},
//            {"__ את ההודעה כשאתפנה", "אשמע", "ישמע", "אשמע"},
//            {"אנחנו __ יותר מאוחר אליכם", "נצטרף", "תצטרף", "נצטרף"},
//            {"אתה __ מאוחר יותר ?", "תתקשר", "אתקשר", "תתקשר"},
//            {"אני __ אותך ב20 בערב", "אאסוף", "יאסוף", "אאסוף"},
//            {"את __ מוכנה בזמן ?", "תהיי", "אהיה", "תהיי"},
//            {"אלכס ודויד __ את שאר העבודה", "יעשו", "תעשו", "יעשו"},
//            {"דור ולינוי __ בסוף השנה", "יתחתנו", "נתחתן", "יתחתנו"},
//            {"יוסי __ את הדיג׳י לחתונה של דור", "יסגור", "נסגור", "יסגור"},
//            {"יובל ורועי __ מהצבא בסוף השנה", "ישתחררו", "תשתחררו", "ישתחררו"},
//            {"הם __ חוגר בקרוב", "יגזרו", "נגזור", "יגזרו"},
//            {"אז __ תור לעוד שבועיים ?", "נקבע", "יקבע", "נקבע"},
//            {"הרופא __ מרשם לטיפול", "יתן", "תתן", "יתן"},
//            {"הילדים __ ליומולדת של נועה", "יוזמנו", "תוזמנו", "יוזמנו"},
//            {"אנחנו __ את העבודה בהצלחה", "נסיים", "תסיים", "נסיים"},
//            {"בקרוב אנו __ את התואר", "נסיים", "יסיימו", "נסיים"},
//            {"כש__ גדולה", "אהיה", "יהיה", "אהיה"},
//            {"אנחנו __ לציונים בעבודה", "נחכה", "אחכה", "נחכה"},
//            {"כולנו __ עבודה בסוף", "נמצא", "אמצא", "נמצא"} };
    ArrayList<Integer> optionsList= new ArrayList<Integer>( );
    ImageView v;
    ImageView x;
    TextView Sentence;
    Button OptionOne;
    Button OptionTwo;
    int randomNumber;
    int grade=0;
    int roundNumber=0;
    @Override
    public void onBackPressed()
    {
        EndGame();
    }

    // the function set on the controller the values and the answer , the location of the right ans change any time randomly
    public void SetControllers(int SentIndex)
    {
        //randomaly we choose the two options locations -random -1 or 2
        int randomNumber = new Random().nextInt(2)+1;
        Sentence.setText(SentencesOpt[SentIndex][0]);
        OptionOne.setText(SentencesOpt[SentIndex][randomNumber]);
        OptionTwo.setText(SentencesOpt[SentIndex][3-randomNumber]);
    }

    //take randomal number from the available one ,and set it and the controllers
    public int SetRound()
    {
        if(optionsList.size()!=0&& !(roundNumber>=10)) {
            int randomNumberIndex = new Random().nextInt(optionsList.size());
            randomNumber=optionsList.get(randomNumberIndex);
            optionsList.remove(randomNumberIndex);
            SetControllers(randomNumber);
            roundNumber++;
            return randomNumber;
        }else
            return -1;
    }
    //end game and return to the menu
    public void EndGame()
    {
        Intent HomePage =new Intent(Eitan_game.this,MainActivity.class);
        saveScore();
        startActivity(HomePage);
    }

    public void saveScore()
    {
        SharedPreferences sp = getSharedPreferences("ChildrenGameScore", MODE_PRIVATE);
        int savedValue = sp.getInt("key", 0);
        SharedPreferences.Editor sedt = sp.edit();
        sedt.putInt("key", savedValue+grade);
        sedt.commit();
        Toast.makeText(this, "You got: " + grade + " points", Toast.LENGTH_SHORT).show();

    }
    //this animation should show after every press , its fades in and then out , and then we skip to the next question/end game
    private void startFadeAnimation() {

        // Fade in animation
        ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
        fadeInAnimator.setDuration(1000);
        fadeInAnimator.setInterpolator(new AccelerateInterpolator());

        // Fade out animation
        ObjectAnimator fadeOutAnimator = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f);
        fadeOutAnimator.setDuration(1000);
        fadeOutAnimator.setInterpolator(new AccelerateInterpolator());

        // Chain the animations
        fadeInAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // After the fade in animation ends, start the fade out animation
                fadeOutAnimator.start();
            }
        });

        fadeOutAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // After the fade out animation ends, hide the image
                v.setVisibility(View.GONE);
                if(SetRound()==-1)
                {
                    EndGame();
                }
            }
        });

        // Start the fade in animation
        fadeInAnimator.start();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eitan_game);
        Sentence=findViewById(R.id.Eitan_game_text);
        OptionOne=findViewById(R.id.Eitan_btn1);
        OptionTwo=findViewById(R.id.Eitan_btn2);
        v=findViewById(R.id.v_img);
        //init the available options
        for (int i = 0; i < SentencesOpt.length; i++) {
            optionsList.add(i);
        }
        //init the first load
        SetRound();

        //in case of click on btn1
        findViewById(R.id.Eitan_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z) {
                if(OptionOne.getText().equals(SentencesOpt[randomNumber][3]))
                {
                    //its true give a grade and show v
                    grade++;
                    v.setBackgroundResource(R.drawable.checkmarkvv);
                    v.setVisibility(View.VISIBLE);
                    startFadeAnimation();

                }
                else
                {
                    //its false show x
                    v.setBackgroundResource(R.drawable.xmark);
                    v.setVisibility(View.VISIBLE);
                    startFadeAnimation();


                }
            }
            });
        //in case of click on btn2
        findViewById(R.id.Eitan_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z) {
                if(OptionTwo.getText().equals(SentencesOpt[randomNumber][3]))
                {
                    //its true give a grade and show v
                    grade++;
                    v.setBackgroundResource(R.drawable.checkmarkvv);
                    v.setVisibility(View.VISIBLE);
                    startFadeAnimation();


                }
                else
                {
                    //its false show x
                    v.setBackgroundResource(R.drawable.xmark);
                    v.setVisibility(View.VISIBLE);
                    startFadeAnimation();

                }




            }

        });


    }

}