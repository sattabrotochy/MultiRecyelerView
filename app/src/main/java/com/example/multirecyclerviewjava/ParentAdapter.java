package com.example.multirecyclerviewjava;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    private List<MainActivity.ParentItem> parentItemList;

    public ParentAdapter(List<MainActivity.ParentItem> parentItemList) {
        this.parentItemList = parentItemList;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent, parent, false);
        return new ParentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        MainActivity.ParentItem parentItem = parentItemList.get(position);
        holder.bind(parentItem);
    }

    @Override
    public int getItemCount() {
        return parentItemList.size();
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        private TextView parentTextView;
        private RecyclerView childRecyclerView;
        private ChildAdapter childAdapter;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            parentTextView = itemView.findViewById(R.id.parentTextView);
            childRecyclerView = itemView.findViewById(R.id.childRecyclerView);

            childRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            childAdapter = new ChildAdapter();
            childRecyclerView.setAdapter(childAdapter);
        }

        public void bind(MainActivity.ParentItem parentItem) {
            parentTextView.setText(parentItem.getParentName());
            childAdapter.setChildItemList(parentItem.getChildItemList());
            childAdapter.notifyDataSetChanged();
        }
    }
}

