package com.panoslice.zyephr.di.module;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.panoslice.zyephr.ViewModelProviderFactory;
import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.ui.base.BaseDialog;
import com.panoslice.zyephr.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/*
 * Author: rotbolt
 */

@Module
public class DialogModule {

    private BaseDialog dialog;

    public DialogModule(BaseDialog dialog){
        this.dialog = dialog;
    }


}
