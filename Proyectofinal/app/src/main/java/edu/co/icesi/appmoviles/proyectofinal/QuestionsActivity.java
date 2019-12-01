package edu.co.icesi.appmoviles.proyectofinal;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);



        db = FirebaseDatabase.getInstance();







        adapterQuestions = new ArrayAdapter<>(QuestionsActivity.this,
                android.R.layout.simple_list_item_1,questions);
        questionsListview.setAdapter(adapterQuestions);

        db.getReference().child("questions").child(question.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        questions.clear();
                        for(DataSnapshot child : dataSnapshot.getChildren()){
                            QuestionAndAnswer theQuestion = child.getValue(QuestionAndAnswer.class);
                            questions.add(theQuestion);
                        }
                        adapterQuestions.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        //addChildEventListener()


    }
}