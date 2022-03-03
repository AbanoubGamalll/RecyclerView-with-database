package com.example.recyclerview.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.recyclerview.Recyclerview.WhatsAppModel;

import java.util.List;

@Dao
public interface WhatsAppDOA {

    @Insert
    void InsertMessage(WhatsAppModel model);

    @Delete
    void DeleteMessage(WhatsAppModel model);

    @Update
    void UpdateMessage(WhatsAppModel model);

    @Query("select * from WhatsAppRoom")
    List<WhatsAppModel> DBList();

    @Query("delete from WhatsAppRoom")
    void DeleteAll();

}