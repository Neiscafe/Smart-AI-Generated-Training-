package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.smart_development.feature_training_session.presentation.theme.black

@Composable
fun PickerRect(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier){
        drawRoundRect(
            size = Size(size.height, size.width),
            style = Stroke(width = 10f, join = StrokeJoin.Round),
            color = black,
            cornerRadius = CornerRadius(25f, 25f)
        )
    }
}