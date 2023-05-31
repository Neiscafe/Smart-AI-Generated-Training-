package com.example.smart_development.feature_training_session.domain.model.training_picker

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class PickerStyle(
    val lineColor: Color = Color.Black, val lineLength: Float = 45f, val textSize: TextUnit = 16.sp
)
