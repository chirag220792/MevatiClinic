package com.rookiesoft.mevaticlinic.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rookiesoft.mevaticlinic.ItemClickListener;
import com.rookiesoft.mevaticlinic.R;

public class PatientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    //public ImageView mImageView;
    public TextView mPatientName, mPatientMobile;
    ItemClickListener itemClickListener;

    public PatientViewHolder(@NonNull View itemView){
        super(itemView);

        //this.mImageView = itemView.findViewById(R.id.imageViewPatient);
        this.mPatientName = itemView.findViewById(R.id.cardView_Patient_Name);
        this.mPatientMobile = itemView.findViewById(R.id.cardView_Patient_Mobile);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }


    /*    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Select Menu");
        contextMenu.add(0,0,getAdapterPosition(), "Update");
        contextMenu.add(0,1,getAdapterPosition(), "Delete");
    }*/
}
