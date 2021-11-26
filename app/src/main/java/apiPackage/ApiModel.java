
package apiPackage;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class ApiModel {

    @SerializedName("dayslist")
    private List<Dayslist> mDayslist;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public List<Dayslist> getDayslist() {
        return mDayslist;
    }

    public void setDayslist(List<Dayslist> dayslist) {
        mDayslist = dayslist;
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

    @Override
    public String toString() {
        return "ApiModel{" +
                "mDayslist=" + mDayslist +
                ", mMessage='" + mMessage + '\'' +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }
}
