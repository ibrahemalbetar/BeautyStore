package com.ibrahimalbitar.beautystore.data.services

import com.ibrahimalbitar.beautystore.data.model.ProductsResp
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/products.json")
    suspend fun getAllProducts() : ProductsResp
}