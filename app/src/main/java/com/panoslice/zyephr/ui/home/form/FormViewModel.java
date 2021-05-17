package com.panoslice.zyephr.ui.home.form;

import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.data.model.db.FormEntity;
import com.panoslice.zyephr.ui.base.BaseViewModel;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

public class FormViewModel extends BaseViewModel<FormNavigator> {
    public FormViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void insertData(FormEntity formEntity)
    {
        getCompositeDisposable().add(getDataManager().insert(formEntity)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {

                }, throwable -> {
                    setIsLoading(false);

                }));
    }

    public void clearData(FormEntity formEntity)
    {
        getCompositeDisposable().add(getDataManager().delete(formEntity)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {

                }, throwable -> {
                    setIsLoading(false);

                }));
    }
}
