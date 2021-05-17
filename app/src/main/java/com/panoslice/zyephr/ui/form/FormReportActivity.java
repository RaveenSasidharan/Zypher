package com.panoslice.zyephr.ui.form;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.panoslice.zyephr.R;
import com.panoslice.zyephr.data.model.db.FormEntity;
import com.panoslice.zyephr.databinding.ActivityFormDetailsBinding;
import com.panoslice.zyephr.di.component.ActivityComponent;
import com.panoslice.zyephr.ui.base.BaseActivity;
import com.panoslice.zyephr.ui.home.books.BookAdapter;

import java.util.List;

public class FormReportActivity extends BaseActivity<ActivityFormDetailsBinding, FormReportViewModel>
    implements FormReportNavigator
{
    private ActivityFormDetailsBinding mReportBinding;

    FormReportAdapter  mFormReportAdapter;
    public static Intent newIntent(Context context)
    {
       return new Intent(context, FormReportActivity.class);
    }


    @Override
    public int getBindingVariable() {
        return BR.formReportViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_form_details;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.fetchFormDataList();
        mViewModel.setNavigator(this);
        mReportBinding = getViewDataBinding();

    }

    @Override
    public void populateReport(List<FormEntity> formEntityList) {

        mFormReportAdapter = new FormReportAdapter();
        mReportBinding.reportRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mReportBinding.reportRecycler.setAdapter(mFormReportAdapter);
        mFormReportAdapter.setFormEntityList(formEntityList);
        mFormReportAdapter.notifyDataSetChanged();
    }

    public void backButtonFinish()
    {
        finish();
    }
}
