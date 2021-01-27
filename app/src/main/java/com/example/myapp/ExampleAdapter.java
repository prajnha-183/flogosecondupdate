package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        String itemName = currentItem.getName();
        String description = currentItem.getDescription();
        int itemPrice = currentItem.getPrice();
        holder.mTextViewName.setText(itemName);
        holder.mTextViewDescription.setText(description);
        holder.mTextViewPrice.setText("Price:₹ " + itemPrice);
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextViewName;
        public TextView mTextViewDescription;
        public TextView mTextViewPrice;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextViewName = itemView.findViewById(R.id.text_view_Name);
            mTextViewDescription = itemView.findViewById(R.id.text_view_Description);
            mTextViewPrice = itemView.findViewById(R.id.text_view_Price);
        }
    }
}