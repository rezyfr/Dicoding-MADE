package com.rezyfr.dicoding.core.di

import android.content.Context
import android.content.SharedPreferences
import com.rezyfr.dicoding.core.data.source.local.room.AppDatabase
import com.rezyfr.dicoding.core.data.source.local.room.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object DatabaseModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object DatabaseModule {

        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context) : SharedPreferences {
            return context.getSharedPreferences(context.packageName + "_pref", Context.MODE_PRIVATE)
        }

        @Provides
        @Singleton
        fun provideAppDatabase(
            @ApplicationContext context: Context
        ): AppDatabase {
            return AppDatabase.getInstance(context)
        }

        @Provides
        @Singleton
        fun provideFavoriteDao(appDatabase: AppDatabase): FavoriteDao {
            return appDatabase.favoriteDao()
        }
    }
}