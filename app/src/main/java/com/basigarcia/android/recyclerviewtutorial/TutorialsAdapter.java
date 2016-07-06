package com.basigarcia.android.recyclerviewtutorial;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BasiV on 7/5/2016.
 */
public class TutorialsAdapter extends RecyclerView.Adapter<TutorialsAdapter.MyViewHolder> {
    private List<Tutorial> tutorialList;

    public TutorialsAdapter(List<Tutorial> tutorialList){
        this.tutorialList = tutorialList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, quality, viewCount;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.titleText);
            quality = (TextView) view.findViewById(R.id.qualityText);
            viewCount = (TextView) view.findViewById(R.id.viewsText);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tutorial currentTutorial = tutorialList.get(getAdapterPosition());
                    Snackbar snackbar = Snackbar.make(view, currentTutorial.getTitle() +
                            " clicked", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    tutorialList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });

        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tutorial_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tutorial tutorial = tutorialList.get(position);
        holder.title.setText(tutorial.getTitle());
        holder.quality.setText(tutorial.getQuality());
        holder.viewCount.setText(tutorial.getViews()+"");
    }

    @Override
    public int getItemCount() {
        return tutorialList.size();
    }



}
