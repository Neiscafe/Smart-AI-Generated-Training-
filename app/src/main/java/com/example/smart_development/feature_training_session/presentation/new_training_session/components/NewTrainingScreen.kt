package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smart_development.R
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.TypeRadioButtonState
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import com.example.smart_development.feature_training_session.presentation.new_training_session.NewTrainingSessionViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTrainingScreen(
    viewModel: NewTrainingSessionViewModel = koinViewModel(),
    onPopBackStack: () -> Unit = {},
    onCreateToast: (String) -> Unit = {}
) {
    val tabItems = listOf(
        TrainingType(
            type = Types.strenght,
            description = Descriptions.strength,
            image = R.drawable.strength_training_image
        ), TrainingType(
            type = Types.resistance,
            description = Descriptions.resistance,
            image = R.drawable.resistance_training_image
        ), TrainingType(
            type = Types.hypertrophy,
            description = Descriptions.hypertrophy,
            image = R.drawable.hypertrophy_training_image
        )
    )

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.ShowToast -> onCreateToast(event.message)
                else -> {}
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(NewTrainingScreenEvent.DoneButtonClicked)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                )
            }
        },
    ) {
        Box(Modifier.padding(it)) {
            Column(Modifier.padding(10.dp)) {
                tabItems.forEach { trainingType ->
                    TrainingTab(trainingType = trainingType)
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = viewModel.homeRadioButtonSelected, onClick = {
                        viewModel.onEvent(
                            NewTrainingScreenEvent.RadioButtonClicked(TypeRadioButtonState.HOME_SELECTED)
                        )
                    })
                    Text(text = "Home", modifier = Modifier)
                    RadioButton(selected = viewModel.gymRadioButtonSelected, onClick = {
                        viewModel.onEvent(
                            NewTrainingScreenEvent.RadioButtonClicked(TypeRadioButtonState.GYM_SELECTED)
                        )
                    })
                    Text(text = "Gym", modifier = Modifier)
                }
            }
        }
    }
}

@Preview
@Composable
fun NewTrainingScreenPreview() {
    NewTrainingScreen()
}