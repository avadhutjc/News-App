package com.ajc.lattice.model.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/everything?q=tesla&from=2021-12-29&sortBy=publishedAt&apiKey=API_KEY

//https://newsapi.org/v2/everything?q=india?apiKey=b5becfb5a3d34c7991cb1af2c22c0d57

//https://newsapi.org/v2/everything?q=apple&from=2022-02-13&to=2022-02-13&sortBy=popularity&apiKey=fae21d18f4d340a082012b9948883602
interface ApiService {
    @GET("v2/everything")
    suspend fun getData(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ): Response<com.ajc.lattice.model.remote.ResponseDTO>
}