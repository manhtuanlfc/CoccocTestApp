package com.coccoc.coccoctestapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coccoc.coccoctestapp.MainActivity;
import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.api.ApiUtils;
import com.coccoc.coccoctestapp.api.IMoviesService;
import com.coccoc.coccoctestapp.models.MovieDetails;
import com.coccoc.coccoctestapp.models.MovieDetailsResponse;
import com.coccoc.coccoctestapp.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manht on 7/27/2017.
 */

public class MovieDetailsFragment extends Fragment {
    private final String TAG = MovieDetailsFragment.class.getSimpleName();
    private static final String KEY_MOVIE_ID = "movie_id";

    @BindView(R.id.tvMovieTitle)
    TextView mMovieTitleView;
    @BindView(R.id.imvMovieDetail)
    ImageView mMovieImagView;
    @BindView(R.id.tvDirector)
    TextView mDirectorView;
    @BindView(R.id.tvActress)
    TextView mActressView;
    @BindView(R.id.tvReleaseDate)
    TextView mReleaseView;
    @BindView(R.id.tvGenre)
    TextView mGenreView;
    @BindView(R.id.tvEndTime)
    TextView mEndTimeView;
    @BindView(R.id.tvMovieDescription)
    TextView mDescriptionView;
    private IMoviesService mService;
    private Unbinder mUnbinder;
    private String mMovieId;

    public static MovieDetailsFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(KEY_MOVIE_ID, id);
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovieId = getArguments().getString(KEY_MOVIE_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.actionbar_title_movie_detail);
        }
        mUnbinder = ButterKnife.bind(this, view);
        mService = ApiUtils.getMoviesService();
        Log.d(TAG,"movie_id: "+ mMovieId);
        Call<MovieDetailsResponse> call = mService.getMovieDetails(mMovieId);
        call.enqueue(new Callback<MovieDetailsResponse>() {
            @Override
            public void onResponse(Call<MovieDetailsResponse> call, Response<MovieDetailsResponse> response) {
                if (response.isSuccessful()) {
                    final MovieDetails movieDetails = response.body().getData();
                    if (movieDetails == null)
                        return;
                    String imgUrl = movieDetails.getThumbnail();
                    Glide.with(getActivity()).load(imgUrl)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(mMovieImagView);
                    mMovieTitleView.setText(movieDetails.getName());
                    mDirectorView.setText(Utils.fromHtml(getString(R.string.movie_director,
                            movieDetails.getMovieDirector())));
                    mActressView.setText(Utils.fromHtml(getString(R.string.movie_actress,
                            movieDetails.getMovieActress())));
                    mReleaseView.setText(Utils.fromHtml(getString(R.string.movie_release_date,
                            Utils.convertFormatDate(movieDetails.getReleaseDate()))));
                    mGenreView.setText(Utils.fromHtml(getString(R.string.movie_genre,
                            movieDetails.getGenre())));
                    mEndTimeView.setText(Utils.fromHtml(getString(R.string.movie_endtime,
                            movieDetails.getMovieEndtime())));
                    mDescriptionView.setText(movieDetails.getFullDescription());
                }
            }

            @Override
            public void onFailure(Call<MovieDetailsResponse> call, Throwable t) {
                //TODO: Show error message
                Log.e(TAG, t.toString());
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
