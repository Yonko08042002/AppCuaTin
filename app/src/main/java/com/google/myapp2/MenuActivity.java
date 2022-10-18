package com.google.myapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        recyclerView = findViewById(R.id.viewMostView);
        recyclerViewCat = findViewById(R.id.viewCategory);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewCat.setLayoutManager(linearLayoutManager2);

        ArrayList<CategoryDomain> cat = new ArrayList<>();
        cat.add(new CategoryDomain("Map", "map"));
        cat.add(new CategoryDomain("Salary", "salary"));
        cat.add(new CategoryDomain("Schedule", "time"));
        cat.add(new CategoryDomain("Health", "love"));
        cat.add(new CategoryDomain("My Love", "mylove"));

        adapter2 = new CategoryAdapter(cat);
        recyclerViewCat.setAdapter(adapter2);


        ArrayList<MostViewedDomain> mostviewed =new ArrayList<>();
        mostviewed.add(new MostViewedDomain("Browsing Bruges in Belgium", "Bruges is one of Europe's best preserved cities", "pic_1"));
        mostviewed.add(new MostViewedDomain("the island Luke Skywalker called home", "Explore Skellig, Ireland's mysterious island outpost", "pic_2"));
        mostviewed.add(new MostViewedDomain("FOOTBALL", "Karim Benzema wins men’s Ballon d’Or as Alexia Putellas retains women’s award", "pic_5"));
        mostviewed.add(new MostViewedDomain("Covid-19 in the Airport", "Traveling this summer? What to know before going to the airport", "pic_3"));
        mostviewed.add(new MostViewedDomain("FOOTBALL", "WORLD CUP QATAR 2022 GROUPS", "pic_4"));

        adapter=new MostViewAdapter(mostviewed);
        recyclerView.setAdapter(adapter);
    }
}