package com.example.becca.devoir_08_03_17;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    EditText name;
    EditText email;
    EditText pwd;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = (EditText) findViewById(R.id.et_name);
        email = (EditText) findViewById(R.id.et_mail);
        pwd = (EditText) findViewById(R.id.et_pwd);
        create = (Button) findViewById(R.id.btn_create);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
        create.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    public void Save() {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

}
