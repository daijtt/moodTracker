package com.example.moodtrackerapp;

import static android.content.ContentValues.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.moodtrackerapp.Adapter.moodAdapter;
import com.example.moodtrackerapp.model.moodModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class timeLinePage extends AppCompatActivity {
    ActionBar actionBar;
    private RecyclerView recyclerView;
    moodAdapter adapter;
    List<moodModel> list;
    FirebaseFirestore fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line_page);
        actionBar = getSupportActionBar();
        actionBar.hide();

        recyclerView = findViewById(R.id.moodRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new moodAdapter(this);
        recyclerView.setAdapter(adapter);

        list = new ArrayList<>();
        adapter.setMoods(list);


        fire = FirebaseFirestore.getInstance();
        fire.collection("moods")
        .whereEqualTo("userName", "Shaden")
        .orderBy(FieldPath.documentId())
        .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        moodModel model = new moodModel();
                        model.setFaceMood(document.getString("faceMood"));
                        model.setTxtMood(document.getString("txtMood"));
                        model.setNote(document.getString("note"));
                        model.setDay(document.getString("day"));
                        model.setMonth(document.getString("month"));
                        list.add(model);
                    }
                    adapter.setMoods(list);
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
    }


    public void addFunc(View v) {
        Intent i = new Intent(this,insertMoodFace.class);
        startActivity(i);
    }

    public void goSetting(View v) {
        Intent i = new Intent(this,Setting.class);
        startActivity(i);
    }

    public void goTimeLine(View v) {
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i);
    }

    public void goSessions(View v) {
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i);
    }
}