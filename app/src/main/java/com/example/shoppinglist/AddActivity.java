package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {


    private Storage cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        cart = Storage.getInstance();
    }

    public void clickFinal(View view) {
        EditText txtItemName = findViewById(R.id.txtItemName);
        EditText txtDescription = findViewById(R.id.txtDescription);
        String itemName = txtItemName.getText().toString();
        String itemDescription = txtDescription.getText().toString();
        Item item = new Item(itemName, itemDescription);
        cart.addItem(item);

    }
}
