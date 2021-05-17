package com.panoslice.zyephr.data.model.api;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book  implements Serializable, Parcelable
{

    @SerializedName("book_name")
    @Expose
    private String bookName;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    public final static Creator<Book> CREATOR = new Creator<Book>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Book createFromParcel(android.os.Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return (new Book[size]);
        }

    }
            ;
    private final static long serialVersionUID = 1733668837327334169L;

    protected Book(android.os.Parcel in) {
        this.bookName = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
        this.category = ((String) in.readValue((String.class.getClassLoader())));
        this.publishDate = ((String) in.readValue((String.class.getClassLoader())));
        this.pageCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(bookName);
        dest.writeValue(author);
        dest.writeValue(category);
        dest.writeValue(publishDate);
        dest.writeValue(pageCount);
    }

    public int describeContents() {
        return 0;
    }

}