
package categoryapipkg;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class Category {

    @SerializedName("catlist")
    private List<Catlist> mCatlist;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public List<Catlist> getCatlist() {
        return mCatlist;
    }

    public void setCatlist(List<Catlist> catlist) {
        mCatlist = catlist;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
