package com.example.ptsprodukelektronik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.splashscreen.SplashScreen;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ptsprodukelektronik.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /* Quit button setup */
        ImageButton quitButton = binding.backButton;
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        /* New ActionBar setup */
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        /* Recycler view setup */
        ArrayList<Items> items = getProductItems();

        ProductAdapter productAdapter = new ProductAdapter(items);
        binding.rvItems.setLayoutManager(new GridLayoutManager(this, 2));
        binding.rvItems.setAdapter(productAdapter);
    }

    private ArrayList<Items> getProductItems() {
        ArrayList<Items> items = new ArrayList<>();
        String[] itemNames = getResources().getStringArray(R.array.item_name);
        String[] itemPrices = getResources().getStringArray(R.array.item_prices);
        TypedArray itemPosters = getResources().obtainTypedArray(R.array.item_posters);
        String[] itemDesc = getResources().getStringArray(R.array.item_desc);

        for (int i = 0; i < itemNames.length; i++) {
            Items item = new Items(itemNames[i], itemPrices[i], itemPosters.getResourceId(i, -1), itemDesc[i]);
            items.add(item);
        }

        return items;
    }
}