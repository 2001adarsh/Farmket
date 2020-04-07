package com.adarsh.farmket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class register extends AppCompatActivity implements View.OnClickListener{
    private Button register;
    private TextView goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setui();

        register.setOnClickListener(this);
        goLogin.setOnClickListener(this);

    }

    private void setui(){
        register = (Button) findViewById(R.id.register);
        goLogin = (TextView) findViewById(R.id.goLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                break;
            case R.id.goLogin:
                Intent it = new Intent(getApplicationContext(), login.class);
                startActivity(it);
                finish();
                break;
        }
    }
}
