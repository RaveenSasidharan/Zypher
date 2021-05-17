package com.panoslice.zyephr.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.panoslice.zyephr.BuildConfig;
import com.panoslice.zyephr.data.model.api.BookResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;;


@Singleton
public class AppApiHelper implements ApiHelper {

    public Retrofit mRetrofit;

    private  Object clientLocker = new Object();

    @Inject
    public AppApiHelper() {
    }

    public  Retrofit getRetrofitInstance() {

        GsonBuilder builder;
        builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();


        if (mRetrofit == null) {
            synchronized (clientLocker) {
                if (mRetrofit != null)
                    return mRetrofit;


                mRetrofit = new Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getRequestHeader())
                        .build();

            }
        }



        return mRetrofit;
    }


    private  static  OkHttpClient getRequestHeader() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.header("Content-Type", "application/json");
                requestBuilder.header("Accept", "application/json");
                return chain.proceed(requestBuilder.build());
            }
        });

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient httpClient;

        if (BuildConfig.DEBUG)
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder requestBuilder = chain.request().newBuilder();
                            requestBuilder.header("Content-Type", "application/json");
                            requestBuilder.header("Accept", "application/json");
                            return chain.proceed(requestBuilder.build());
                        }
                    })
                    .build();

        else
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)

                    .build();

        return httpClient;
    }


    @Override
    public Observable<BookResponse> getBookResponse() {
        APIInterface apiInterface = getRetrofitInstance().create(APIInterface.class);
        return apiInterface.getBookResponse();
    }
}
