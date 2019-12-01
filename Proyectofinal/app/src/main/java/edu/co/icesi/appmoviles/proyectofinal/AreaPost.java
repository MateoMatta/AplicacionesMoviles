package edu.co.icesi.appmoviles.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AreaPost extends AppCompatActivity {

    private ListView listViewTopics;
    private ArrayList<String> topicsNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_post);
        listViewTopics = findViewById(R.id.listview_topics_areaPost);
        topicsNames = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        String key =extras.getString("tipo ");
        if(key.equals("algebra")){

            //RECORRIDO FIREBASE ALGEBRA

        }if(key.equals("algebraLineal")){

            //RECORRIDO FIREBASE ALGEBRA LINEAL

        }if(key.equals("calculo")){

            //RECORRIDO FIREBASE CALCULO

        }if(key.equals("calculoVarias")){

            //RECORRIDO FIREBASE CALCULO VARIAS

        }if(key.equals("ecuaciones")){

            //RECORRIDO FIREBASE ECUACIONES

        }if(key.equals("geomettia")){

            //RECORRIDO FIREBASE GEOMETRIA

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview_topic_item, topicsNames);
        listViewTopics.setAdapter(adapter);

        listViewTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(AreaPost.this,listViewTopics.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT ).show();

                Intent myIntent = new Intent(AreaPost.this, QuestionsActivity.class);


                myIntent.putExtra("pregunta", listViewTopics.getItemAtPosition(i).toString());
//TRABAJAR AQUIIIIIIIIIIIIIIIII----------------------------------------------------------------------------------
                startActivity(myIntent);


            }
        });
    }
}
