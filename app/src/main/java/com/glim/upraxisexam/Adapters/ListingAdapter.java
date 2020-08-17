package com.glim.upraxisexam.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.glim.upraxisexam.Activities.DetailsActivity;
import com.glim.upraxisexam.Activities.MainActivity;
import com.glim.upraxisexam.Models.ListingModel;
import com.glim.upraxisexam.R;
import com.glim.upraxisexam.Utils.CheckInternetConnection;

import java.util.ArrayList;
import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {

    private Context mContext;
    private List<ListingModel.Datum> mData;
    private LayoutInflater mInflater;

    public ListingAdapter(Context mContext, List<ListingModel.Datum> mData) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("urlToLoad", mData.get(position).getUrlDetails());
                System.out.println("urlToLoad(pass): "+mData.get(position).getUrlDetails());
                mContext.startActivity(intent);

                if (CheckInternetConnection.isNetwork(mContext)) {
                    //internet is connected do something

                } else {
                    //do something, net is not connected
                    Toast.makeText(mContext, "No internet connection.", Toast.LENGTH_LONG).show();
                }

            }
        });

        holder.name.setText(mData.get(position).getFirstName() + " " +mData.get(position).getLastName());
        holder.email.setText(mData.get(position).getEmail());
        holder.contact.setText(mData.get(position).getPhoneNumber());
        //holder.mainImage.setImageResource(mData.get(position).getAthletesMainImage());
        Glide.with(mContext).load(mData.get(position).getProfileImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;
        TextView contact;
        ImageView image;
        RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            email = itemView.findViewById(R.id.tvEmail);
            contact = itemView.findViewById(R.id.tvPhone);
            image = itemView.findViewById(R.id.thumbnail);
            container = itemView.findViewById(R.id.container);
        }
    }
}