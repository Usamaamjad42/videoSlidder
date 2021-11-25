package com.fourteen.digital.videoslider;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    List<String> videoLists;
    Context context;
    ViewPager2 viewPager;

    public VideoAdapter(List<String> videoLists, Context context, ViewPager2 viewPager) {
        this.videoLists = videoLists;
        this.context = context;
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoHolder holder, final int position) {

        holder.videoView.setVideoPath(videoLists.get(position));

    }

    @Override
    public int getItemCount() {
        return videoLists.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        ImageButton play_button;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.videoView);
            play_button = itemView.findViewById(R.id.play_button);

            videoView.setOnTouchListener((view, motionEvent) -> {
                    if (videoView.isPlaying()) {
                        videoView.pause();
                        play_button.setVisibility(View.VISIBLE);
                    } else {
                        play_button.setVisibility(View.GONE);
                        videoView.start();
                    }
                return true;
            });
            play_button.setOnClickListener(view -> {
                if(videoView.isPlaying()){
                    videoView.pause();
                    play_button.setVisibility(View.VISIBLE);
                } else {
                    play_button.setVisibility(View.GONE);
                    videoView.start();
                }
            });
        }
    }


}
