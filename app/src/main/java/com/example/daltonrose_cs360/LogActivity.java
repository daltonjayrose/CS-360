package com.example.daltonrose_cs360;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daltonrose_cs360.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    ArrayList<WeightModel> weightModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        RecyclerView recyclerView = findViewById(R.id.wRecyclerView);
        setUpWeightModels();
        WeightRecyclerView weightRecyclerAdapter = new WeightRecyclerView(this, weightModels);
        recyclerView.setAdapter(weightRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void startHome(){
        startActivity(new Intent(LogActivity.this, MainActivity.class));
    }

    private void setUpWeightModels(){
        String[] weightValues = getResources().getStringArray(R.array.test_values);

        for (int i = 0; i < weightValues.length; i++) {
            weightModels.add(new WeightModel(weightValues[i]));
        }
    }


}
