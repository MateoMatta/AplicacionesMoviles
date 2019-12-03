
package edu.co.icesi.appmoviles.proyectofinal.control.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


import edu.co.icesi.appmoviles.proyectofinal.R;
import edu.co.icesi.appmoviles.proyectofinal.model.Comment;
import edu.co.icesi.appmoviles.proyectofinal.model.QuestionAndAnswer;


public class CommentsFragment extends DialogFragment {

    private EditText commentEt;
    private Button commentBtn;
    private ListView commentList;
    private ArrayAdapter<Comment> commentsAdapter;
    private ArrayList<Comment> arrayComments;
    private QuestionAndAnswer comentariesito;
    FirebaseDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, null);
        commentEt = view.findViewById(R.id.comment_et);
        commentBtn = view.findViewById(R.id.comment_btn);
        commentList = view.findViewById(R.id.comment_list);
        db = FirebaseDatabase.getInstance();

        arrayComments = new ArrayList<>();
        commentsAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,arrayComments);
        commentList.setAdapter(commentsAdapter);



        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Crear una llave
                String uid = db.getReference()
                        .child("comments")
                        .child(comentariesito.getUid())
                        .push().getKey();
                //Sacar el texto
                String text = commentEt.getText().toString();

                Comment comment = new Comment(uid, text);
                db.getReference()
                        .child("comments")
                        .child(comentariesito.getUid())
                        .child(comment.getUid())
                        .setValue(comment);
                //  db.getReference().child("notifications").child(.getUid()).child(uid).setValue(comment);



                CommentsFragment.this.hideSoftKeyboard(v);
            }
        });
        db.getReference().child("comments").child(comentariesito.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        arrayComments.clear();
                        for(DataSnapshot child : dataSnapshot.getChildren()){
                            Comment comment = child.getValue(Comment.class);
                            arrayComments.add(comment);
                        }
                        commentsAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        //addChildEventListener()

        return view;
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getActivity().getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void setPhoto(QuestionAndAnswer comee) {
        this.comentariesito = comee;
    }
}
