package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent

@Composable
fun TrainingDaysSlider(value: Float, onValueChange: (Float) -> Unit, textValue: Int) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 10f..70f,
        steps = 5
    )
    Text(
        text = "$textValue days a week",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}