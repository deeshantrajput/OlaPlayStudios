package com.deeshantrajput.olaplaystudios.network;

import com.deeshantrajput.olaplaystudios.activities.Application;
import com.deeshantrajput.olaplaystudios.models.Result;
import com.deeshantrajput.olaplaystudios.utils.CacheUtils;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class OlaAPI {

      private static String endpointURL = "http://starlord.hackerearth.com/";
    private static OlaInternalAPI applicationService = null;

    public static OlaInternalAPI getApplicationService(){

        if(applicationService == null){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            //httpClient.connectTimeout(60*1000, TimeUnit.MILLISECONDS);
            httpClient.connectTimeout(30, TimeUnit.SECONDS); // connect timeout
            httpClient.readTimeout(30, TimeUnit.SECONDS);    // socket timeout
            httpClient.retryOnConnectionFailure(true);
            httpClient.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

            File httpCacheDirectory = new File(Application.getContext().getCacheDir(),"responses");
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(httpCacheDirectory,cacheSize);
            httpClient.cache(cache);
            httpClient.networkInterceptors().add(new CacheUtils());


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(endpointURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            applicationService = retrofit.create(OlaInternalAPI.class);

        }
        return applicationService;
    }

    public interface OlaInternalAPI{

        @GET("/studio")
        Call<List<Result>> getSongs();

    }
}
