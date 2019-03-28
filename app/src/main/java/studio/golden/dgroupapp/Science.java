package studio.golden.dgroupapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Science extends AppCompatActivity {


    private TextView mQuestionText;
    private Button mNextButton;

    private AdView mAdView;
    private int mCurrentIndex = 0;
    private TrueFalse[] mQuestion = new TrueFalse[]{

            new TrueFalse(R.string.question_one_science),
            new TrueFalse(R.string.question_two_science),
            new TrueFalse(R.string.question_three_science),
            new TrueFalse(R.string.question_four_science),
            new TrueFalse(R.string.question_five_science),
            new TrueFalse(R.string.question_six_science),
            new TrueFalse(R.string.question_seven_science)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);


        getSupportActionBar().setTitle("Science Category...");

        mQuestionText = findViewById(R.id.text_view_science);
        final int Question = mQuestion[mCurrentIndex].getmQuestion();
        mQuestionText.setText(Question);

        mNextButton =  findViewById(R.id.next_button_science);

        mAdView = findViewById(R.id.adViewScience);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Science.this,"Next Page Open..",Toast.LENGTH_SHORT).show();

                mCurrentIndex = (mCurrentIndex + 1) % mQuestion.length;

                int question = mQuestion[mCurrentIndex].getmQuestion();
                if((mCurrentIndex + 1) % mQuestion.length ==6){
                    finish();
                    Toast.makeText(Science.this,"Science Course Complete..",Toast.LENGTH_SHORT).show();
                }
                mQuestionText.setText(question);

            }
        });

    }
}
