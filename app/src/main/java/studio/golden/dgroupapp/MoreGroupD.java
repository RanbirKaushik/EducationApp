package studio.golden.dgroupapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MoreGroupD extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_group_d);

        Button english_more = findViewById(R.id.english_more);
        Button hindi_more = findViewById(R.id.hindi_more);

        getSupportActionBar().setTitle("More Information Category..");

        mAdView = findViewById(R.id.adViewMoreInfo);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9508056847332120/7053053155");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        english_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreGroupD.this,EnglishMoreActivity.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });

        hindi_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreGroupD.this,HindiMore.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });
    }
}
