package com.example.kirill.p4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityFour extends AppCompatActivity {
    private static final String KEY_COUNT = "COUNT";
    private int mCount=0;

    private final int CAMERA_RESULT = 0;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        TextView textViewOrientationCounter=(TextView) findViewById(R.id.textViewOrientationCounter);
        if (savedInstanceState!=null){
            mCount=savedInstanceState.getInt(KEY_COUNT);
            mCount++;
            textViewOrientationCounter.setText(Integer.toString(mCount));
        }

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT,mCount);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonCamera1:
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_RESULT);
                break;
//            case R.id.buttonSaveIntPref:
//
//                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_RESULT) {
            mImageView = (ImageView) findViewById(R.id.imageView);
            Bitmap thumbnailBitmap = (Bitmap) data.getExtras().get("data");
            mImageView.setImageBitmap(thumbnailBitmap);
        }
    }
}
