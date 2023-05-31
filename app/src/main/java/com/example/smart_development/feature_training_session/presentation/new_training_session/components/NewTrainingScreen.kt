package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smart_development.common.values.new_training.trainingTabItems
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
                    .padding(10.dp), verticalArrangement = Arrangement.Center
            ) {
                trainingTabItems.forEach { trainingType ->
                    TrainingTab(trainingStyle = trainingType)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = viewModel.homeRadioButtonState, onClick = {
                            viewModel.onEvent(
                                NewTrainingScreenEvent.RadioButtonPressed(TypeRadioButtonState.HOME_SELECTED)
                            )
                        })
                        Text(text = "Home", modifier = Modifier)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = viewModel.gymRadioButtonState, onClick = {
                            viewModel.onEvent(
                                NewTrainingScreenEvent.RadioButtonPressed(TypeRadioButtonState.GYM_SELECTED)
                            )
                        })
                        Text(text = "Gym", modifier = Modifier)
                    }
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Picker(
                        list = (1..7).toList(), onValueChange = { number ->
                            viewModel.onEvent(NewTrainingScreenEvent.PickerTextChanged(number))
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp), showAmount = 4
                    )
                    PickerRect(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "I will be training ${viewModel.pickerState} days a week",
                    modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
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