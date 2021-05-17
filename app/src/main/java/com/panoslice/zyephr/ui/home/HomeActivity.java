package com.panoslice.zyephr.ui.home;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.panoslice.zyephr.BR;
import com.panoslice.zyephr.R;
import com.panoslice.zyephr.databinding.ActivityHomeBinding;
import com.panoslice.zyephr.di.component.ActivityComponent;
import com.panoslice.zyephr.ui.base.BaseActivity;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {

    private ActivityHomeBinding mHomeBinding;
    HomeStateAdapter homeStateAdapter = null;

    @Override
    public int getBindingVariable() {
        return BR.homeViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHomeBinding = getViewDataBinding();

        homeStateAdapter = new HomeStateAdapter(this);
        mHomeBinding.viewpager.setAdapter(homeStateAdapter);

        new TabLayoutMediator(mHomeBinding.tabLayout, mHomeBinding.viewpager,
                (tab, position) ->
                {
                    if (position == 0)
                        tab.setText("Books");
                    else if (position == 1)
                        tab.setText("Form");
                }
        ).attach();

    }
}
