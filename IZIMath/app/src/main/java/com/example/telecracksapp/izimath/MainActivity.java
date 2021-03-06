package com.example.telecracksapp.izimath;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private TextView olvida_tv;
    private TextView registra_tv;
    private EditText usuario_et;
    private EditText password_et;
    private Button inicia_bt;
    private SignInButton google_btn;

    private GoogleSignInClient googleSignInClient;

    private GoogleApiClient googleApiClient;

    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener fireAuthStateListener;


    public static final int SIGN_IN_CODE = 777;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_CODE){





           GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);


            Toast.makeText(this,""+ result.getStatus(), Toast.LENGTH_LONG).show();
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {

        if(result.isSuccess()){

            goMainScreen();
        }else{
            //Toast.makeText(this,"No se pudo logear con google" , Toast.LENGTH_LONG).show();
        }
    }

    private void goMainScreen() {
        Intent i = new Intent(MainActivity.this,PrincipalActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               // .requestIdToken(String.valueOf(R.string.default_web_client_id))
                .requestEmail()
                //.requestId()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)

                .build();

        google_btn = findViewById(R.id.google_register);

        google_btn.setSize(SignInButton.SIZE_WIDE);
        google_btn.setColorScheme(SignInButton.COLOR_DARK);

        google_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = googleSignInClient.getSignInIntent();
                           // Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                    startActivityForResult(intent,SIGN_IN_CODE);
            }
        });

        olvida_tv = findViewById(R.id.olvida_tv);
        registra_tv = findViewById(R.id.registrar_tv);
        usuario_et = findViewById(R.id.user_et);
        password_et = findViewById(R.id.password_et);
        inicia_bt = findViewById(R.id.inicia_bt);

        inicia_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //HACER INICIO AUTENTICANDO----------------------------------------------------------------------------------

                auth.signInWithEmailAndPassword(
                        usuario_et.getText().toString().trim(),
                        password_et.getText().toString().trim()
                ).addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }
                );

            }
        });

        registra_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterOptionsActivity.class);
                startActivity(i);
            }
        });

        olvida_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HACER 'olvidaste tu contraseña?", Toast.LENGTH_SHORT).show();
                //Pendiente hacer activity "OLVIDASTE TU CONTRASENHA"-----------------------------------------------------------------------------

            }
        });


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
