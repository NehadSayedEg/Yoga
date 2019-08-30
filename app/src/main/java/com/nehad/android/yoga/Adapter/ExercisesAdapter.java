package com.nehad.android.yoga.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nehad.android.yoga.R;
import com.squareup.picasso.Picasso;

public class ExercisesAdapter extends RecyclerView.ViewHolder {

        private View mView;

    public ExercisesAdapter(View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setDetails(Context context, String name, String image_id) {

            TextView pose = mView.findViewById(R.id.ex_name);
            pose.setText(name);

            ImageView imgPose = mView.findViewById(R.id.ex_img);

//            Glide.with(context)
//                    .load(image_id)
//                    .placeholder(R.drawable.loading)
//                    .into(imgPose);
//

            Picasso.get().load(image_id).into(imgPose);

      }





}

