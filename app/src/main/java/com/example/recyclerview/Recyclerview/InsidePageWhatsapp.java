package com.example.recyclerview.Recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclerview.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class InsidePageWhatsapp extends AppCompatActivity {

    CircleImageView image;
    TextView message, name, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_page_whatsapp);

        WhatsAppModel model = (WhatsAppModel) getIntent().getExtras().getSerializable("clicked");

        image = findViewById(R.id.circleImageView);
        image.setImageResource(model.getImage());
        message = findViewById(R.id.usermessage);
        message.setText(model.getMessage());
        name = findViewById(R.id.username);
        name.setText(model.getName());
        date = findViewById(R.id.usertime);
        date.setText(model.getTime());


    }
}