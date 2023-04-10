package com.myapplication.testwsh.di.modules

import com.google.gson.Gson
import com.myapplication.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL="http://10.0.2.2:8080/" //192.168.16.102 for my device
    @Singleton
    @Provides
    fun providesHttpLoggingIntercepter() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor)  =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    @Singleton
    @Provides
    fun providesRetrogit(okHttpClient: OkHttpClient)=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

}