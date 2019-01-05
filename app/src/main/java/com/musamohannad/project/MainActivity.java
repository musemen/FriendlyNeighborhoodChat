package com.musamohannad.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    public MainActivity(TextView mTextMessage) {
        this.mTextMessage = mTextMessage;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoprofile(View v){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

    public void gotoChat(View v){
        Intent intent = new Intent(this, Requests.class);
        startActivity(intent);
    }

    public void gotoRequest(View v){
        Intent intent = new Intent(this, Chat.class);
        startActivity(intent);
    }


}
