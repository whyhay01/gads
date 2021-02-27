package com.google.developers.teapot.data;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

/**
 * Room data access object.
 */
@Dao
public interface TeaDao {




    /**
     * Returns all data in table for Paging
     *
     * @param query a dynamic SQL query
     */
//    @Query("SELECT * FROM tea ORDER BY mId ASC")
//    DataSource.Factory<Integer, Tea> getAll(SupportSQLiteQuery query);

    /**
     * Returns a Tea based on the tea name.
     *
     * @param name of a tea
     */
    @Query("SELECT * FROM tea ORDER BY mName")
    LiveData<Tea> getTea(String name);

    /**
     * Update tea if its favorite or not.
     *
     * @param name of a tea
     */
    @Update
    void updateFavorite(String name);

    /**
     * Returns a random Tea
     */
    @Insert
    Tea getRandomTea();

    @Query("SELECT * FROM tea ORDER BY mName" )
    LiveData<Tea> getRecentTea();

    @Insert
    void insert(Tea... tea);

    @Delete
    void delete(Tea tea);

}
