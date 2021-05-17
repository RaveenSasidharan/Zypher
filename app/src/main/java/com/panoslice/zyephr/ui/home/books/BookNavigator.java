package com.panoslice.zyephr.ui.home.books;

import com.panoslice.zyephr.data.model.api.BookResponse;
import com.panoslice.zyephr.ui.base.Navigator;

public interface BookNavigator  extends Navigator {

    void updateWithBookResponse(BookResponse bookResponse);
}
