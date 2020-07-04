package com.example.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppActivity extends Activity {
    private Button bt_bos;//Logout Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Generate layout
        setContentView(R.layout.activity_app);

        //Variables
        bt_bos = (Button) findViewById(R.id.bt_bos);

        //Logout
        bt_bos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}