package com.myandroid.app.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton mBtnDev, mBtnEmail, mbtnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE); // Disable Shoot

        mBtnDev = (ImageButton) findViewById(R.id.btnsearch);
        mBtnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webdev = new Intent();
                webdev.setAction(Intent.ACTION_VIEW);
                webdev.setData(Uri.parse("https://www.google.com/search?q=cusmedroid"));
                startActivity(webdev);
            }
        });

        mBtnEmail = (ImageButton) findViewById(R.id.btnemail);
        mBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emaildev = new Intent();
                emaildev.setAction(Intent.ACTION_VIEW);
                emaildev.setData(Uri.parse("mailto:iyortml@gmail.com"));
                startActivity(emaildev);
            }
        });

        mbtnShare = (ImageButton) findViewById(R.id.btnshare);
        mbtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharedev = new Intent(Intent.ACTION_SEND);
                sharedev.setType("text/plain");
                String body = getString(R.string.shareName);
                String sub = getString(R.string.shareSummary);
                sharedev.putExtra(Intent.EXTRA_SUBJECT, sub);
                sharedev.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(sharedev, "Share Using"));
            }
        });

    }
}