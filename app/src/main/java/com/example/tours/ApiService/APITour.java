package com.example.tours.ApiService;

import com.example.tours.Model.Auth;
import com.example.tours.Model.AuthRegister;
import com.example.tours.Model.ListTour;
import com.example.tours.Model.Tour;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APITour {


    //dinh nghia endpoint va cac field o day

    @POST("/user/login")
    @FormUrlEncoded
    Call<Auth> normalLogin(@Field("emailPhone") String emailPhone,
                           @Field("password") String password);

    @POST("/user/login/by-facebook")
    @FormUrlEncoded
    Call<Auth> facebookLogin(@Field("accessToken") String accessToken);

    @POST("/user/login/by-google")
    @FormUrlEncoded
    Call<Auth> googleLogin(@Field("accessToken") String accessToken);


    @POST("/user/register")
    @FormUrlEncoded
    Call<AuthRegister> Register(@Field("password") String password,
                                @Field("fullName") String fullName,
                                @Field("email") String email,
                                @Field("phone") String phone,
                                @Field("address") String address,
                                @Field("dob") String dob,
                                @Field("gender") Number gender);

    @GET("/tour/list")
    Call<ListTour> listTour(@Header("Authorization") String token,
                             @Query("rowPerPage") Integer rowPerPage,
                             @Query("pageNum") Integer pageNum,
                             @Query("orderBy") String orderBY,
                             @Query("isDescoptional") Boolean isDescoptional);
}