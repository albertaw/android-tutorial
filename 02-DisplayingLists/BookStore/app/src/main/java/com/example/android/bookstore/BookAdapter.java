package com.example.android.bookstore;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Activity context, ArrayList<Book> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Book book = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.book_title);
        titleTextView.setText(book.getTitle());

        TextView authorTextView = listItemView.findViewById(R.id.book_author);
        authorTextView.setText(book.getAuthor());

        ImageView iconImageView = listItemView.findViewById(R.id.list_item_icon);
        iconImageView.setImageResource(book.getImageResourceId());

        return listItemView;
    }
}
