package com.example.newsify

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.presentation.navgraph.Route
import com.example.newsify.domain.usecases.appentry.ReadAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry,
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        readAppEntry.invoke().onEach {startFromHomeScreen ->
            if(startFromHomeScreen)
                startDestination = Route.NewsNavigation.route
            else
                startDestination = Route.AppStartNavigation.route
            delay(300)
                splashCondition = false
        }.launchIn(viewModelScope)
    }
}