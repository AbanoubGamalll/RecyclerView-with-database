package com.example.recyclerview.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.recyclerview.Recyclerview.WhatsAppModel;

@Database(entities = {WhatsAppModel.class}, version = 1, exportSchema = false)
public abstract class WhatsAppDatabase extends RoomDatabase {
    public abstract WhatsAppDOA whatsAppDOA();

}