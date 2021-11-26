package apiPackage;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String TAG="MainApiClient";

    public static Retrofit retrofit=null;
    public static final String BASE_URL="https://livedio.in/manish/Fitness/api/";

    public static Retrofit getClient(String app_id, String country, String dversion,
                                String identify,String launchcount ,String osversion, String screen, String version,
                                     String os,String cat_id, String application_name){


        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClient= new OkHttpClient.Builder();
        addHeader(okHttpClient);
        return okHttpClient.build();
    }

    private static void addHeader(OkHttpClient.Builder okHttpClient) {
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request().newBuilder()
                        .addHeader("app_id", "livideoreversevideo")
                        .addHeader("unique_id", "livideoreversevideo")
                        .addHeader("country", "IN")
                        .addHeader("dversion", "Samsung")
                        .addHeader("identity", "NA")
                        .addHeader("launchcount", "1")
                        .addHeader("osversion", "23")
                        .addHeader("screen", "XHDPI")
                        .addHeader("version", "1")
                        .addHeader("os", "1")
                        .build();

                return chain.proceed(request);
            }
        });
    }

}
