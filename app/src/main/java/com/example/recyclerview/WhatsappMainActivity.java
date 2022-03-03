package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.Recyclerview.InsidePageWhatsapp;
import com.example.recyclerview.Recyclerview.OnClickRecyclerView;
import com.example.recyclerview.Recyclerview.WhatsAppAdapter;
import com.example.recyclerview.Recyclerview.WhatsAppModel;
import com.example.recyclerview.Room.WhatsAppDOA;
import com.example.recyclerview.Room.WhatsAppDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WhatsappMainActivity extends AppCompatActivity implements OnClickRecyclerView {


    RecyclerView recyclerView;
    WhatsAppAdapter adapter;
    List<WhatsAppModel> list = new ArrayList<>();
    WhatsAppDatabase whatsAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.whatsapphome_activity_layout);

    ////////////////
        list = data();
        recyclerView = findViewById(R.id.RecyclerView);
        adapter = new WhatsAppAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ////////////////
    }


    private List<WhatsAppModel> data() {
        String des = "WhatsApp Status is a great way to express yourself. It is an expression explicitly written and in a precise way to reveal one's views, thoughts, and emotions in a creative style. WhatsApp status displays how uniquely and ingeniously you can put your thoughts in words. Updating status on WhatsApp or changing it from time to time simply defines your way of living life or style towards life. Besides this, updating status is thought-provoking and is fun, if you can manage it smartly and effectively. There are different types of WhatsApp status that one can use, as per their convenience or mood.";

        WhatsAppDatabase dp = Room.databaseBuilder(getApplicationContext(), WhatsAppDatabase.class, "WhatsAppRoom").allowMainThreadQueries().build();
        whatsAppDatabase.whatsAppDOA().InsertMessage(new WhatsAppModel(R.drawable.prof, "Abanoub", des, new Date()));
        return whatsAppDatabase.whatsAppDOA().DBList();
    }

    @Override
    public void onclick(int position) {
        Intent intent = new Intent(this, InsidePageWhatsapp.class);
        intent.putExtra("clicked", list.get(position));
        startActivity(intent);
    }

}