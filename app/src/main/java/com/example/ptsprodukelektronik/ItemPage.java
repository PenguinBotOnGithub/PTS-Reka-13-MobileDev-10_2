package com.example.ptsprodukelektronik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ptsprodukelektronik.databinding.ActivityItemPageBinding;

public class ItemPage extends AppCompatActivity {

    private ActivityItemPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /* Toolbar setup */
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        /* Back button setup */
        ImageButton backButton = binding.backButton;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Using an intent to go back to MainActivity causes an infinite loop for the back button,
                * that's why using finish() is better.
                * finish() destroys the current activity and automatically brings you back to the previous activity.
                * onBackPressed() might also work. */
                finish();
            }
        });

        /* Get passed data from previous activity */
        Intent intent = getIntent();
        String itemName = intent.getStringExtra("item_name");
        String itemPrice = intent.getStringExtra("item_price");
        int itemPoster = intent.getIntExtra("item_poster", R.drawable.material_symbols_hide_image_outline);
        String itemDesc = intent.getStringExtra("item_desc");

        /* Load product data */
        binding.itemImage.setImageResource(itemPoster);
        binding.itemName.setText(itemName);
        binding.itemPrice.setText(itemPrice);
        binding.descText.setText(itemDesc);
    }
}