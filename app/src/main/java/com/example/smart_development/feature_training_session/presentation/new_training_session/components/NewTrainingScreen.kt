package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smart_development.feature_training_session.domain.usecases.TrainingType
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.TrainingPlace
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import com.example.smart_development.feature_training_session.presentation.new_training_session.NewTrainingSessionViewModel
import org.koin.androidx.compose.koinViewModel

const val TAG = ("NewTrainingScreen")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTrainingScreen(
    viewModel: NewTrainingSessionViewModel = koinViewModel(),
    onPopBackStack: () -> Unit = {},
    onCreateToast: (String) -> Unit = {}
) {
    val trainingTypeList =
        listOf(TrainingType.STRENGTH, TrainingType.HYPERTROPHY, TrainingType.RESISTANCE)
    val trainingPlaceList = listOf(TrainingPlace.HOME_SELECTED, TrainingPlace.GYM_SELECTED)

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
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "Why are you training?",
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Column {
                    for (trainingType in trainingTypeList) {
                        TrainingTab(
                            trainingType = trainingType, onClick = {
                                viewModel.onEvent(
                                    NewTrainingScreenEvent.TrainingTypeClicked(
                                        trainingType
                                    )
                                )
                            }, selected = viewModel.currentlySelectedTrainingType == trainingType
                        )
                    }
                }
                Text(
                    text = "Where will you be training?",
                    Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        for (trainingPlace in trainingPlaceList) {
                            TrainingRadioButton(type = trainingPlace,
                                selected = viewModel.currentlySelectedTrainingPlace == trainingPlace,
                                onClick = {
                                    viewModel.onEvent(
                                        NewTrainingScreenEvent.TrainingPlaceClicked(trainingPlace)
                                    )
                                })
                        }
                    }
                }
                Text(
                    text = "How many times per week you will exercise?",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )
                TrainingDaysSlider(
                    value = viewModel.currentlySelectedTrainingDays, onValueChange = { newValue ->
                        viewModel.onEvent(
                            NewTrainingScreenEvent.PickerTextChanged(newValue)
                        )
                    }, textValue = viewModel.currentlySelectedTrainingDays.toInt() / 10
                )
            }
        }
    }
}


@Preview
@Composable
fun NewTrainingScreenPreview() {
    NewTrainingScreen()
}