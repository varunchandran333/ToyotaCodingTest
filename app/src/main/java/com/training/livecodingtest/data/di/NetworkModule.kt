package com.training.livecodingtest.data.di

import com.training.livecodingtest.data.service.ApiService
import com.training.livecodingtest.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val interceptor by lazy {
    HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
}

fun provideHttpClient() = OkHttpClient.Builder()
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(interceptor)
    .build()

fun provideGsonAdapter(): GsonConverterFactory = GsonConverterFactory.create()

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(gsonConverterFactory)
    .build()

fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

val networkModules = module {
    single { provideHttpClient() }
    single { provideGsonAdapter() }
    single { provideRetrofit(get(), get()) }
    single { provideApiService(get()) }
}
