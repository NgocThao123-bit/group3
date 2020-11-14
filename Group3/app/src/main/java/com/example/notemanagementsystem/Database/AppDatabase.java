package com.example.notemanagementsystem.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.notemanagementsystem.ui.gallery.Category;
import com.example.notemanagementsystem.ui.gallery.CategoryDAO;

@Database(entities =  {Category.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDAO categoryDAO();
}
