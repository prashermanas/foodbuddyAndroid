package com.example.mprasher.foodbuddy.wall;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mprasher.foodbuddy.R;
import com.example.mprasher.foodbuddy.webservices.response.Source;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WallAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Source> wallRowModels = new ArrayList<>();

    public WallAdapter(ArrayList<Source> wallRowModels) {
        this.wallRowModels = wallRowModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wall_row, null);
        return new WallRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Source wallRowModel = wallRowModels.get(position);
        ((WallRowViewHolder)holder).bind(wallRowModel);
    }

    @Override
    public int getItemCount() {
        return wallRowModels.size();
    }

    class WallRowViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.userName)TextView userName;
        @BindView(R.id.titleLabel) TextView title;
        @BindView(R.id.foodTypes)TextView foodTypes;
        @BindView(R.id.pickupLocation)TextView pickUpLocation;
        @BindView(R.id.description)TextView description;
        @BindView(R.id.reach)AppCompatButton reach;
        @BindView(R.id.status)TextView status;
        @BindView(R.id.timeLabel)TextView time;
         WallRowViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Source wallRowModel){
            userName.setText(wallRowModel.getUserName());
            title.setText(wallRowModel.getTitle());
            foodTypes.setText(wallRowModel.getFoodTypes());
            pickUpLocation.setText(wallRowModel.getPickupAddress());
            description.setText(wallRowModel.getDescription());
            time.setText("2 days from now");
            Boolean promised = wallRowModel.getPromised();
            if(promised){
                status.setText("Promised");
                status.setTextColor(Color.GREEN);
            }else {
                status.setText("Not Promised");
                status.setTextColor(Color.RED);
            }

        }

        @OnClick(R.id.reach)
        public void onReach(View view){
            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ "mprasher@gasbuddy.com" });
            i.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "");
            view.getContext().startActivity(Intent.createChooser(i, "Send email"));
        }
    }
}
