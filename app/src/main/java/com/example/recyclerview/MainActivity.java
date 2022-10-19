package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import category.CategoryAdapter;
import category.Category;
import book.Book;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryApapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryApapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryApapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryApapter);
    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Book> listBook = new ArrayList<>();

        listBook.add(new Book(R.drawable.lienquan, "Book 1"));
        listBook.add(new Book(R.drawable.loanchien, "Book 2"));
        listBook.add(new Book(R.drawable.pubg, "Book 3"));
        listBook.add(new Book(R.drawable.sanke_lite, "Book 4"));

        listBook.add(new Book(R.drawable.lienquan, "Book 1"));
        listBook.add(new Book(R.drawable.loanchien, "Book 2"));
        listBook.add(new Book(R.drawable.pubg, "Book 3"));
        listBook.add(new Book(R.drawable.sanke_lite, "Book 4"));

        listCategory.add(new Category("Category 1", listBook));
        listCategory.add(new Category("Category 2", listBook));
        listCategory.add(new Category("Category 3", listBook));
        listCategory.add(new Category("Category 4", listBook));

        return listCategory;

    }
}