package edu.co.icesi.appmoviles.proyectofinal.control;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.co.icesi.appmoviles.proyectofinal.HelpActivity;
import edu.co.icesi.appmoviles.proyectofinal.MainActivity;
import edu.co.icesi.appmoviles.proyectofinal.MessageActivity;
import edu.co.icesi.appmoviles.proyectofinal.PrincipalActivity;
import edu.co.icesi.appmoviles.proyectofinal.QuestionsActivity;
import edu.co.icesi.appmoviles.proyectofinal.R;
import edu.co.icesi.appmoviles.proyectofinal.SettingsActivity;

public class BurgerMenu extends DialogFragment {

    private TextView user_tv;
    private TextView settings_tv;
    private TextView questions_tv;
    private TextView message_tv;
    private TextView help_tv;
    private TextView exit_tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger_menu, container);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Window window = getDialog().getWindow();

        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 300; params.y = -500; window.setAttributes(params);

        user_tv = view.findViewById(R.id.user_tv_burger);
        settings_tv = view.findViewById(R.id.settings_tv_burger);
        questions_tv = view.findViewById(R.id.questions_tv_burger);
        message_tv = view.findViewById(R.id.message_tv_burger);
        help_tv = view.findViewById(R.id.help_tv_burger);
        exit_tv = view.findViewById(R.id.exit_tv_burger);

        settings_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), SettingsActivity.class);
                startActivity(i);
            }
        });

        questions_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), QuestionsActivity.class);
                startActivity(i);
            }
        });
        message_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MessageActivity.class);
                startActivity(i);
            }
        });
        help_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), HelpActivity.class);
                startActivity(i);
            }
        });
        exit_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}
