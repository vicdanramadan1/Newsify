package com.example.newsify.domain.usecases.appentry

import com.example.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}