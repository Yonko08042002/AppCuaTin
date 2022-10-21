package com.google.myapp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.ViewHolder> {

    ArrayList<MostViewedDomain> mostViewDomains;
    private Context mcontext;

    public MostViewAdapter(Context context,ArrayList<MostViewedDomain> mostViewDomains) {
        this.mostViewDomains = mostViewDomains;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        final MostViewedDomain mostViewedDomain = mostViewDomains.get(position);
        holder.titleTxt.setText(String.valueOf(mostViewDomains.get(position).getTitle()));
        holder.subTitleTxt.setText(String.valueOf(mostViewDomains.get(position).getSubtitle()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(mostViewDomains.get(position).getUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.removeItem);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(mostViewDomains);
            }
        });
    }
    private void onClickGoToDetail(ArrayList<MostViewedDomain> mostViewedDomain){
        Intent intent =new Intent(mcontext,DetailActivity.class);
        Bundle bundle =new Bundle();
        bundle.putSerializable("object_news", (Serializable) mostViewedDomain);
        intent.putExtras(bundle);
        mcontext.startActivities(new Intent[]{intent});
    }

    @Override
    public int getItemCount() {
        return mostViewDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        TextView titleTxt,subTitleTxt;
        ImageView removeItem;

        public ViewHolder(View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.layout_News);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            subTitleTxt = itemView.findViewById(R.id.subTitleTxt);
            removeItem = itemView.findViewById(R.id.img_view);
        }
    }
}
