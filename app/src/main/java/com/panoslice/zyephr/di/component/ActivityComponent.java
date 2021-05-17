package com.panoslice.zyephr.di.component;

import com.panoslice.zyephr.di.module.ActivityModule;
import com.panoslice.zyephr.di.scope.ActivityScope;
import com.panoslice.zyephr.ui.book.BookDetailsActivity;
import com.panoslice.zyephr.ui.form.FormReportActivity;
import com.panoslice.zyephr.ui.home.HomeActivity;

import dagger.Component;



@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(BookDetailsActivity activity);

    void inject(FormReportActivity activity);


}
