package edu.co.icesi.appmoviles.proyectofinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import edu.co.icesi.appmoviles.proyectofinal.control.BurgerMenu;

public class PrincipalActivity extends AppCompatActivity {

    private ImageButton searchBtn;
    private ImageButton burgerMenuBtn;

    private ImageButton calculoBtn;
    private ImageButton algebraLinealBtn;
    private ImageButton algebraBtn;
    private ImageButton calculoMultivariableBtn;
    private ImageButton geometriaBtn;
    private ImageButton ecuacionesDiferencialesBtn;


    BurgerMenu fragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        searchBtn = findViewById(R.id.search_button_principal);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });


        calculoBtn = findViewById(R.id.imageButton_Calculo);
        calculoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", "calculo");
                startActivity(i);
                //PONER ACCION------------------------------------------------------------------------------------------
            }
        });

        algebraBtn = findViewById(R.id.imageButton_Algebra);
        algebraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", "algebra");
                startActivity(i);

                //PONER ACCION---------------------------------------------
            }
        });
        algebraLinealBtn = findViewById(R.id.imageButton_lineal);
        algebraLinealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", "algebraLineal");
                startActivity(i);
                //PONER ACCION---------------------------------------------
            }
        });

        calculoMultivariableBtn = findViewById(R.id.imageButton_CalculoM);
        calculoMultivariableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", "calculoVarias");
                startActivity(i);
                //PONER ACCION---------------------------------------------
            }
        });

        geometriaBtn = findViewById(R.id.imageButton_geometria);
        geometriaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", "geometria");
                startActivity(i);
                //PONER ACCION---------------------------------------------
            }
        });

        ecuacionesDiferencialesBtn = findViewById(R.id.imageButton_Ecua);
        ecuacionesDiferencialesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", "ecuaciones");
                startActivity(i);
                //PONER ACCION---------------------------------------------
            }
        });

        burgerMenuBtn = findViewById(R.id.burger_menu_button_principal);
        burgerMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent showContent = new Intent(getApplicationContext(),
                        BurgerMenu.class);
                startActivity(showContent);
            }
        });
    }
}