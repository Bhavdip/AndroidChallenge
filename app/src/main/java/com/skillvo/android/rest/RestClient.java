package com.skillvo.android.rest;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.skillvo.android.rest.services.ProjectAPI;
import com.skillvo.android.utils.Consts;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class RestClient {

    private static Retrofit projectAdapter;
    private static ProjectAPI projectAPI;

    static {
        setupAuthRestClient();
    }

    private static void setupAuthRestClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new StethoInterceptor())
                .addInterceptor(new LoggingInterceptor()).build();

        projectAdapter = new Retrofit.Builder()
                .baseUrl(Consts.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public static ProjectAPI getProjectAPI() {
        if (projectAPI == null) {
            projectAPI = projectAdapter.create(ProjectAPI.class);
        }
        return projectAPI;
    }
}
