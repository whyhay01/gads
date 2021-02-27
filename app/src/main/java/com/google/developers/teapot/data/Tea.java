package com.google.developers.teapot.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * A Model class that holds information about the tea.
 * This class defines table for the Room database with primary key {@see #mCode}
 */
@Entity(tableName = "tea")
public class Tea {

    @PrimaryKey(autoGenerate = true)
    private Long mId;

    private final String mName;

    private final String mType;

    private final String mOrigin;

    private final Integer mSteepTimeMs;

    private final String mDescription;

    private final String mIngredients;

    private final String mCaffeineLevel;


    @Ignore
    public Tea(Long id, @NonNull String name, @NonNull String type, String origin, @NonNull Integer steepTimeMs,
               String description, String ingredients, String caffeineLevel, boolean favorite) {
        this(id,name, type, origin, steepTimeMs, description, ingredients, caffeineLevel);
    }

    public Tea( Long id, @NonNull String name, @NonNull String type, String origin, @NonNull Integer steepTimeMs,
               String description, String ingredients, String caffeineLevel) {
        this.mId = id;
        this.mName = name;
        this.mType = type;
        this.mOrigin = origin;
        this.mSteepTimeMs = steepTimeMs;
        this.mDescription = description;
        this.mIngredients = ingredients;
        this.mCaffeineLevel = caffeineLevel;

    }

    @NonNull
    public Long getId() {
        return mId;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getType() {
        return mType;
    }

    @Nullable
    public String getOrigin() {
        return mOrigin;
    }

    public Integer getSteepTimeMs() {
        return mSteepTimeMs;
    }

    @Nullable
    public String getDescription() {
        return mDescription;
    }

    @Nullable
    public String getIngredients() {
        return mIngredients;
    }

    @Nullable
    public String getCaffeineLevel() {
        return mCaffeineLevel;
    }


}
