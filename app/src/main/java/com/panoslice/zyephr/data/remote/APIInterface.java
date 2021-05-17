package com.panoslice.zyephr.data.remote;

import com.panoslice.zyephr.BuildConfig;
import com.panoslice.zyephr.data.model.api.BookResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("a0528e65-80c9-4172-9231-876a622f25ef")
    Observable<BookResponse> getBookResponse();
}
