package edu.co.icesi.appmoviles.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

import edu.co.icesi.appmoviles.proyectofinal.model.QuestionAndAnswer;

public class QuestionsActivity extends AppCompatActivity {

    FirebaseDatabase db;
    private ListView questionsListview;
    private ArrayList<QuestionAndAnswer> questions;
    private ArrayAdapter<QuestionAndAnswer> adapterQuestions;
    private QuestionAndAnswer question;
    private TextView makeQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        db = FirebaseDatabase.getInstance();
        questionsListview = findViewById(R.id.List_View_myQuestions);
        makeQuestion = findViewById(R.id.makequestion_et_myQuestions);

        questions = new ArrayList<>();
        adapterQuestions = new ArrayAdapter<>(QuestionsActivity.this,
                android.R.layout.simple_list_item_1,
                questions);


        questionsListview.setAdapter(adapterQuestions);


        db.getReference().child("questions")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        questions.clear();
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            QuestionAndAnswer theQuestion = child.getValue(QuestionAndAnswer.class);
                            questions.add(theQuestion);

                            Toast.makeText(QuestionsActivity.this, "" + theQuestion.getAnswer() + theQuestion.getQuestion(), Toast.LENGTH_SHORT).show();
                        }
                        adapterQuestions.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


        questionsListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(AreaPost.this,listViewTopics.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT ).show();

                Intent myIntent = new Intent(QuestionsActivity.this, MessageActivity.class);


                myIntent.putExtra("pregunta", questionsListview.getItemAtPosition(i).toString());
//TRABAJAR AQUIIIIIIIIIIIIIIIII----------------------------------------------------------------------------------
                startActivity(myIntent);


            }
        });

        makeQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionsActivity.this, NewPost.class);
                startActivity(i);
            }
        });
        //addChildEventListener()


    }
}