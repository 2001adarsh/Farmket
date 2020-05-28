package com.adarsh.farmket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mail, dial, map, webpage;
    private TextView gt_faqs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //Setting up toolbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
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
        mail.setOnClickListener(this);
        dial.setOnClickListener(this);
        map.setOnClickListener(this);
        webpage.setOnClickListener(this);
        gt_faqs.setOnClickListener(this);
    }

    private void visitwebsite(){
        String url = getString(R.string.website);
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void composeEmail(){
        String emailAddress = getString(R.string.emailAdress);
       // Log.d("TAG", "composeEmail: "+ emailAddress);
        Intent it = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + emailAddress));
        it.putExtra(Intent.EXTRA_SUBJECT, "Need Help!");
        if(it.resolveActivity(getPackageManager()) != null){
            startActivity(it);
        }
    }

    private void dialus(){
        String phoneNo = getString(R.string.phoneNo);
       // Log.d("TAG", "dialus: "+phoneNo);
        Intent it = new Intent(Intent.ACTION_DIAL);
        it.setData(Uri.parse("tel:"+ phoneNo));
        if(it.resolveActivity(getPackageManager())!=null){
            startActivity(it);
        }
    }

    private void locateus() {
        String geoLocation = getString(R.string.map_search);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(geoLocation));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void setui(){
        mail = (ImageView) findViewById(R.id.mail_us);
        dial = (ImageView) findViewById(R.id.call_us);
        map = (ImageView) findViewById(R.id.locate_us);
        webpage = (ImageView) findViewById(R.id.webpage);
        gt_faqs = (TextView) findViewById(R.id.faqs_from_cont);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mail_us:
                composeEmail();
                break;
            case R.id.call_us:
                dialus();
                break;
            case R.id.locate_us:
               locateus();
                break;
            case R.id.webpage:
                visitwebsite();
                break;
            case R.id.faqs_from_cont:
                intentProvided(FAQActivity.class);
                break;
            default: break;
        }
    }

    private void intentProvided(Class toClass){
        Intent it = new Intent(getApplicationContext(), toClass);
        startActivity(it);
    }
}
