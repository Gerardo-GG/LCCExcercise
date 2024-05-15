package com.ibm.lcc_template.core.di

import com.ibm.lcc_template.data.network.TodosAPI
import com.ibm.lcc_template.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun apiClientProvider(retrofit: Retrofit): TodosAPI {
        return retrofit.create(TodosAPI::class.java)
    }

}