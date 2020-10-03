package com.example.hw6_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    String t;
    RecyclerView recyclerView;
    MainAdapter adapter;
    ArrayList<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        if (getArguments() != null && savedInstanceState != null) {
            list = savedInstanceState.getStringArrayList("list");
        }
        if (getArguments() != null) {
            list = new ArrayList<>();
            t = getArguments().getString("text");
            list.add(t);
            Log.e("TAG", "onCreateView: " + list.toString());
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addText(t);

        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            if (getArguments() != null) {
            }
        }
    }
}