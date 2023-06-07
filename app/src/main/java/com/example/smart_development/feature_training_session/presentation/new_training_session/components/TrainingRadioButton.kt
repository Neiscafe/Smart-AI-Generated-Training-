package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.TrainingPlace

@Composable
fun TrainingRadioButton(type: TrainingPlace, selected: Boolean, onClick: ()->Unit) {
    RadioButton(
        selected = selected,
        onClick = onClick)
    Text(text = type.place, modifier = Modifier)
}