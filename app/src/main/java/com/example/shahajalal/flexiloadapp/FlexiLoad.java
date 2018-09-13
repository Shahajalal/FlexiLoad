package com.example.shahajalal.flexiloadapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FlexiLoad extends AppCompatActivity {

    private Button send;
    private RadioGroup radioGroup;
    private RadioButton selectradio;
    private EditText mobile,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexi_load);
        radioGroup=findViewById(R.id.radiogroupid);

        send=findViewById(R.id.sendbuttonid);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedid=radioGroup.getCheckedRadioButtonId();
                selectradio=findViewById(selectedid);
                Toast.makeText(FlexiLoad.this,"selected radio is : "+selectradio.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
