package com.panoslice.zyephr.data.model.api;

import java.io.Serializable;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookResponse implements Serializable, Parcelable
{

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Book> data = null;
    public final static Creator<BookResponse> CREATOR = new Creator<BookResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BookResponse createFromParcel(android.os.Parcel in) {
            return new BookResponse(in);
        }

        public BookResponse[] newArray(int size) {
            return (new BookResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2345320496088778735L;

    protected BookResponse(android.os.Parcel in) {
        this.statusCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.panoslice.zyephr.data.model.api.Book.class.getClassLoader()));
    }

    public BookResponse() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(statusCode);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return 0;
    }

}
