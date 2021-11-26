package apiPackage;

import com.google.gson.annotations.SerializedName;

public class RequestData {
    @SerializedName("cat_id")
  private String cat_id="12";

    @Override
    public String toString() {
        return "RequestData{" +
                "cat_id='" + cat_id + '\'' +
                '}';
    }
}
