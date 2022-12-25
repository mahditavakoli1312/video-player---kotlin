package com.example.stream.core.ui

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest


inline fun <T> Flow<T>.collectOnActivity(
    activity: ComponentActivity,
    crossinline onCollect: (T) -> Unit
) {
    activity.lifecycleScope.launchWhenStarted {
        this@collectOnActivity.collectLatest {
            onCollect(it)
        }
    }
}

inline fun <T> Flow<T>.collectOnFragment(
    fragment: Fragment,
    crossinline onCollect: (T) -> Unit
) {
    fragment.lifecycleScope.launchWhenStarted {
        this@collectOnFragment.collectLatest {
            onCollect(it)
        }
    }
}