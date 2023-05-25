package com.example.multirecyclerviewjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<MainActivity.ChildItem> childItemList;

    public void setChildItemList(List<MainActivity.ChildItem> childItemList) {
        this.childItemList = childItemList;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false);
        return new ChildViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        MainActivity.ChildItem childItem = childItemList.get(position);
        holder.bind(childItem);
    }

    @Override
    public int getItemCount() {
        return childItemList.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        private TextView childTextView;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            childTextView = itemView.findViewById(R.id.childTextView);
        }

        public void bind(MainActivity.ChildItem childItem) {
            childTextView.setText(childItem.getChildName());
        }
    }
}

