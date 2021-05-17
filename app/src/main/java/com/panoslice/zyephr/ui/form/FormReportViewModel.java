package com.panoslice.zyephr.ui.form;

import android.util.Log;

import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

public class FormReportViewModel extends BaseViewModel<FormReportNavigator> {
    public FormReportViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public void fetchFormDataList()
    {
        getCompositeDisposable().add(getDataManager().fetchAllReport()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    Log.e("report", "response");
                    getNavigator().populateReport(response);
                }, throwable -> {
                    setIsLoading(false);

                }));
    }
}
