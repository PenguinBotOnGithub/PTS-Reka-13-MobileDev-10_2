package com.example.ptsprodukelektronik;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<Items> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemName;
        private final TextView itemPrice;
        private final ImageView itemPoster;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            itemName = view.findViewById(R.id.item_name);
            itemPrice = view.findViewById(R.id.item_price);
            itemPoster = view.findViewById(R.id.item_poster);
        }

    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public ProductAdapter(ArrayList<Items> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String itemName = localDataSet.get(position).getName();
        String itemPrice = localDataSet.get(position).getPrice();
        int itemPoster = localDataSet.get(position).getPosterImg();
        String itemDesc = localDataSet.get(position).getDescription();

        viewHolder.itemName.setText(itemName);
        viewHolder.itemPrice.setText(itemPrice);
        viewHolder.itemPoster.setImageResource(itemPoster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), ItemPage.class);
                intent.putExtra("item_name", itemName);
                intent.putExtra("item_price", itemPrice);
                intent.putExtra("item_poster", itemPoster);
                intent.putExtra("item_desc", itemDesc);

                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
