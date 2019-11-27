package com.example.telecracksapp.izimath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourseTopicsActivity extends AppCompatActivity {

    private ListView listViewTopics;
    private ArrayList<String> topicsNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_topics);

        topicsNames = new ArrayList<>();
        topicsNames.add("EigenValores y Vectores");
        topicsNames.add("¿Cómo multiplicar vectores y matrices?");
        topicsNames.add("¿Qué es un plano tangente?");
        topicsNames.add("¿Qué es la matriz identidad?");
        topicsNames.add("¿Qué es una transformación lineal?");


        listViewTopics = findViewById(R.id.listview_topics);



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview_topic_item, topicsNames);
        listViewTopics.setAdapter(adapter);

        listViewTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CourseTopicsActivity.this,listViewTopics.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT ).show();

                //tv.setText("La edad de " + listViewTopics.getItemAtPosition(i) + " es " + edades[i] + " años.");

            }
        });
    }
}
