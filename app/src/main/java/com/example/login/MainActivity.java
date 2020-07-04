package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {
    private EditText et_username; //Input email address
    private EditText et_password; //Input password
    private Button bt_log; //Login Button
    private String regEx =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
    private Map<String, String> data = new HashMap<String, String>(){{ //Email-password data
        put("admin@example.com", "admin");
        put("loulan@example.com.cn", "loulan");
        put("try@example.cn", "try");
        put("test@192.11.26.1", "test");
    }};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Generate layout
        setContentView(R.layout.activity_main);

        //Variables
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_log = (Button) findViewById(R.id.bt_log);

        //Login
        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get data input by user.
                String strUsername = et_username.getText().toString();
                String strPassword = et_password.getText().toString();
                Matcher matcherObj = Pattern.compile(regEx).matcher(strUsername); //Check email
                //check validation
                if (matcherObj.matches()) { //If the email is valid.
                    if (data.containsKey(strUsername)){ //if the email exists.
                        if (data.get(strUsername).equals(strPassword)) { //Check password correctness
                            Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent();
                            intent.setClass(MainActivity.this, AppActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
                        }
                    } else { //If the email is new, sign-up first.
                        Toast.makeText(MainActivity.this, "Username does not exist, please register first!", Toast.LENGTH_SHORT).show();
                    }
                }
                else //Invalid email.
                {
                    Toast.makeText(MainActivity.this, " Email is inValid", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
