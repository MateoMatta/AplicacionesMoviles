package edu.co.icesi.appmoviles.proyectofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import edu.co.icesi.appmoviles.proyectofinal.model.QuestionAndAnswer;

public class NewPost extends AppCompatActivity {


    private Spinner spinnerNewPost;
    private EditText titulo;
    private EditText texto;
    private Button enviarBtn;
    private Button atrasBtn;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
//fgff

        titulo = findViewById(R.id.titulo_et_new_post);
        db = FirebaseDatabase.getInstance();

        texto = findViewById(R.id.post_et_new_post);

        atrasBtn = findViewById(R.id.backPost_btn_new_post);

        enviarBtn = findViewById(R.id.enviar_btn_new_post);
        enviarBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Crear una llave
                String uid =  UUID.randomUUID().toString();


                //
                //Sacar el texto
                String text = "uy mano";


                QuestionAndAnswer comment = new QuestionAndAnswer(uid, text, "");
                db.getReference()
                        .child("questions")
                        .child(comment.getUid())
                        .setValue(comment);
                //
            }
        });

    }
}