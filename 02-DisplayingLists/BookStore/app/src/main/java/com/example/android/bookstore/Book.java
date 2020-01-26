package com.example.android.bookstore;

import java.io.Serializable;

public class Book implements Serializable {
    private String mTitle;
    private String mAuthor;
    private int mImageResourceId;
    private String mDescription;

    public Book(String title, String author, int imageResourceId, String description) {
        mTitle = title;
        mAuthor = author;
        mImageResourceId = imageResourceId;
        mDescription = description;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
