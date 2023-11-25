package com.example.databindrecex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databindrecex.databinding.ItemBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.foodviewholder> {
    List<Model> modelList;
    Context context;
    Recylerviewinterface recylerviewinterface;

    public Adapter(List<Model> modelList, Context context, Recylerviewinterface recylerviewinterface) {
        this.modelList = modelList;
        this.context = context;
        this.recylerviewinterface = recylerviewinterface;
    }

    @NonNull
    @Override
    public Adapter.foodviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new foodviewholder(itemBinding,recylerviewinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.foodviewholder holder, int position) {
        Model model = modelList.get(position);
        holder.itemBinding.setModel(model);


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class foodviewholder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;


        public foodviewholder(ItemBinding itemBinding, Recylerviewinterface recylerviewinterface) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            itemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recylerviewinterface != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            recylerviewinterface.onhandclick(position);
                        }
                    }
                }

            });
        }
    }
}


