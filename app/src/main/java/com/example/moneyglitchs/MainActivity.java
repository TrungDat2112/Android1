package com.example.moneyglitchs;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edittext1;
    private Spinner spinner, spinner2;
    private TextView  textView2, textView4,textView3, tvanswer;
    private String[] money_icon,money_num;
    private String typ1,typ2,tv1,tv2;
    private ImageView imageView;
    private Button btnCE, btn7, btn8, btn9, btn4, btn5, btn6, btn, btn2, btn3, btn0;
    private double fin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1=findViewById(R.id.edittext1);
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        tvanswer=findViewById(R.id.tvanswer);
        makenumberbutton();
        getData();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               tv1 = money_icon[position];
               textView2.setText(tv1);
               typ1 = money_num[position];
                if (typ1 != null && typ2 != null) {
                    makecountforwhat(typ1, typ2, tv1, tv2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv2 = money_icon[position];
                textView4.setText(tv2);
                typ2= money_num[position];
                if (typ1 != null && typ2 != null) {
                    makecountforwhat(typ1, typ2, tv1, tv2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void makenumberbutton() {
        btnCE = findViewById(R.id.btnCE);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String oldString = edittext1.getText().toString();
                if (oldString.length() > 0) {
                    String newString = oldString.substring(0, oldString.length()-1);
                    if(newString.length() == 0)edittext1.setText("0");
                    else edittext1.setText(newString);
                }else{
                    edittext1.setText("0");
                }
                counter();
            }
        });

        btn0.setOnClickListener(this);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnCE.setOnClickListener(this);
    }

    private void makecountforwhat(String typ1, String typ2, String tv1, String tv2) {

            double x = Double.parseDouble(typ1);
            double y = Double.parseDouble(typ2);
            fin = x / y;
            String tip = "1 " + tv1 + " = " + String.format("%.3f", fin) + " " + tv2;
            textView3.setText(tip);
            counter();
    }

    private void getData() {
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(
                this, R.array.money_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        money_icon = getResources().getStringArray(R.array.monet_icon);
        money_num = getResources().getStringArray(R.array.exchange_rates_to_usd);
    }

    @Override
    public void onClick(View v) {
        String oldString = edittext1.getText().toString();
        int id = v.getId();
        if (id == btnCE.getId()) edittext1.setText("0");
        else if (id == btn0.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("0");
            }else edittext1.setText(oldString + "0");
        }else if (id == btn.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("1");
            }else edittext1.setText(oldString + "1");
        }else if (id == btn2.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("2");
            } else edittext1.setText(oldString + "2");
        }else if (id == btn3.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("3");
            }else edittext1.setText(oldString + "3");
        }else if (id == btn4.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("4");
            } else edittext1.setText(oldString + "4");
        }else if (id == btn5.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("5");
            }else edittext1.setText(oldString + "5");
        }else if (id == btn6.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("6");
            } else edittext1.setText(oldString + "6");
        }else if (id == btn7.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("7");
            }else edittext1.setText(oldString + "7");
        }else if (id == btn8.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("8");
            } else edittext1.setText(oldString + "8");
        }else if (id == btn9.getId()) {
            if (oldString.equals("0")) {
                edittext1.setText("9");
            }else edittext1.setText(oldString + "9");
        };

        counter();

    }

    private void counter() {
        String newString = edittext1.getText().toString();
        double newanser = fin * Double.parseDouble(newString);
        tvanswer.setText(String.format("%.4f", newanser));
    }
}