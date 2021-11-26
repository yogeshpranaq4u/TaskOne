
package apiPackage;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class Dayslist {

    @SerializedName("exercise")
    private List<Exercise> mExercise;
    @SerializedName("sub_cat_id")
    private String mSubCatId;
    @SerializedName("sub_cat_name")
    private String mSubCatName;

    public List<Exercise> getExercise() {
        return mExercise;
    }

    public void setExercise(List<Exercise> exercise) {
        mExercise = exercise;
    }

    public String getSubCatId() {
        return mSubCatId;
    }

    public void setSubCatId(String subCatId) {
        mSubCatId = subCatId;
    }

    public String getSubCatName() {
        return mSubCatName;
    }

    public void setSubCatName(String subCatName) {
        mSubCatName = subCatName;
    }

    @Override
    public String toString() {
        return "Dayslist{" +
                "mExercise=" + mExercise +
                ", mSubCatId='" + mSubCatId + '\'' +
                ", mSubCatName='" + mSubCatName + '\'' +
                '}';
    }
}
