package com.selise.razonhossain.sugarEntitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orm.SugarRecord;
import com.selise.razonhossain.eventbus.R;

import java.util.ArrayList;
import java.util.List;

public class SugarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterSugarRecycler adapter;
    LinearLayoutManager layoutManager;
    List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar);

        populatetoDatabase();

        bookList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterSugarRecycler(bookList, SugarActivity.this);
        recyclerView.setAdapter(adapter);

        populateFromDatabase();


    }

    private void populateFromDatabase() {

        bookList = Book.listAll(Book.class);
        adapter.notifyDataSetChanged();


    }

    private void populatetoDatabase() {

        Book book = new Book("BookName1", "12/10/2016", "256", "1", new Author("AuthorName", "25/85/1998", "1"));
        book.save();
       // SugarRecord.save(book);

        Book book1 = new Book("BookName2", "12/10/2016", "256", "1", new Author("AuthorName", "25/85/1998", "1"));
        book1.save();
      //  SugarRecord.save(book1);

        Book book2 = new Book("BookName3", "12/10/2016", "256", "1", new Author("AuthorName", "25/85/1998", "1"));
        book2.save();
      //  SugarRecord.save(book2);

    }
}
