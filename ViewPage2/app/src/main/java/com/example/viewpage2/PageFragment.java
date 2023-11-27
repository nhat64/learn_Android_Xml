package com.example.viewpage2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PageFragment extends Fragment {

    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        Bundle bundle = getArguments();
        Page page = (Page) bundle.get("page");

        if(page != null) {
            ImageView imageView = view.findViewById(R.id.iv_image);
            imageView.setImageResource(page.getImage());
        }

        return view;
    }
}