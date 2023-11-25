package com.example.databindrecex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.databindrecex.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Recylerviewinterface {
    ActivityMainBinding activityMainBinding;
    Adapter adapter;
    List<Model> modelList;
    RecyclerView recyclerView;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        recyclerView=activityMainBinding.recyclerview;
         linearLayout=activityMainBinding.layout;
       modelList=new ArrayList<>();
       Model m1=new Model("Mohan","23",R.drawable.butter);
        Model m2=new Model("Krishna","2",R.drawable.butter);
        Model m3=new Model("Sai","23",R.drawable.butter);
        Model m4=new Model("krishna","34",R.drawable.butter);
        Model m5=new Model("ganesh","22",R.drawable.butter);
        Model m6=new Model("mohan","23",R.drawable.butter);
        modelList.add(m1);
        modelList.add(m2);
        modelList.add(m3);
        modelList.add(m4);
        modelList.add(m5);
        modelList.add(m6);
        adapter=new Adapter(modelList,this,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
         ItemTouchHelper helper=new ItemTouchHelper(callback);
         helper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onhandclick(int position) {
        Toast.makeText(this, ""+modelList.get(position).name, Toast.LENGTH_SHORT).show();

    }
    ItemTouchHelper.SimpleCallback callback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            Snackbar snackbar=Snackbar.make(linearLayout,"Item delted",Snackbar.LENGTH_LONG);
            snackbar.show();
            modelList.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();

        }
    };

}