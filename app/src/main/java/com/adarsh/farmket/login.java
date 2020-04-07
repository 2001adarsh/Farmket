package com.adarsh.farmket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    private TextView goRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setui();
        login.setOnClickListener(this);
        goRegister.setOnClickListener(this);

    }
    private void setui(){
        login = (Button) findViewById(R.id.login);
        goRegister = (TextView) findViewById(R.id.goregister);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.goregister:
                Intent ip = new Intent(getApplicationContext(), register.class);
                startActivity(ip);
                finish();
                break;
        }
    }
}
