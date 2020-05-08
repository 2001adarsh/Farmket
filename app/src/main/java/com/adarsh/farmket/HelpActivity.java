package com.adarsh.farmket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ConstraintLayout suggestions,faqs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //Setting up toolbar.
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Further
        setui();
        suggestions.setOnClickListener(this);
        faqs.setOnClickListener(this);
    }
    private void setui(){
        suggestions = (ConstraintLayout) findViewById(R.id.suggestions_given);
        faqs = (ConstraintLayout) findViewById(R.id.faq_from_help);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.suggestions_given:
                intentProvided(SuggestionsActivity.class);
                break;
            case R.id.faq_from_help:
                intentProvided(FAQActivity.class);
                break;
            default:break;
        }
    }

    private void intentProvided(Class toClass){
        Intent it = new Intent(getApplicationContext(), toClass);
        startActivity(it);
    }

}
