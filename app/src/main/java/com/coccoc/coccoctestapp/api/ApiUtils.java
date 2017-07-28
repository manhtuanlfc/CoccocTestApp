package com.coccoc.coccoctestapp.api;

/**
 * Created by manht on 7/27/2017.
 */

public class ApiUtils {
    public static IMoviesService getMoviesService() {
        return RetrofitClient.getClient().create(IMoviesService.class);
    }
}
