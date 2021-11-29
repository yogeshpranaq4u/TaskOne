
package categoryapipkg;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Catlist {

    @SerializedName("cat_id")
    private String mCatId;
    @SerializedName("cat_name")
    private String mCatName;
    @SerializedName("day_count")
    private String mDayCount;
    @SerializedName("inapp")
    private String mInapp;
    @SerializedName("large_image")
    private String mLargeImage;
    @SerializedName("mini_image")
    private String mMiniImage;

    public String getCatId() {
        return mCatId;
    }

    public void setCatId(String catId) {
        mCatId = catId;
    }

    public String getCatName() {
        return mCatName;
    }

    public void setCatName(String catName) {
        mCatName = catName;
    }

    public String getDayCount() {
        return mDayCount;
    }

    public void setDayCount(String dayCount) {
        mDayCount = dayCount;
    }

    public String getInapp() {
        return mInapp;
    }

    public void setInapp(String inapp) {
        mInapp = inapp;
    }

    public String getLargeImage() {
        return mLargeImage;
    }

    public void setLargeImage(String largeImage) {
        mLargeImage = largeImage;
    }

    public String getMiniImage() {
        return mMiniImage;
    }

    public void setMiniImage(String miniImage) {
        mMiniImage = miniImage;
    }

    @Override
    public String toString() {
        return "Catlist{" +
                "mCatId='" + mCatId + '\'' +
                ", mCatName='" + mCatName + '\'' +
                ", mDayCount='" + mDayCount + '\'' +
                ", mInapp='" + mInapp + '\'' +
                ", mLargeImage='" + mLargeImage + '\'' +
                ", mMiniImage='" + mMiniImage + '\'' +
                '}';
    }
}
