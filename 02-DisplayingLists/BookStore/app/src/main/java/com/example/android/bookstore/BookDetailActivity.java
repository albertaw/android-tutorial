package com.example.android.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Book book = (Book)getIntent().getSerializableExtra("Book");

        TextView titleTextView = findViewById(R.id.book_title_detail);
        titleTextView.setText(book.getTitle());

        TextView authorTextView = findViewById(R.id.book_author_detail);
        authorTextView.setText(book.getAuthor());

        TextView descriptionTextView = findViewById(R.id.book_description_detail);
        descriptionTextView.setText(book.getDescription());
    }
}
