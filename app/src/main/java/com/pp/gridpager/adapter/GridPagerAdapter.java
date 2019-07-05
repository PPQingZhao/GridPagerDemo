package com.pp.gridpager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pp.gridpager.R;

public class GridPagerAdapter extends RecyclerView.Adapter<GridPagerAdapter.ViewHolder> {


    private final int row;
    private final int colum;
    private final int orientation;
    private final Context mContext;

    public GridPagerAdapter(@Nullable Context context, int orientation, int colum, int row) {
        this.mContext = context;
        this.orientation = orientation;
        this.colum = colum;
        this.row = row;
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_snaphelp, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (GridLayoutManager.VERTICAL == orientation) {
            layoutParams.height = viewGroup.getHeight() / row;
        } else {
            layoutParams.width = viewGroup.getWidth() / colum;
        }
        view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv_content.setText(String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.item_tv_content);
        }
    }
}