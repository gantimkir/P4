package com.example.kirill.p4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityEight extends Activity {
    ImageView sunImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);

        // Получим ссылку на солнце
        sunImageView = (ImageView) findViewById(R.id.sun);
        // Анимация для восхода солнца
        android.view.animation.Animation sunRiseAnimation= AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        // Подключаем анимацию к нужному View
        sunImageView.startAnimation(sunRiseAnimation);

        // Получим ссылку на часы
        ImageView clockImageView = (ImageView) findViewById(R.id.clock);
// анимация для вращения часов
        Animation clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn);
        clockImageView.startAnimation(clockTurnAnimation);

        // получим ссылку на часовую стрелку
        ImageView hourImageView = (ImageView) findViewById(R.id.hour_hand);
// анимация для стрелки
        Animation hourTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_turn);
// присоединяем анимацию
        hourImageView.startAnimation(hourTurnAnimation);

    }
}