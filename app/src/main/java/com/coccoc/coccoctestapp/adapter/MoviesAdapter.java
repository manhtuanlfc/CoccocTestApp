package com.coccoc.coccoctestapp.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coccoc.coccoctestapp.MainActivity;
import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.fragment.MovieDetailsFragment;
import com.coccoc.coccoctestapp.models.Movies;
import com.coccoc.coccoctestapp.models.MoviesResponse;
import com.coccoc.coccoctestapp.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manht on 7/27/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private MoviesResponse mMoviesData;
    private int mRowLayout;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mMoviesLayout;
        @BindView(R.id.imvMovies)
        ImageView mMoviesImageView;
        @BindView(R.id.tvTitle)
        TextView mMovieTitleView;
        @BindView(R.id.tvReleaseDate)
        TextView mReleaseDateView;

        public MovieViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public MoviesAdapter(MoviesResponse movies, int rowLayout, Context context) {
        this.mMoviesData = movies;
        this.mRowLayout = rowLayout;
        this.mContext = context;
        mFragmentManager = ((Activity) mContext).getFragmentManager();
    }

    public void updateMovies(MoviesResponse items) {
        mMoviesData = items;
        notifyDataSetChanged();
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mRowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        final Movies movies = mMoviesData.getData().get(position);
        if (movies == null)
            return;
        String movieName = movies.getName();
        String releaseDate = movies.getReleaseDate();
        holder.mMovieTitleView.setText(movieName);
        holder.mReleaseDateView.setText(Utils.convertFormatDate(releaseDate));
        String imgUrl = movies.getThumbnail();
        Glide.with(mContext).load(imgUrl)
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mMoviesImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check internet connect
                if (!Utils.checkNetworkConnectStatus(mContext)){
                    ((MainActivity)mContext).showAlertTurnOnInternet();
                    return;
                }
                mTransaction = mFragmentManager.beginTransaction();
                Fragment fragment = MovieDetailsFragment.newInstance(movies.getId());
                mTransaction.replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mMoviesData != null && !mMoviesData.getData().isEmpty())
            return mMoviesData.getData().size();
        return 0;
    }
}
