package com.example.kirill.p4;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static Integer ACTIVITY3_READ_CODE=0;
    public static final String ACTION_FOURTH_ACTIVITY = "com.example.kirill.p4.ActivityFour";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText_Activity3_SendMessage = (EditText) findViewById(R.id.editText_Activity3_SendMessage);
        editText_Activity3_SendMessage.setEnabled(false);
        editText_Activity3_SendMessage.setFocusable(false);
        CheckBox checkBox_EditActivity3Message=(CheckBox) findViewById(R.id.checkBox_EditActivity3Message);
        checkBox_EditActivity3Message.setChecked(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ACTIVITY3_READ_CODE){
            if (resultCode==RESULT_CANCELED) {
                if (data!=null) {
                    Toast.makeText(this, "Exit with activity button. Answer is: " + data.getStringExtra(ActivityThree.READ_CODE), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Back button pressed", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Exit with activity button. Answer is: " + data.getStringExtra(ActivityThree.READ_CODE), Toast.LENGTH_LONG).show();
            }
//            Toast.makeText(this, "Answer is: " + data.getStringExtra(ActivityThree.READ_CODE), Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View view) {
        Intent intent=new Intent();
        EditText editText_Activity3_SendMessage = (EditText) findViewById(R.id.editText_Activity3_SendMessage);
        CheckBox checkBox_EditActivity3Message=(CheckBox) findViewById(R.id.checkBox_EditActivity3Message);
        switch (view.getId())
        {
            case R.id.buttonGoToActivity2:
                intent.setClass(MainActivity.this,ActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.buttonGoToActivity3:
                intent.setClass(MainActivity.this,ActivityThree.class);
                intent.putExtra("MessageFromActivityOne", editText_Activity3_SendMessage.getText().toString());
                startActivityForResult(intent,ACTIVITY3_READ_CODE);
                break;
            case R.id.buttonGoToActivity4:
                startActivity(new Intent(ACTION_FOURTH_ACTIVITY));
                break;
            case R.id.checkBox_EditActivity3Message:
                if (checkBox_EditActivity3Message.isChecked()) {
                    editText_Activity3_SendMessage.setEnabled(true);
                    editText_Activity3_SendMessage.setFocusable(true);
                    Toast.makeText(this, "editText_Activity3_SendMessage enabled", Toast.LENGTH_LONG).show();
                } else {
                    editText_Activity3_SendMessage.setEnabled(false);
                    Toast.makeText(this, "editText_Activity3_SendMessage disabled", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.buttonOrientation:
                int rotate = getWindowManager().getDefaultDisplay().getRotation();
                String stringRotation = new String();
                switch (rotate) {
                    case Surface.ROTATION_0:
                        stringRotation= "Не поворачивали";
                        break;
                    case Surface.ROTATION_90:
                        stringRotation=  "Повернули на 90 градусов по часовой стрелке";
                        break;
                    case Surface.ROTATION_180:
                        stringRotation=  "Повернули на 180 градусов";
                        break;
                    case Surface.ROTATION_270:
                        stringRotation=  "Повернули на 90 градусов против часовой стрелки";
                        break;
                    default:
                        stringRotation=  "Не понятно";
                }
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    Toast.makeText(this, "ORIENTATION_PORTRAIT. "+stringRotation, Toast.LENGTH_LONG).show();
                }
                 else {
                    Toast.makeText(this, "ORIENTATION_LANDSCAPE. "+stringRotation, Toast.LENGTH_LONG).show();
                }
            case R.id.buttonGoToActivity5:
                intent.setClass(MainActivity.this,ActivityFive.class);
                startActivity(intent);
                break;
            case R.id.buttonGoToActivity6:
                intent.setClass(MainActivity.this,ActivitySix.class);
                startActivity(intent);
                break;
            case R.id.buttonGoToActivity7:
                intent.setClass(MainActivity.this,ActivitySeven.class);
                startActivity(intent);
                break;
            case R.id.buttonGoToActivity8:
                intent.setClass(MainActivity.this,ActivityEight.class);
                startActivity(intent);
                break;
            case R.id.buttonGoToActivity9:
                intent.setClass(MainActivity.this,ActivityNine.class);
                startActivity(intent);
                break;
            case R.id.buttonGoToActivity10:
                intent.setClass(MainActivity.this,ActivityTen.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        // super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                this);
        quitDialog.setTitle("Выход: Вы уверены?");

        quitDialog.setPositiveButton("Таки да!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

    @Override
    protected void onUserLeaveHint() {
        Toast toast = Toast.makeText(getApplicationContext(), "Нажата кнопка HOME", Toast.LENGTH_SHORT);
        toast.show();
        super.onUserLeaveHint();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
                Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                        .show();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                Toast.makeText(this, "Нажата кнопка Поиск", Toast.LENGTH_SHORT)
                        .show();
                return true;
            case KeyEvent.KEYCODE_BACK:
                onBackPressed();
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                event.startTracking();
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT).show();
                return false;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                        .show();
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
