package com.args.kcnagro;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.ListIterator;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> muploads;

    //for items on click
    private RecyclerView.OnItemTouchListener mListener;

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(RecyclerView.OnItemTouchListener listener)
    {
        mListener = listener;

    }

    public ImageAdapter (Context context, List<Upload> uploads){
        mContext = context;
        muploads = uploads;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);
        return new ImageViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload uploadCusrrent = muploads .get(position);
        holder.textViewName.setText(uploadCusrrent.getmName());
        Picasso.with(mContext)
                .load(uploadCusrrent.getmImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return muploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageView;
        public Button checkout;
        public ImageViewHolder (View itemView){
            super(itemView);

            textViewName = itemView.findViewById(R.id.textview_name);
            imageView= itemView.findViewById(R.id.image_view_upload);
            checkout = itemView.findViewById(R.id.button_checkout);

            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shkd = new Intent();
                }
            });

        }

    }
}





