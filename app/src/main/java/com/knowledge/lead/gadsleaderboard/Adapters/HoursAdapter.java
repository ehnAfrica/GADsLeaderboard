package com.knowledge.lead.gadsleaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.knowledge.lead.gadsleaderboard.Model.LearningHours;
import com.knowledge.lead.gadsleaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HoursAdapter  extends RecyclerView.Adapter<HoursAdapter.MyHourViewHolder> {

    private static final String TAG = "HoursAdapter";
    LearningHours hours = new LearningHours();
    List<LearningHours> learningHours = new ArrayList<>();

    public HoursAdapter(){

    }

    public void setData(List<LearningHours> learningHours1){
        this.learningHours = learningHours1;
    }

    @NonNull
    @Override
    public MyHourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.hours_items, parent, false);
        return new MyHourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHourViewHolder holder, int position) {
        LearningHours learningHours1 = learningHours.get(position);
        holder.Bind(learningHours1);
        Picasso.get().load(learningHours1.getImageUrl()).into(holder.hoursImageBadge);
    }

    @Override
    public int getItemCount() {
        return learningHours.size();
    }

    public class MyHourViewHolder extends RecyclerView.ViewHolder{
        ImageView hoursImageBadge;
        TextView txtName;
        TextView txtHours;
        final TextView txtCountry;

        public MyHourViewHolder(@NonNull View itemView) {
            super(itemView);

            hoursImageBadge = itemView.findViewById(R.id.imageBadge);
            txtName = itemView.findViewById(R.id.txtName);
            txtHours = itemView.findViewById(R.id.txtHours);
            txtCountry = itemView.findViewById(R.id.txtCountry);
        }

        public void Bind(LearningHours learningHours){
            txtName.setText(learningHours.getName());
            txtHours.setText(learningHours.getTime());
            txtCountry.setText(learningHours.getCountry() + ".");
        }
    }
}
