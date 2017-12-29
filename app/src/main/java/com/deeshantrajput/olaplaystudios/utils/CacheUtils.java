package com.deeshantrajput.olaplaystudios.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This is used to cache the data from the backend.
 */
public class CacheUtils implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (NetworkUtils.isNetworkAvailable()) {
            int maxAge = 60 * 60 * 24 * 3;
            request = request.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28;
            request = request.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }

        return chain.proceed(request);
    }
}
