package edu.co.icesi.appmoviles.proyectofinal.control.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;

import java.io.File;
import java.util.ArrayList;

import edu.co.icesi.appmoviles.proyectofinal.R;
import edu.co.icesi.appmoviles.proyectofinal.control.fragments.CommentsFragment;
import edu.co.icesi.appmoviles.proyectofinal.model.Comment;
import edu.co.icesi.appmoviles.proyectofinal.model.QuestionAndAnswer;


public class CommentAdapter extends BaseAdapter {

    ArrayList<QuestionAndAnswer> comentarios;


    public CommentAdapter() {
        comentarios = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return comentarios.size();
    }

    @Override
    public Object getItem(int i) {
        return comentarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        final AppCompatActivity ref = (AppCompatActivity) viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rowView = inflater.inflate(R.layout.comentario_row, null);
        ImageView rowImage = rowView.findViewById(R.id.row_image);
        TextView rowName = rowView.findViewById(R.id.row_name);
        TextView rowViews = rowView.findViewById(R.id.row_views);
        TextView rowDesc = rowView.findViewById(R.id.row_description);
        Button commentsPhotoBtn = rowView.findViewById(R.id.commentsPhotoBtn);

        rowName.setText(comentarios.get(i).getQuestion());
        rowViews.setText("Views: 1");
        rowDesc.setText(comentarios.get(i).getAnswer());


        File file = new File(viewGroup.getContext().getExternalFilesDir(null) + "/" + comentarios.get(i).getUid() + ".png");
        if (file.exists()) {
            Bitmap imagen = BitmapFactory.decodeFile(file.toString());
            rowImage.setImageBitmap(imagen);
        } else {

            loadImage(i, rowImage);
        }


        commentsPhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommentsFragment fragment = new CommentsFragment();
                fragment.setPhoto(comentarios.get(i));
                fragment.show(ref.getSupportFragmentManager(), "comments");

            }

        });
        return rowView;
    }

    public void addQuestionAndAnswer(QuestionAndAnswer questionanda) {
        comentarios.add(questionanda);
        notifyDataSetChanged();
    }

    public void clear() {
        comentarios.clear();
    }

    public void loadImage(int i, final ImageView rowImage) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storage.getReference().child("photos")
                .child(comentarios.get(i).getUid() + ".png")
                .getDownloadUrl().addOnSuccessListener(

                    uri -> {
                        Glide.with(rowImage).load(uri.toString()).into(rowImage);

                    });
    }

}
