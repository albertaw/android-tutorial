package com.example.android.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HorrorCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Author 1", R.drawable.book_cover, "This is the description"));
        books.add(new Book("Book 2", "Author 2", R.drawable.book_cover, "This is the description"));
        books.add(new Book("Book 3", "Author 3", R.drawable.book_cover, "This is the description"));
        books.add(new Book("Book 4", "Author 4", R.drawable.book_cover, "This is the description"));
        books.add(new Book("Book 5", "Author 5", R.drawable.book_cover, "This is the description"));

        BookAdapter adapter = new BookAdapter(this, books);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(HorrorCategoryActivity.this, BookDetailActivity.class);
                Book book = books.get(position);
                intent.putExtra("Book", book);
                startActivity(intent);
            }
        });
    }
}
