package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText set_drink;
    private RadioGroup rg1, rg2;
    private Button btn_send;

    private String sugar = "無糖";
    private String ice_opt = "去冰";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg1 = findViewById(R.id.rgSugar);
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i == R.id.radioButton1){
                sugar = "無糖";
            } else if (i == R.id.radioButton2) {
                sugar = "少糖";
            } else if (i == R.id.radioButton3) {
                sugar = "半糖";
            } else if (i == R.id.radioButton4) {
                sugar = "全糖";
            }
        });

        rg2 = findViewById(R.id.rgIce);
        rg2.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i == R.id.radioButton5){
                ice_opt = "去冰";
            } else if (i == R.id.radioButton6) {
                ice_opt = "微冰";
            } else if (i == R.id.radioButton7) {
                ice_opt = "少冰";
            } else if (i == R.id.radioButton8) {
                ice_opt = "正常冰";
            }

        });


        btn_send = findViewById(R.id.btnSend);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.edDrink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", drink);
            b.putString("sugar", sugar);
            b.putString("ice", ice_opt);

            i.putExtras(b);
            setResult(Activity.RESULT_OK, i);

            finish();

        });

    }
}