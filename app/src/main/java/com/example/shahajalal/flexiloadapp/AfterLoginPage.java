package com.example.shahajalal.flexiloadapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AfterLoginPage extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout bkash,flexiload,rocket,mcash,ucash,prepaidcard,offer,addreseller,history,resellers;
    private TextView balanceshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_page);

        balanceshow=findViewById(R.id.balanceshowid);

        addreseller=findViewById(R.id.addresellerid);
        history=findViewById(R.id.historyid);
        resellers=findViewById(R.id.resellersid);
        bkash=findViewById(R.id.bkashid);
        flexiload=findViewById(R.id.flexiloadid);
        rocket=findViewById(R.id.rocketid);
        mcash=findViewById(R.id.mcashid);
        ucash=findViewById(R.id.ucashid);
        prepaidcard=findViewById(R.id.prepaidcardid);
        offer=findViewById(R.id.offerid);

        addreseller.setOnClickListener(this);
        history.setOnClickListener(this);
        resellers.setOnClickListener(this);
        bkash.setOnClickListener(this);
        flexiload.setOnClickListener(this);
        rocket.setOnClickListener(this);
        mcash.setOnClickListener(this);
        ucash.setOnClickListener(this);
        prepaidcard.setOnClickListener(this);
        offer.setOnClickListener(this);

        SharedPreferences prefs = getSharedPreferences("prefName", MODE_PRIVATE);
        String getNamepass=prefs.getString("name",null);
        String s[]=getNamepass.split(" ");
        Log.d("balance", "onCreate: "+s[3]);

        balanceshow.setText(s[3]);



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.flexiloadid){
            Intent intent=new Intent(AfterLoginPage.this,FlexiLoad.class);
            startActivity(intent);

        }else if(v.getId()==R.id.bkashid){
            Intent intent1=new Intent(AfterLoginPage.this,Bkash.class);
            startActivity(intent1);

        }else if(v.getId()==R.id.rocketid){
            Intent intent2=new Intent(AfterLoginPage.this,Rocket.class);
            startActivity(intent2);

        }else if(v.getId()==R.id.mcashid){
            Intent intent3=new Intent(AfterLoginPage.this,Mcash.class);
            startActivity(intent3);

        }else if(v.getId()==R.id.ucashid){
            Intent intent4=new Intent(AfterLoginPage.this,Ucash.class);
            startActivity(intent4);

        }else if(v.getId()==R.id.prepaidcardid){
            Intent intent5=new Intent(AfterLoginPage.this,PrepaidCard.class);
            startActivity(intent5);

        }else if(v.getId()==R.id.addresellerid){
            Intent intent7=new Intent(AfterLoginPage.this,Addreseller.class);
            startActivity(intent7);

        }else if(v.getId()==R.id.historyid){
            Intent intent8=new Intent(AfterLoginPage.this,History.class);
            startActivity(intent8);

        }else if(v.getId()==R.id.resellersid){
            Intent intent9=new Intent(AfterLoginPage.this,Resellers.class);
            startActivity(intent9);

        }

        else{
            Intent intent6=new Intent(AfterLoginPage.this,Offer.class);
            startActivity(intent6);

        }
    }
}
