package com.example.viewpage2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UseRecyclerViewAdapter extends RecyclerView.Adapter<UseRecyclerViewAdapter.PageViewHolder> {
    private final ArrayList<Page> pages;

    public UseRecyclerViewAdapter(ArrayList<Page> pages) {
        this.pages = pages;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_page, parent, false);
        return new PageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
        Page page = pages.get(position);
        holder.imageView.setImageResource(page.getImage());
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    public static class PageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.iv_image);
        }
    }
}
