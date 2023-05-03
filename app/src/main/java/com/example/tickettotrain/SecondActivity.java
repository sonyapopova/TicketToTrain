package com.example.tickettotrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private TextView dataMainActivity; // поле вывода информации из главной активити
    private Button button; 
    private Button button2;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        dataMainActivity = findViewById(R.id.dataUser);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        Bundle bundleIntent = getIntent().getExtras();

        if (bundleIntent != null) {


            user = (User) bundleIntent.getSerializable(User.class.getSimpleName());


            dataMainActivity.setText("Имя " + user.getName() + "\n"
                    + "Из "+ user.getAddress() + "\n" +
                    "Время отправления 10.00 по Мск\n" +
                    "В "+ user.getEmail() + "\n" +
                    "Время прибытия 17.00");
        }

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener2);
    }

    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

            startActivity(intent);
        }
    };
    private View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ThirstActivity.class);
            startActivity(intent);
        }
    };
}