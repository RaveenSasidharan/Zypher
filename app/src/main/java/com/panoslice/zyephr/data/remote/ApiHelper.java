

package com.panoslice.zyephr.data.remote;


import com.panoslice.zyephr.data.model.api.BookResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    Observable<BookResponse> getBookResponse();
}
