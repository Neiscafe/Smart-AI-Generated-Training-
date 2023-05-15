package com.example.smart_development.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

fun <T> T.toFlow(): Flow<T> {
    return flow {
        emit(this@toFlow)
    }
}