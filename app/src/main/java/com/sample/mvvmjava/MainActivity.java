package com.sample.mvvmjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.mvvmjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<DataModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {
        RecyclerView recyclerView = binding.rvData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(list, this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        list.clear();
        list.add(new DataModel("Android Oreo", "8.1"));
        list.add(new DataModel("Android Pie", "9.0"));
        list.add(new DataModel("Android Nougat", "7.0"));
        list.add(new DataModel("Android Marshmallow", "6.0"));


        myRecyclerViewAdapter.notifyDataSetChanged();
    }
}
