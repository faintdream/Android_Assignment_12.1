package com.akashdubey.settingspreferencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button launchSettingsPage;
    TextView status;
    String strStatus;

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);

        if(requestCode==100 ){
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
            strStatus="Password: "+sharedPreferences.getString("passwordETP","NOPASSWORD");
            strStatus=strStatus+", Screen Lock: "+sharedPreferences.getBoolean("screenLockCB",false);
            strStatus=strStatus+", Reminder: "+sharedPreferences.getString("reminderETP","0");
            status.setText(strStatus);




        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchSettingsPage=(Button)findViewById(R.id.settingsBtn);
        status=(TextView)findViewById(R.id.statusTV);
        launchSettingsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launch=new Intent(MainActivity.this,Settings.class);
                startActivityForResult(launch,100);
            }
        });


    }
}
