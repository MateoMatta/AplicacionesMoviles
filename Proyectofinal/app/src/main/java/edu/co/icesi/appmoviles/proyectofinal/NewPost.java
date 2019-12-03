package edu.co.icesi.appmoviles.proyectofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
//fgfffff

        String[] areas = {AreaPost.CALCULO, AreaPost.CALCULO_MULTIVARIABLE, AreaPost.ALGEBRA, AreaPost.ESTADISTICA,
                AreaPost.ECUACIONES_DIFERENCIALES, AreaPost.GEOMETRIA};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                areas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        titulo = findViewById(R.id.titulo_et_new_post);
        db = FirebaseDatabase.getInstance();

        texto = findViewById(R.id.post_et_new_post);

        atrasBtn = findViewById(R.id.backPost_btn_new_post);

        spinnerNewPost = findViewById(R.id.spinner_new_post);

        spinnerNewPost.setAdapter(adapter);

        enviarBtn = findViewById(R.id.enviar_btn_new_post);
        enviarBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //Crear una llave
                String uid =  UUID.randomUUID().toString();

                String area = spinnerNewPost.getSelectedItem().toString();

                //
                //Sacar el texto
                String theQuestion = titulo.getText().toString();
                String answer = texto.getText().toString();


                QuestionAndAnswer comment = new QuestionAndAnswer(uid, theQuestion, answer + "", area);
                db.getReference()
                        .child("questions")
                        .child("area")
                        .child(comment.getArea())
                        .child(comment.getUid())
                        .setValue(comment);
                //
            }
        });

    }
}