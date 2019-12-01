

package edu.co.icesi.appmoviles.proyectofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class NewPost extends AppCompatActivity {


    private Spinner spinnerNewPost;
    private  EditText titulo;
    private  EditText texto;
    private Button adjuntarArchivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);




        titulo = findViewById(R.id.titulo_et);
        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //--------------------------------------------------------------------------------

            }
        });
        texto= findViewById(R.id.post_et);

        adjuntarArchivo = findViewById(R.id.adjunta_btn);
       // --------------------------------------------------------------------------------

                        adjuntarArchivo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        //
                     ///   --------------------------------------------------------------------------------
                    }
                });
        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}