package com.panoslice.zyephr.ui.book;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.panoslice.zyephr.BR;
import com.panoslice.zyephr.R;
import com.panoslice.zyephr.data.model.api.Book;
import com.panoslice.zyephr.databinding.ActivityBookDetailsBinding;
import com.panoslice.zyephr.di.component.ActivityComponent;
import com.panoslice.zyephr.ui.base.BaseActivity;

public class BookDetailsActivity extends BaseActivity<ActivityBookDetailsBinding, BookDetailViewModel> {


    public static Intent newIntent(Context context, Bundle bundle)
    {
        Intent intent = new Intent(context, BookDetailsActivity.class);
        intent.putExtras(bundle);

        return intent;
    }

    private Book mBook;

    private ActivityBookDetailsBinding mBookDetailsBinding;

    @Override
    public int getBindingVariable() {
        return BR.bookDetailModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_details;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBookDetailsBinding = getViewDataBinding();
        mBook = getIntent().getExtras().getParcelable("book");

        mBookDetailsBinding.author.setText(mBook.getAuthor());
        mBookDetailsBinding.name.setText(mBook.getBookName());
        mBookDetailsBinding.category.setText(mBook.getCategory());
        mBookDetailsBinding.page.setText(""+mBook.getPageCount());
        mBookDetailsBinding.publishDate.setText(mBook.getPublishDate());
    }

    public void backButtonFinish()
    {
        finish();
    }
}
