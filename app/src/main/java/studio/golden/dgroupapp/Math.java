package studio.golden.dgroupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Math extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mNextButton;
    private AdView mAdView;
    private int mCurrentIndex = 0;
    private TrueFalse[] mQuestion = new TrueFalse[]{

            new TrueFalse(R.string.question_one),
            new TrueFalse(R.string.question_two),
            new TrueFalse(R.string.question_three),
            new TrueFalse(R.string.question_four),
            new TrueFalse(R.string.question_five),
            new TrueFalse(R.string.question_six),
            new TrueFalse(R.string.question_seven)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        getSupportActionBar().setTitle("Math Category...");

        mQuestionText = findViewById(R.id.text23);
        final int Question = mQuestion[mCurrentIndex].getmQuestion();
        mQuestionText.setText(Question);

        mNextButton =  findViewById(R.id.next_button);
        mAdView = findViewById(R.id.adViewReasoning);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Math.this,"Next Page Open..",Toast.LENGTH_SHORT).show();
                mCurrentIndex = (mCurrentIndex + 1) % mQuestion.length;

                int question = mQuestion[mCurrentIndex].getmQuestion();
                if((mCurrentIndex + 1) % mQuestion.length ==6){
                    finish();
                    Toast.makeText(Math.this,"Current Affairs  Course Complete..",Toast.LENGTH_SHORT).show();
                }
                mQuestionText.setText(question);

            }
        });
    }
}
