package edu.co.icesi.appmoviles.proyectofinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    EditText postHelp;
    Button back_btn;
    TextView send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        postHelp = findViewById(R.id.post_et_helpActivity);
        back_btn = findViewById(R.id.backPost_btn_new_post);
        send_btn = findViewById(R.id.send_et_helpActivity);

    }
}
