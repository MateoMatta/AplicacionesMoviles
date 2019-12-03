package edu.co.icesi.appmoviles.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import edu.co.icesi.appmoviles.proyectofinal.control.BurgerMenu;

public class PrincipalActivity extends AppCompatActivity {

    private ImageButton searchBtn;
    private ImageButton burgerMenuBtn;

    private ImageButton calculoBtn;
    private ImageButton estadisticaBtn;
    private ImageButton algebraBtn;
    private ImageButton calculoMultivariableBtn;
    private ImageButton geometriaBtn;
    private ImageButton ecuacionesDiferencialesBtn;
    AppCompatActivity ref;

    BurgerMenu fragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

         ref = (AppCompatActivity) PrincipalActivity.this;

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
                i.putExtra("tipo", AreaPost.CALCULO);
                startActivity(i);
            }
        });

        algebraBtn = findViewById(R.id.imageButton_Algebra);
        algebraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", AreaPost.ALGEBRA);
                startActivity(i);

            }
        });
        estadisticaBtn = findViewById(R.id.imageButton_estadistica);
        estadisticaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", AreaPost.ESTADISTICA);
                startActivity(i);
            }
        });

        calculoMultivariableBtn = findViewById(R.id.imageButton_CalculoM);
        calculoMultivariableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", AreaPost.CALCULO_MULTIVARIABLE);
                startActivity(i);
            }
        });

        geometriaBtn = findViewById(R.id.imageButton_geometria);
        geometriaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", AreaPost.GEOMETRIA);
                startActivity(i);
            }
        });

        ecuacionesDiferencialesBtn = findViewById(R.id.imageButton_Ecua);
        ecuacionesDiferencialesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, AreaPost.class);
                i.putExtra("tipo", AreaPost.ECUACIONES_DIFERENCIALES);
                startActivity(i);
            }
        });

        burgerMenuBtn = findViewById(R.id.burger_menu_button_principal);
        burgerMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BurgerMenu fragment = new BurgerMenu();
                fragment.show(ref.getSupportFragmentManager(), "ccc");
            }
        });
    }
}