package com.example.moodtrackerapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.firestore.FirebaseFirestore;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Date;

public class note extends AppCompatActivity {
    ActionBar actionBar; ImageView imgV; TextView txtV, reason;
    Animation iconAnim, faceAnim;
    FirebaseFirestore fire;
    String face, txt, fullReason, day, month, year;
    EditText notes;
    Date d; Map<String ,Object> moods;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        actionBar = getSupportActionBar();
        assert actionBar != null; actionBar.hide();

        imgV = (ImageView)findViewById(R.id.moodFace2);
        txtV = (TextView) findViewById(R.id.moodTxt2);
        reason = (TextView) findViewById(R.id.textView);
        notes = findViewById(R.id.note);
        fire = FirebaseFirestore.getInstance();

        iconAnim = AnimationUtils.loadAnimation(this, R.anim.iconselect_anim);
        faceAnim = AnimationUtils.loadAnimation(this, R.anim.updownslow_anim);

        Intent intent = getIntent(); Bundle extra = intent.getExtras();
        face = extra.getString("moodFace"); txt = extra.getString("moodTxt");
        fullReason = extra.getString("reasons");

        Resources res = imgV.getResources();
        int resID = res.getIdentifier(face, "drawable", this.getPackageName());

        imgV.setImageResource(resID);
        txtV.setText(txt);
        imgV.startAnimation(faceAnim);
        fullReason = fullReason.substring(0, fullReason.length() - 2)+".";
        reason.setText(fullReason);

        day = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
        month = new SimpleDateFormat("MMMM", Locale.getDefault()).format(new Date());
        year = new SimpleDateFormat("YYYY", Locale.getDefault()).format(new Date());
    }

    public void goTimeLine(View v) {
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void insertToDataBase(View v) throws IOException, URISyntaxException {

        Map<String ,Object> moods = new HashMap<>();
        moods.put("userName", "Shaden");
        moods.put("faceMood", face);
        moods.put("txtMood", txt+", "+fullReason);
        moods.put("note", notes.getText().toString());
        moods.put("day", day);
        moods.put("month", month);
        moods.put("year", year);

        fire.collection("moods").add(moods);
        Intent i = new Intent(this, timeLinePage.class);
        startActivity(i);
    }
}