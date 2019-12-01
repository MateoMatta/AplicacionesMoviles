package edu.co.icesi.appmoviles.proyectofinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

     Button acept_btn;
     Button back_btn;
     EditText verify_password_et;
     EditText new_password_et;
     EditText re_password_et;
     EditText new_email_et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        acept_btn = findViewById(R.id.acept_btn_settings);
        back_btn = findViewById(R.id.back_btn_settings);
        verify_password_et = findViewById(R.id.pass_et_settings);
        new_password_et = findViewById(R.id.newPass_et_settings);
        re_password_et = findViewById(R.id.repass_et_settings);
        new_email_et = findViewById(R.id.emailNew_et_settings);

    }
}
