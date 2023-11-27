package com.example.viewpage2;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class UseFragmentSateAdapter extends FragmentStateAdapter {
    private ArrayList<Page> pages;
    public UseFragmentSateAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Page> pages) {
        super(fragmentActivity);
        this.pages = pages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment = new PageFragment();

        Page page = pages.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("page", page);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getItemCount() {
        // số lượng page
        return pages.size();
    }
}
