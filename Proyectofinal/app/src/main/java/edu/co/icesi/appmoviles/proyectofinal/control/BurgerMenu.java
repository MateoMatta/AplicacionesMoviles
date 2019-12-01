package edu.co.icesi.appmoviles.proyectofinal.control;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import edu.co.icesi.appmoviles.proyectofinal.R;

public class BurgerMenu extends FragmentActivity {

    private TextView user_tv;
    private TextView settings_tv;
    private TextView questions_tv;
    private TextView message_tv;
    private TextView help_tv;
    private TextView exit_tv;

    private ImageButton backBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_burger_menu);
        Toast.makeText(this, "sisa", Toast.LENGTH_SHORT).show();

        backBtn = findViewById(R.id.imageButton_back2);
        user_tv = findViewById(R.id.user_tv_burger);
        settings_tv = findViewById(R.id.settings_tv_burger);
        questions_tv = findViewById(R.id.questions_tv_burger);
        message_tv = findViewById(R.id.message_tv_burger);
        help_tv = findViewById(R.id.help_tv_burger);
        exit_tv = findViewById(R.id.exit_tv_burger);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(">>>", "epa2");
                Toast.makeText(v.getContext(), "sisa", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public ImageButton getBackBtn() {
        return backBtn;
    }
}
