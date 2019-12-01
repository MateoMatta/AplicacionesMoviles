package edu.co.icesi.appmoviles.proyectofinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import model.User;

public class MainActivity extends AppCompatActivity {

    private SignInButton google_btn;

    private GoogleSignInClient googleSignInClient;

    private GoogleApiClient googleApiClient;

    private TextView olvida_tv;
    private TextView registra_tv;
    private EditText usuario_et;
    private EditText password_et;
    private Button inicia_bt;

    FirebaseAuth auth;
    FirebaseDatabase db;
    FirebaseAuth.AuthStateListener fireAuthStateListener;

    public static final int SIGN_IN_CODE = 777;



    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = auth.getCurrentUser();


                        } else {
                            // If sign in fails, display a message to the user.


                        }

                        // ...
                    }
                });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            Log.e(">>>>>",""+result.getStatus());
            Log.e(">>>>>",""+result.isSuccess());
            if(result.isSuccess()){
                firebaseAuthWithGoogle(result.getSignInAccount());
                User user = new User(
                        result.getSignInAccount().getId(),
                        //auth.getCurrentUser().getUid(),
                        result.getSignInAccount().getEmail(),
                        result.getSignInAccount().getDisplayName(),
                        result.getSignInAccount().getIdToken()


                );

                db.getReference().child("users").child(user.getUid())
                        .setValue(user);


                Toast.makeText(this,""+ result.getSignInAccount().getEmail(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                startActivity(intent);
                finish();

            }
            //handleSignInResult(result);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                // .requestIdToken(String.valueOf(R.string.default_web_client_id))
                .requestEmail()
                //.requestId()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this,gso);
        // googleApiClient = new GoogleApiClient.Builder(this)
        //        .enableAutoManage(this, this)
        //          .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
        //            .build();


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



        olvida_tv = findViewById(R.id.olvida_tv_login);
        registra_tv = findViewById(R.id.registrar_tv_login);
        usuario_et = findViewById(R.id.user_et_login);
        password_et = findViewById(R.id.password_et_login);
        inicia_bt = findViewById(R.id.inicia_bt_login);

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
}

