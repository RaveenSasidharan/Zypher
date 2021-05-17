package com.panoslice.zyephr.ui.home.books;

import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.HttpException;

public class BookViewModel extends BaseViewModel<BookNavigator> {
    public BookViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public void getBookList()
    {
        getCompositeDisposable().add(getDataManager().getBookResponse()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().updateWithBookResponse(response);

                }, throwable -> {
                    setIsLoading(false);

                }));
    }

}
