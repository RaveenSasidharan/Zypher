package com.panoslice.zyephr.ui.home.books;

import com.panoslice.zyephr.data.model.api.Book;

public interface IBookAdapterListener {
    void requestBookPreview(Book book);
}
