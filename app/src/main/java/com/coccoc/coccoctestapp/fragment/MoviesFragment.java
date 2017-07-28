package com.coccoc.coccoctestapp.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coccoc.coccoctestapp.MainActivity;
import com.coccoc.coccoctestapp.R;
import com.coccoc.coccoctestapp.adapter.MoviesAdapter;
import com.coccoc.coccoctestapp.api.ApiUtils;
import com.coccoc.coccoctestapp.api.IMoviesService;
import com.coccoc.coccoctestapp.models.MoviesResponse;
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

public class MoviesFragment extends Fragment {
    private final String TAG = MoviesFragment.class.getSimpleName();
    private MoviesAdapter mAdapter;

    @BindView(R.id.rvMovies)
    RecyclerView mRecyclerView;
    private IMoviesService mService;
    private Unbinder mUnbinder;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;
    private MoviesResponse movies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle(R.string.actionbar_title_category);
        }
        // Check internet connect
        if (!Utils.checkNetworkConnectStatus(getActivity())) {
            ((MainActivity) getActivity()).showAlertTurnOnInternet();
            return view;
        }
        loadListMovies();
        return view;
    }

    private void initRecycleView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        if (mAdapter == null) {
            mAdapter = new MoviesAdapter(null, R.layout.list_item_movie, getActivity());
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        getActivity().registerReceiver(mNetworkChangeReceiver, filter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        getActivity().unregisterReceiver(mNetworkChangeReceiver);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    private void loadListMovies() {
        mService = ApiUtils.getMoviesService();
        Call<MoviesResponse> call = mService.getMovies();
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    movies = response.body();
                    initRecycleView();
                    mAdapter.updateMovies(movies);
                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    //TODO: handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                //TODO: Show error message
                Log.e(TAG, t.toString());
            }
        });
    }

    private BroadcastReceiver mNetworkChangeReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(final Context context, final Intent intent) {
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                if (Utils.checkNetworkConnectStatus(context)) {
                    loadListMovies();
                    AlertDialog dialog = ((MainActivity)getActivity()).getCurrentDialog();
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
            }
        }
    };
}
