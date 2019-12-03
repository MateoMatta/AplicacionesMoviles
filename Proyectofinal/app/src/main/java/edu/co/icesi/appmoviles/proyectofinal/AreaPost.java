package edu.co.icesi.appmoviles.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import edu.co.icesi.appmoviles.proyectofinal.control.adapters.CommentAdapter;
import edu.co.icesi.appmoviles.proyectofinal.model.QuestionAndAnswer;

public class AreaPost extends AppCompatActivity {

    public final static String CALCULO = "Cálculo";
    public final static String CALCULO_MULTIVARIABLE = "Cálculo Multivariable";
    public final static String ALGEBRA = "Álgebra";
    public final static String ESTADISTICA = "Estadística";
    public final static String ECUACIONES_DIFERENCIALES= "Ecuaciones Diferenciales";
    public final static String GEOMETRIA = "Geometría";

    private ListView listViewTopics;
    FirebaseDatabase db;
    private ArrayList<QuestionAndAnswer> questions;
    private ArrayAdapter<QuestionAndAnswer> adapterQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_post);

        questions = new ArrayList<>();
        listViewTopics = findViewById(R.id.listview_topics_areaPost);
        db = FirebaseDatabase.getInstance();

        Bundle extras = getIntent().getExtras();
        String key = extras.getString("tipo");

        CommentAdapter eladapter = new CommentAdapter();

        if (key != null) {

            db.getReference().child("questions")
                    .child("area")
                    .child(key)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            questions.clear();
                            for (DataSnapshot child : dataSnapshot.getChildren()) {
                                QuestionAndAnswer theQuestion = child.getValue(QuestionAndAnswer.class);

                                eladapter.addQuestionAndAnswer(new QuestionAndAnswer(theQuestion.getUid(), theQuestion.getQuestion(),
                                        theQuestion.getAnswer(), key));

                                questions.add(theQuestion);

                                //Toast.makeText(AreaPost.this, "" + theQuestion.getAnswer() + theQuestion.getQuestion(), Toast.LENGTH_SHORT).show();
                            }
                            eladapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


        }

       // theQuestions.add(new QuestionAndAnswer("seguriismo?", "nonas", "x"));




        listViewTopics.setAdapter(eladapter);

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
