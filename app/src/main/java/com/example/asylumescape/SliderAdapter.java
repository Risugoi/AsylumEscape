package com.example.asylumescape;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

    private List<Story> storyContent;
    private ViewPager2 viewPager2;

    SliderAdapter(List<Story> storyContent, ViewPager2 viewPager2) {
        this.storyContent = storyContent;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.story_container,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(storyContent.get(position));
    }

    @Override
    public int getItemCount() {
        return storyContent.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public SliderViewHolder(@NonNull View itemView){
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
        }

        void setImage(Story SliderItem){
            imageView.setImageResource(SliderItem.getImage());
        }
    }

}
