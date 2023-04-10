package com.myapplication.testwsh.di.modules

import android.content.Context
import com.google.gson.Gson
import com.myapplication.data.api.ApiService
import com.myapplication.data.storage.AutoLoginStorage
import com.myapplication.data.storage.SharedPrefStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    private const val BASE_URL="http://192.168.0.3:8080/" //192.168.0.3 for my device 10.0.2.2:8080
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
    @Singleton
    @Provides
    fun providesUserStorage(@ApplicationContext context: Context):AutoLoginStorage{
    return SharedPrefStorage(context = context)
    }
}