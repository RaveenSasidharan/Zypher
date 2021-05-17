package com.panoslice.zyephr.ui.home.books;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.panoslice.zyephr.BR;
import com.panoslice.zyephr.R;
import com.panoslice.zyephr.data.model.api.Book;
import com.panoslice.zyephr.data.model.api.BookResponse;
import com.panoslice.zyephr.databinding.FragmentBookBinding;
import com.panoslice.zyephr.di.component.FragmentComponent;
import com.panoslice.zyephr.ui.base.BaseFragment;
import com.panoslice.zyephr.ui.book.BookDetailsActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookFragment extends BaseFragment<FragmentBookBinding, BookViewModel>
        implements BookNavigator,
        SearchView.OnQueryTextListener,
        SearchView.OnCloseListener,
        IBookAdapterListener{

    private FragmentBookBinding mBookBinding;
    private BookAdapter mBookAdapter;
    private List<Book> mBookList;

    @Override
    public int getBindingVariable() {
        return BR.bookModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    public void performDependencyInjection(FragmentComponent buildComponent) {
        buildComponent.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBookBinding = getViewDataBinding();
        mBookBinding.bookSearch.setOnCloseListener(this);
        mBookBinding.bookSearch.setOnQueryTextListener(this);
        mBookBinding.setBookFragment(this);
        mViewModel.setNavigator(this);
        mViewModel.getBookList();
        mBookBinding.shimmerFrameLayout.startShimmer();
    }

    @Override
    public void updateWithBookResponse(BookResponse bookResponse) {
        mBookBinding.shimmerFrameLayout.stopShimmer();
        mBookBinding.shimmerFrameLayout.setVisibility(View.INVISIBLE);
        mBookList = bookResponse.getData();
        mBookAdapter = new BookAdapter(bookResponse.getData());
        mBookBinding.bookRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mBookBinding.bookRecycler.setAdapter(mBookAdapter);
        mBookAdapter.setiBookAdapterListener(this);
        mBookAdapter.notifyDataSetChanged();
    }

    public void showFilter()
    {
        PopupMenu popupMenu = new PopupMenu(getActivity(), mBookBinding.filter);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                List<Book> sortedBook = new ArrayList<>();
                switch (item.getItemId())
                {
                    case R.id.book_name:

                        Collections.sort(mBookList, new Comparator<Book>() {
                            @Override
                            public int compare(Book book1, Book book2) {
                                return book1.getBookName().compareTo(book2.getBookName());
                            }
                        });

                        break;

                    case R.id.author:

                        Collections.sort(mBookList, new Comparator<Book>() {
                            @Override
                            public int compare(Book book1, Book book2) {
                                return book1.getAuthor().compareTo(book2.getAuthor());
                            }
                        });

                        break;

                    case R.id.category:
                        Collections.sort(mBookList, new Comparator<Book>() {
                            @Override
                            public int compare(Book book1, Book book2) {
                                return book1.getCategory().compareTo(book2.getCategory());
                            }
                        });
                        break;

                    case R.id.publish_date:

                        Collections.sort(mBookList, new Comparator<Book>() {
                            @Override
                            public int compare(Book book1, Book book2) {
                                return book1.getPublishDate().compareTo(book2.getBookName());
                            }
                        });
                        break;

                    case R.id.pages:
                        Collections.sort(mBookList, new Comparator<Book>() {
                            @Override
                            public int compare(Book book1, Book book2) {
                                return book1.getPageCount()  - book2.getPageCount();
                            }
                        });
                        break;

                }

               // mBookAdapter.setmBookList(sortedBook);
                mBookAdapter.notifyDataSetChanged();
                return false;
            }
        });
        popupMenu.inflate(R.menu.fillter_popup_menu);
        popupMenu.show();

    }

    @Override
    public boolean onClose() {

        mBookAdapter.setmBookList(mBookList);
        mBookAdapter.notifyDataSetChanged();
        return false;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        if ( (query == null || TextUtils.isEmpty(query))
                        && mBookList != null)
        {
            mBookAdapter.setmBookList(mBookList);
            mBookAdapter.notifyDataSetChanged();
            return false;
        }

        Predicate<Book> bookPredicate = book ->book.getBookName().toLowerCase().contains(query.toLowerCase());
        List<Book> filteredList = mBookList.stream().filter(bookPredicate).collect(Collectors.toList());
        mBookAdapter.setmBookList(filteredList);
        mBookAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {

        if ( (query == null || TextUtils.isEmpty(query))
                        && mBookList != null)
        {
            mBookAdapter.setmBookList(mBookList);
            mBookAdapter.notifyDataSetChanged();
            return false;
        }

        Predicate<Book> bookPredicate = book ->book.getBookName().toLowerCase().contains(query.toLowerCase());
        List<Book> filteredList = mBookList.stream().filter(bookPredicate).collect(Collectors.toList());
        mBookAdapter.setmBookList(filteredList);
        mBookAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public void requestBookPreview(Book book) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);
        startActivity(BookDetailsActivity.newIntent(getActivity(), bundle));
    }
}
