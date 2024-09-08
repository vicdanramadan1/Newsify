package com.example.newsify.di

import android.content.Context
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsify.data.manager.LocalUserManagerImp
import com.example.newsify.domain.usecases.appentry.ReadAppEntry
import com.example.newsify.domain.usecases.appentry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(@ApplicationContext context: Context): LocalUserManager =
        LocalUserManagerImp(context)

    @Provides
    @Singleton
    fun provideReadAppEntryUseCase(localUserManager: LocalUserManager): ReadAppEntry =
        ReadAppEntry(localUserManager)

    @Provides
    @Singleton
    fun provideSaveAppEntryUseCase(localUserManager: LocalUserManager): SaveAppEntry =
        SaveAppEntry(localUserManager)
}
