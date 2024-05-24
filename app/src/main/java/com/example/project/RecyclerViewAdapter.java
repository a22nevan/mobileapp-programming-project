package com.example.project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Produce> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<Produce> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Produce produce = items.get(position);
        Log.d("RecyclerViewAdapter", "Binding item at position " + position + " with name: " + produce.getName());
        holder.title.setText(produce.getName());
        holder.category.setText("Type: " +produce.getCategory());
        holder.size.setText("Height: " + String.valueOf(produce.getSize()) + "cm");
        holder.cost.setText("Price: " + String.valueOf(produce.getCost()) + " kr");
        holder.auxData.setText("Harvesting Season: " + produce.getAuxData());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView category;
        TextView size;
        TextView cost;
        TextView auxData;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.itemTitle);
            category = itemView.findViewById(R.id.itemCategory);
            size = itemView.findViewById(R.id.itemSize);
            cost = itemView.findViewById(R.id.itemCost);
            auxData = itemView.findViewById(R.id.itemAuxData);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(Produce item);
    }

    public void setItems(List<Produce> items) {
        this.items.clear();
        this.items.addAll(items);
    }


}