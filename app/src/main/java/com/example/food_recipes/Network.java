package com.example.food_recipes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_PRAGMA = "Pragma";
    private static final String BASE_URL = " https://www.themealdb.com/";
    private static final String TAG = Network.class.getSimpleName();

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);


    public static retrofit2.Retrofit getRetrofitInstance(final Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024))
                .addInterceptor(httpLoggingInterceptor)
//                .addNetworkInterceptor(networkInterceptor())
//                .addInterceptor(offlineInterceptor(context))
                .build();

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);
        return builder.build();
    }
//    public static Boolean hasNetwork(Context context) {
//        boolean isConnected = false;
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
//        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting())
//            isConnected = true;
//        return isConnected;
//    }
//
//    private static Interceptor offlineInterceptor(final Context context) {
//        return new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Log.d(TAG, "offline interceptor: called.");
//                Request request = chain.request();
//
//                if (!hasNetwork(context)) {
//                    CacheControl cacheControl = new CacheControl.Builder()
//
//                            .maxStale(2, TimeUnit.SECONDS)
//                            .build();
//
//                    request = ((Request) request).newBuilder()
//                            .removeHeader(HEADER_PRAGMA)
//                            .removeHeader(HEADER_CACHE_CONTROL)
//                            .cacheControl(cacheControl)
//                            .build();
//                }
//
//                return chain.proceed(request);
//            }
//        };
//    }
//
//
//    private static Interceptor networkInterceptor() {
//        return new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Log.d(TAG, "network interceptor: called.");
//
//                Response response = chain.proceed(chain.request());
//
//                CacheControl cacheControl = new CacheControl.Builder()
//
//                        .maxAge(120, TimeUnit.MINUTES)
//                        .build();
//
//                return response.newBuilder()
//                        .removeHeader(HEADER_PRAGMA)
//                        .removeHeader(HEADER_CACHE_CONTROL)
//                        .header(HEADER_CACHE_CONTROL, cacheControl.toString())
//                        .build();
//            }
//        };
//    }
//


}
