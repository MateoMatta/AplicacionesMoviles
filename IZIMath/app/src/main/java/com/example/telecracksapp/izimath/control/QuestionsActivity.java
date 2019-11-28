package com.example.telecracksapp.izimath.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.telecracksapp.izimath.R;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String   question = bundle.getString("pregunta");

//TRABAJAR AQUIIIIIIIIIIIIIIIII----------------------------------------------------------------------------------



        }





    }
}
