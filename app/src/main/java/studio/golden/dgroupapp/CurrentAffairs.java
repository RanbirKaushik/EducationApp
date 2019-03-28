package studio.golden.dgroupapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class CurrentAffairs extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mNextButton;

    private int mCurrentIndex = 0;

    private AdView mAdView;
    private TrueFalse[] mQuestion = new TrueFalse[]{

            new TrueFalse(R.string.question_one_current_affairs),
            new TrueFalse(R.string.question_two_current_affairs),
            new TrueFalse(R.string.question_three_current_affairs),
            new TrueFalse(R.string.question_four_current_affairs),
            new TrueFalse(R.string.question_five_current_affairs),
            new TrueFalse(R.string.question_six_current_affairs),
            new TrueFalse(R.string.question_seven_current_affairs)

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_affairs);
        getSupportActionBar().setTitle("Current Affairs Category...");

        mQuestionText = findViewById(R.id.text_view_current_affairs);
        final int Question = mQuestion[mCurrentIndex].getmQuestion();
        mQuestionText.setText(Question);

        mNextButton =  findViewById(R.id.next_button_current_affairs);

        mAdView = findViewById(R.id.adViewCurrentAffairs);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CurrentAffairs.this,"Next Page Open..",Toast.LENGTH_SHORT).show();
                mCurrentIndex = (mCurrentIndex + 1) % mQuestion.length;

                int question = mQuestion[mCurrentIndex].getmQuestion();
                if((mCurrentIndex + 1) % mQuestion.length ==6){
                    finish();
                    Toast.makeText(CurrentAffairs.this,"Current Affairs  Course Complete..",Toast.LENGTH_SHORT).show();
                }
                mQuestionText.setText(question);

            }
        });
    }
}
