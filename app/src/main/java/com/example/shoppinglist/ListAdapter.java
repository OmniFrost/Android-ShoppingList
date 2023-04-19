package com.example.shoppinglist;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context context;

    ArrayList<Item> cart = new ArrayList<>();

    private int currpos;

    String ItemName, ItemDescription, editedItemName, editedItemDescription;

    Item editedItem;

    public ListAdapter(Context context, ArrayList<Item> cart) {
        this.context = context;
        this.cart = cart;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_dislay, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemName = cart.get(position).getName();
        ItemDescription = cart.get(position).getDescription();
        holder.txtPlaceHolderItemName.setText(ItemName);
        holder.txtPlaceHolderDescription.setText(cart.get(position).getDescription());
        holder.txtEditName.setText(ItemName);
        holder.txtEditDescription.setText(ItemDescription);



        holder.iwDelete.setOnClickListener(view -> {
            currpos = holder.getAdapterPosition();
            cart.remove(currpos);
            notifyItemRemoved(currpos);
            notifyDataSetChanged();
        });


        holder.iwEdit.setOnClickListener(view -> {
            holder.txtEditName.setVisibility(View.VISIBLE);
            holder.txtEditDescription.setVisibility(View.VISIBLE);
            holder.btnSave.setVisibility(View.VISIBLE);

            holder.btnSave.setOnClickListener(view2 -> {
                editedItemName = holder.txtEditName.getText().toString();
                editedItemDescription = holder.txtEditDescription.getText().toString();

                editedItem = new Item(editedItemName, editedItemDescription, cart.get(position).checkIfSuperImportant());
                cart.set(position, editedItem);
                notifyDataSetChanged();

                holder.txtEditName.setVisibility(View.GONE);
                holder.txtEditDescription.setVisibility(View.GONE);
                holder.btnSave.setVisibility(View.GONE);
            });
        });


    }



    @Override
    public int getItemCount() {
        return cart.size();
    }
}
