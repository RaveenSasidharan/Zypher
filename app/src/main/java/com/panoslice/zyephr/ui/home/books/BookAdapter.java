package com.panoslice.zyephr.ui.home.books;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.panoslice.zyephr.data.model.api.Book;
import com.panoslice.zyephr.databinding.ListBookItemBinding;
import com.panoslice.zyephr.ui.base.BaseViewHolder;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    private List<Book> mBookList;
    private IBookAdapterListener iBookAdapterListener;

    public void setiBookAdapterListener(IBookAdapterListener iBookAdapterListener) {
        this.iBookAdapterListener = iBookAdapterListener;
    }

    public BookAdapter(List<Book> bookList)
    {
        this.mBookList = bookList;
    }


    public void setmBookList(List<Book> mBookList) {
        this.mBookList = mBookList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ListBookItemBinding listBookItemBinding = ListBookItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BookHolder(listBookItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.onBind(position);


    }

    @Override
    public int getItemCount() {
        if (mBookList == null)
            return 0;

        return mBookList.size();
    }

    public class BookHolder extends BaseViewHolder
    {
        private ListBookItemBinding mBookItemBinding;
        private Book mBook;
        public BookHolder(ListBookItemBinding bookItemBinding) {
            super(bookItemBinding.getRoot());
            this.mBookItemBinding = bookItemBinding;
            mBookItemBinding.setBookHolder(this);
        }

        @Override
        public void onBind(int position) {
            mBook = mBookList.get(position);
            mBookItemBinding.author.setText(mBook.getAuthor());
            mBookItemBinding.name.setText(mBook.getBookName());
            mBookItemBinding.category.setText(mBook.getCategory());
            mBookItemBinding.publishDate.setText(mBook.getPublishDate());
        }

        public void requestPreview()
        {
            iBookAdapterListener.requestBookPreview(mBook);
        }
    }
}
