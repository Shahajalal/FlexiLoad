package com.example.shahajalal.flexiloadapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";

    private final String DefaultUnameValue = "";
    private final String DefaultPasswordValue = "";

    private EditText name,pass;
    private Button login;
    String username,userpass;
    String s[];
    private String UnameValue;
    private String PasswordValue;

    String phone,imei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nameid);
        pass=findViewById(R.id.passid);
        login=findViewById(R.id.loginbutton);


        phone = Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();


        imei = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCall();
                SharedPreferences prefs = getSharedPreferences("prefName", MODE_PRIVATE);
                String getNamepass=prefs.getString("name",null);
                s=getNamepass.split(" ");

                if(username.equals(s[0]) && userpass.equals(s[1])){

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Please give code");

                    final EditText input = new EditText(MainActivity.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    builder.setView(input);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String m_Text = input.getText().toString();
                            int intcode=Integer.parseInt(m_Text);
                            int getcode=Integer.parseInt(s[2]);
                            try {
                                if (intcode == getcode) {
                                    Intent intent = new Intent(MainActivity.this, AfterLoginPage.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Invalid Code", Toast.LENGTH_LONG).show();
                                }
                            }catch (Exception e){
                                Toast.makeText(MainActivity.this,"Please give numeric value",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();

                }else{
                    Toast.makeText(MainActivity.this,"Invalid user name or password",Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        savePreferences();

    }

    @Override
    public void onResume() {
        super.onResume();
        loadPreferences();
    }


    private void savePreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        // Edit and commit
        UnameValue = name.getText().toString();
        PasswordValue = pass.getText().toString();
        System.out.println("onPause save name: " + UnameValue);
        System.out.println("onPause save password: " + PasswordValue);
        editor.putString(PREF_UNAME, UnameValue);
        editor.putString(PREF_PASSWORD, PasswordValue);
        editor.commit();
    }

    private void loadPreferences() {

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        // Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);
        name.setText(UnameValue);
        pass.setText(PasswordValue);
        System.out.println("onResume load name: " + UnameValue);
        System.out.println("onResume load password: " + PasswordValue);
    }

    void loginCall(){
        username=name.getText().toString();
        userpass=pass.getText().toString();
        String method="login";
        BackgroundTask backgroundTask=new BackgroundTask(MainActivity.this);
        backgroundTask.execute(method,username,userpass);
    }





}
