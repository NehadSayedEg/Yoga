package com.nehad.android.yoga;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nehad.android.yoga.Adapter.ExercisesAdapter;
import com.nehad.android.yoga.Model.Exercise;
import com.nehad.android.yoga.Model.ExerciseModel;

import java.util.ArrayList;
import java.util.List;

public class Exercises_List extends AppCompatActivity {


        RecyclerView recyclerView;
        FirebaseDatabase firebaseDatabase ;
      public DatabaseReference mDatabaseReference;
        ExercisesAdapter adapter ;
        RecyclerView.LayoutManager layoutManager;





    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_exercises__list);
           // initData();

            ActionBar actionBar = getSupportActionBar();
//            actionBar.setTitle(" ");
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = firebaseDatabase.getReference("Data");

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Data");
        recyclerView = findViewById(R.id.exerciseList);

            recyclerView =(RecyclerView)findViewById(R.id.exerciseList);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);



       // recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



    }



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ExerciseModel,ExercisesAdapter> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ExerciseModel, ExercisesAdapter>
                (ExerciseModel.class, R.layout.item_exercise, ExercisesAdapter.class, mDatabaseReference) {


            @Override
            protected void populateViewHolder(ExercisesAdapter viewHolder, final ExerciseModel model, int position) {
                viewHolder.setDetails(getApplicationContext(),model.getName(),model.getImage_id());
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(v.getContext(),ExerciseViewActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("image_id",model.getImage_id());
                        bundle.putString("name",model.getName());
                        intent.putExtras(bundle);
                        v.getContext().startActivity(intent);

                    }
                });


            }
        };




        //set adapter to recyclerview
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)

        }
        return super.onOptionsItemSelected(item);
    }


}



