package com.example.recyclerview.Recyclerview;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity(tableName = "WhatsAppRoom")
public class WhatsAppModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String message;
    private int image;
    private String time;

    public WhatsAppModel() {
    }

    public WhatsAppModel(int image, String name, String message, Date time) {
        this.image = image;
        this.message = message;
        this.name = name;
        this.time = getStringTime(time);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getStringTime(Date t) {
        SimpleDateFormat formatter = new SimpleDateFormat("d/M h:m");
        String strDate = formatter.format(t);
        return strDate;
    }

    public int getId() {
        return id;
    }
}
