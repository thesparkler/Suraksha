package com.example.suraksha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AboutUs extends AppCompatActivity {
    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        TextView tv = (TextView) findViewById(R.id.toolbar_title);
        tv.setText(R.string.about);

    }

    public void back(View v) {

        Intent i = new Intent(getApplicationContext(), NavigationAlert.class);
        startActivity(i);


    }

    public void call(View v) {

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "07340624186"));
        startActivity(intent);
    }

}
