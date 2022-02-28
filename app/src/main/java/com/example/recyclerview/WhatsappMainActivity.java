package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WhatsappMainActivity extends AppCompatActivity implements OnClickRecyclerView {


    RecyclerView recyclerView;
    WhatsAppAdapter adapter;
    List<WhatsAppModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.whatsapphome_activity_layout);

        data();
        recyclerView = findViewById(R.id.RecyclerView);
        adapter = new WhatsAppAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }


    private void data() {

        String des = "WhatsApp Status is a great way to express yourself. It is an expression explicitly written and in a precise way to reveal one's views, thoughts, and emotions in a creative style. WhatsApp status displays how uniquely and ingeniously you can put your thoughts in words. Updating status on WhatsApp or changing it from time to time simply defines your way of living life or style towards life. Besides this, updating status is thought-provoking and is fun, if you can manage it smartly and effectively. There are different types of WhatsApp status that one can use, as per their convenience or mood.";

        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0) {
                list.add(new WhatsAppModel(R.drawable.ic_baseline_person_24, "person " + i, "Hello", new Date()));
            } else {
                list.add(new WhatsAppModel(R.drawable.prof, "Abanoub ", "" + i + " " + des, new Date()));

            }
        }

    }

    @Override
    public void onclick(int position) {
        Intent intent = new Intent(this, InsidePageWhatsapp.class);
        intent.putExtra("clicked", list.get(position));
        startActivity(intent);
    }

}