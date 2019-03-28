package studio.golden.dgroupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class English extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mNextButton;

    private int mCurrentIndex = 0;
    private AdView mAdView;
    private TrueFalse[] mQuestion = new TrueFalse[]{

            new TrueFalse(R.string.question_one_english),
            new TrueFalse(R.string.question_two_english),
            new TrueFalse(R.string.question_three_english),
            new TrueFalse(R.string.question_four_english),
            new TrueFalse(R.string.question_five_english),
            new TrueFalse(R.string.question_six_english),
            new TrueFalse(R.string.question_seven_english)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        mQuestionText = findViewById(R.id.text_view_english);
        final int Question = mQuestion[mCurrentIndex].getmQuestion();
        mQuestionText.setText(Question);

        mNextButton =  findViewById(R.id.next_button_english);

        mAdView = findViewById(R.id.adViewEnglish);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestion.length;
                Toast.makeText(English.this,"Next Page Open..",Toast.LENGTH_SHORT).show();

                int question = mQuestion[mCurrentIndex].getmQuestion();
                if((mCurrentIndex + 1) % mQuestion.length ==6){
                    finish();
                    Toast.makeText(English.this,"English Course Complete..",Toast.LENGTH_SHORT).show();
                }
                mQuestionText.setText(question);

            }
        });

    }
}
