package com.example.kirill.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityThree extends AppCompatActivity {
    public final static String READ_CODE = "com.example.kirill.p4.RES_CODE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        String MessageFromActivityOne=getIntent().getExtras().getString("MessageFromActivityOne");
        TextView textView_activity3_tv = (TextView)findViewById(R.id.textView_activity3_tv);
        textView_activity3_tv.setText(MessageFromActivityOne);
    }

    public void onClick(View view) {
        Intent intent=new Intent();

        switch (view.getId()) {
            case R.id.button_ReadAndExit:
                CheckBox checkbox=(CheckBox) findViewById(R.id.checkBox_ReadMessageFromActivity1);
                if (checkbox.isChecked()) {
                    intent.putExtra(READ_CODE,"YES");
                    setResult(RESULT_OK,intent);
            } else {
                    intent.putExtra(READ_CODE,"NO");
                    setResult(RESULT_CANCELED,intent);
            }
                finish();
            case R.id.buttonAdvancedToast:
                //создаем и отображаем текстовое уведомление
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Пора покормить кота!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout toastContainer = (LinearLayout) toast.getView();
                ImageView catImageView = new ImageView(getApplicationContext());
                catImageView.setImageResource(R.drawable.cat_bottom);
                toastContainer.addView(catImageView, 0);
                toast.show();
                break;
        }

    }

}
