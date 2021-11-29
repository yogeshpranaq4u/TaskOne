package apiPackage;

import categoryapipkg.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CatergoryApiInterface {

    @POST("category")
    Call<Category> getCategory();
}
