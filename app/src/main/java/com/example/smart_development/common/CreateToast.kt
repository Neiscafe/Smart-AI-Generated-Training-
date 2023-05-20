package com.example.smart_development.common

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable

fun createToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}