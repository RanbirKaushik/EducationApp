package studio.golden.dgroupapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class  ChooseCategory extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        Button math = findViewById(R.id.math);
        Button reasoning = findViewById(R.id.reasoning);
        Button science = findViewById(R.id.science);
        Button current_affairs = findViewById(R.id.current_affairs);
        Button english = findViewById(R.id.english);
        getSupportActionBar().setTitle("Choose Category");

        MobileAds.initialize(this,
                "\n" +
                        "ca-app-pub-9508056847332120~1353014232");

        mAdView = findViewById(R.id.adViewChooseCategory);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9508056847332120/9491514230");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCategory.this,Math.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });
        reasoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCategory.this,Reasoning.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCategory.this,Science.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });
        current_affairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCategory.this,CurrentAffairs.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseCategory.this, English.class);
                startActivity(intent);
                mInterstitialAd.show();
            }
        });
    }
}
