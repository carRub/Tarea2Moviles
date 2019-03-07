package com.example.sesion9;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.sesion9.beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private ArrayList<ItemProduct> mDataSet;
    private OnPhoneClickListener listener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterProduct(ArrayList<ItemProduct> myDataSet) {
        mDataSet = myDataSet;
    }

    public AdapterProduct(ArrayList<ItemProduct> myDataSet, OnPhoneClickListener listener){
        this.listener = listener;
        mDataSet = myDataSet;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button mDetail;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;
        public ViewHolder(View v) {
            super(v);
            mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            mDetail = (Button) v.findViewById(R.id.item_product_detail);
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mProductImage = (ImageView) v.findViewById(R.id.item_product_image);
            mProductThumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.mProductTitle.setText(mDataSet.get(position).getName());
        holder.mProductStore.setText(mDataSet.get(position).getStore());
        holder.mProductLocation.setText(mDataSet.get(position).getLocation());
        holder.mProductPhone.setText(mDataSet.get(position).getPhone());

        switch(mDataSet.get(position).getImage()){
            case 0:
                holder.mProductImage.setImageResource(R.drawable.mac); break;
            case 1:
                holder.mProductImage.setImageResource(R.drawable.alienware); break;
            case 2:
                holder.mProductImage.setImageResource(R.drawable.pillows);
            case 3:
                holder.mProductImage.setImageResource(R.drawable.sheets);
            case 4:
                holder.mProductImage.setImageResource(R.drawable.refrigerator);
            case 5:
                holder.mProductImage.setImageResource(R.drawable.micro);
            default:
                holder.mProductImage.setImageResource(R.drawable.mac); break;
        }

        holder.mProductPhone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.onPhoneClick(mDataSet.get(position).getPhone());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTabItem(mDataSet.get(position).toString());
            }
        });

        /*Bitmap bitmap = ((BitmapDrawable)holder.mProductThumbnail.getDrawable()).getBitmap();
        holder.mProductThumbnail.setImageBitmap(bitmap);*/
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public interface OnPhoneClickListener {
        void onPhoneClick(String phone);
        void onTabItem(String item);
    }

}
