package com.example.notemanagementsystem.ui.gallery;

import android.app.Notification;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO
{
    @Query("select * from category")
    List<Category> getAll();

    @Query("select * from category where name =(:name)")
    Category loadCategoryByName(String name);

    @Query("select * from category where created_date LIKE :date Limit 1")
    Category findByDate(String date);

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);
}
