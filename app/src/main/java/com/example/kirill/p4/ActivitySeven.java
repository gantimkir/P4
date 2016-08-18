package com.example.kirill.p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class ActivitySeven extends AppCompatActivity {
    //Создаем массив разделов:
    private String head_array[] = {
            "00. Начало",
            "01. Чем кормить кота.",
            "02. Как гладить кота.",
            "03. Как спит кот.",
            "04. Как играть с котом.",
            "05. Как разговаривать с котом",
            "06. Интересные факты из жизни котов.",
            "07. Как назвать кота.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        // Получим идентификатор ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, head_array));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(ActivitySeven.this, ActivitySevenDetail.class);

                intent.putExtra("head", position);

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }
    // Конвертируем в метры
    private float convertParrotToMeter(float parrot) {
        return (float) (parrot / 7.6);
    }

    // Конвертируем в попугаи
    private float convertMeterToParrot(float meter) {
        return (float) (meter * 7.6);
    }
    public void onClick(View view) {

        RadioButton meterRadioButton = (RadioButton) findViewById(R.id.radioButtonMeters);
        EditText inputEditText = (EditText) findViewById(R.id.editText);

        if (inputEditText.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Введите длину кота",
                    Toast.LENGTH_LONG).show();
            return;
        }

        float inputValue = Float.parseFloat(inputEditText.getText().toString());
        if (meterRadioButton.isChecked()) {
            inputEditText.setText(String
                    .valueOf(convertParrotToMeter(inputValue)));
        } else {
            inputEditText.setText(String
                    .valueOf(convertMeterToParrot(inputValue)));
        }

    }

}
