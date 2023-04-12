package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {


    private Storage cart;

    private RecyclerView recyclerView;

    private ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cart = Storage.getInstance();
        recyclerView = findViewById(R.id.rvItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(getApplicationContext(), cart.getItems());
        recyclerView.setAdapter(adapter);


        ImageView btnABC = findViewById(R.id.btnABC);
        btnABC.setOnClickListener(view -> {
            sortABC();
        });

        ImageView btnTime = findViewById(R.id.btnTime);
        btnTime.setOnClickListener(view -> {
            sortTime();
        });
    }

    private void sortTime() {
        ArrayList<Long> itemTimes = new ArrayList<>();
        for (Item item : cart.getItems()) {
            itemTimes.add(item.getTime());
        }
        Collections.sort(itemTimes);

        ArrayList<Item> sortedItems = new ArrayList<>();
        for (Long itemTime : itemTimes) {
            for (Item item : cart.getItems()) {
                if (item.getTime() == itemTime) {
                    sortedItems.add(item);
                    break;
                }
            }
        }

        cart.getItems().clear();
        cart.getItems().addAll(sortedItems);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ListAdapter(getApplicationContext(), cart.getItems());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void goToNewItemScreen(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private void sortABC() {
        ArrayList<String> itemNames = new ArrayList<>();
        for (Item item : cart.getItems()) {
            itemNames.add(item.getName());
        }
        Collections.sort(itemNames);

        ArrayList<Item> sortedItems = new ArrayList<>();
        for (String itemName : itemNames) {
            for (Item item : cart.getItems()) {
                if (item.getName().equals(itemName)) {
                    sortedItems.add(item);
                    break;
                }
            }
        }

        cart.getItems().clear();
        cart.getItems().addAll(sortedItems);
        adapter.notifyDataSetChanged();
    }






}
