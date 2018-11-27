package com.example.user.demolottie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final int FRAME = R.id.activity_main_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showIntroFragment();
    }

    public void showIntroFragment() {
        getSupportFragmentManager().beginTransaction().replace(FRAME, IntroFragment.newInstance(this)).commit();
    }

    public void showDownloadFragment() {
        getSupportFragmentManager().beginTransaction().replace(FRAME, fragment_download.newInstance(this)).commit();
    }

    public void showEndFragment() {
        getSupportFragmentManager().beginTransaction().replace(FRAME, fragment_end.newInstance(this)).commit();
    }
}