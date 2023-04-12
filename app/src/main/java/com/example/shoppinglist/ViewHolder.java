package com.example.shoppinglist;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txtPlaceHolderItemName, txtPlaceHolderDescription;
    EditText txtEditName, txtEditDescription;
    ImageView iwDelete, iwEdit;

    Button btnSave;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        txtPlaceHolderItemName = itemView.findViewById(R.id.txtPlaceHolderItemName);
        txtPlaceHolderDescription = itemView.findViewById(R.id.txtPlaceHolderDescription);
        iwDelete = itemView.findViewById(R.id.baseline_delete_forever_24);
        iwEdit = itemView.findViewById(R.id.baseline_edit_24);

        txtEditName = itemView.findViewById(R.id.txtEditName);
        txtEditDescription = itemView.findViewById(R.id.txtEditDescription);
        txtEditName.setVisibility(View.GONE);
        txtEditDescription.setVisibility(View.GONE);
        btnSave = itemView.findViewById(R.id.btnSave);
        btnSave.setVisibility(View.GONE);



    }
}
