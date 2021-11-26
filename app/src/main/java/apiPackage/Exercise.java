
package apiPackage;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Exercise {

    @SerializedName("animation")
    private String mAnimation;
    @SerializedName("audio")
    private String mAudio;
    @SerializedName("audio_text")
    private String mAudioText;
    @SerializedName("calories")
    private String mCalories;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("heading")
    private String mHeading;
    @SerializedName("sets")
    private String mSets;
    @SerializedName("sub_cat_id")
    private String mSubCatId;
    @SerializedName("time")
    private String mTime;
    @SerializedName("type")
    private String mType;

    public String getAnimation() {
        return mAnimation;
    }

    public void setAnimation(String animation) {
        mAnimation = animation;
    }

    public String getAudio() {
        return mAudio;
    }

    public void setAudio(String audio) {
        mAudio = audio;
    }

    public String getAudioText() {
        return mAudioText;
    }

    public void setAudioText(String audioText) {
        mAudioText = audioText;
    }

    public String getCalories() {
        return mCalories;
    }

    public void setCalories(String calories) {
        mCalories = calories;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getHeading() {
        return mHeading;
    }

    public void setHeading(String heading) {
        mHeading = heading;
    }

    public String getSets() {
        return mSets;
    }

    public void setSets(String sets) {
        mSets = sets;
    }

    public String getSubCatId() {
        return mSubCatId;
    }

    public void setSubCatId(String subCatId) {
        mSubCatId = subCatId;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "mAnimation='" + mAnimation + '\'' +
                ", mAudio='" + mAudio + '\'' +
                ", mAudioText='" + mAudioText + '\'' +
                ", mCalories='" + mCalories + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mHeading='" + mHeading + '\'' +
                ", mSets='" + mSets + '\'' +
                ", mSubCatId='" + mSubCatId + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mType='" + mType + '\'' +
                '}';
    }
}
