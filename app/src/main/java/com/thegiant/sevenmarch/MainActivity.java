package com.thegiant.sevenmarch;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences=getSharedPreferences("themohit96.sharedprefdemo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",editText.getText().toString().trim());
        editor.putBoolean("bool",true);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("themohit96.sharedprefdemo",MODE_PRIVATE);
        String string=sharedPreferences.getString("name","user");
        Boolean remem=sharedPreferences.getBoolean("bool",false);
        Toast.makeText(getApplicationContext(), "bool"+remem, Toast.LENGTH_SHORT).show();
        editText.setText(string);
    }
}
