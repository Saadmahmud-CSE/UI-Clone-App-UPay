package com.saad.cse.upay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logo = findViewById(R.id.upayLogo);
        TextView slogan = findViewById(R.id.bnSlogan);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);

        logo.startAnimation(anim);
        slogan.startAnimation(anim);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
            finish();
        }, 2000);
    }
}