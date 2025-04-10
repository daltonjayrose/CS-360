package com.example.daltonrose_cs360;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    ArrayList<WeightModel> weightModels = new ArrayList<>();

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.zRecyclerView);
        setUpWeightModels();
        WeightRecyclerView weightRecyclerAdapter = new WeightRecyclerView(getContext(), weightModels);
        recyclerView.setAdapter(weightRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void startHome() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    private void setUpWeightModels() {
        String[] weightValues = getResources().getStringArray(R.array.test_values);

        for (String weightValue : weightValues) {
            weightModels.add(new WeightModel(weightValue));
        }
    }
}