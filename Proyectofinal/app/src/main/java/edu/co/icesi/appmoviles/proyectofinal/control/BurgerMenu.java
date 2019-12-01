package edu.co.icesi.appmoviles.proyectofinal.control;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.co.icesi.appmoviles.proyectofinal.R;

public class BurgerMenu extends Fragment {

    private TextView user_tv;
    private TextView settings_tv;
    private TextView questions_tv;
    private TextView message_tv;
    private TextView help_tv;
    private TextView exit_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_burger_menu, null);
        user_tv = view.findViewById(R.id.user_tv_burger);
        settings_tv = view.findViewById(R.id.settings_tv_burger);
        questions_tv = view.findViewById(R.id.questions_tv_burger);
        message_tv = view.findViewById(R.id.message_tv_burger);
        help_tv = view.findViewById(R.id.help_tv_burger);
        exit_tv = view.findViewById(R.id.exit_tv_burger);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_burger_menu, container, false);
    }





}
