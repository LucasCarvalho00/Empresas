package br.com.ioasys.lucascarvalho.empresas.Models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public interface Service {

    String TOKEN_SHARED = "ServiceToken";
    String URL = "http://54.94.179.135:8090/api/v1/";

    @POST("users/auth/sign_in")
    Call<UserResponse> login(@Body User user);

    @GET("enterprises")
    Call<EnterpriseSearchResponse> getEnterprises(@Query("name") String name,
                                                  @Header("access-token") String access_token,
                                                  @Header("client") String client,
                                                  @Header("uid") String uid);

    @GET("enterprises/{id}")
    Call<EnterpriseType> getEnterpriseDetails(@Path("id") int id,
                                              @Header("access-token") String access_token,
                                              @Header("client") String client,
                                              @Header("uid") String uid);


    }
