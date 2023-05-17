package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import android.os.Process
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import com.example.smart_development.feature_training_session.presentation.new_training_session.NewTrainingSessionViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTrainingScreen(
    viewModel: NewTrainingSessionViewModel = koinViewModel(),
    onPopBackStack: () -> Unit,
) {
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ event->
            when(event){
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.ShowToast ->{
//                    Toast.makeText(, event.message, Toast.LENGTH_SHORT).show()
                }
                else->{}
            }
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(NewTrainingScreenEvent.DoneButtonClicked)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                )
            }
        }
    ) {
        Box(Modifier.padding(it)) {
            Column {
                TextField(
                    value = viewModel.prompt,
                    onValueChange = {newText->
                        viewModel.onEvent(NewTrainingScreenEvent.PromptTextChanged(newText))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun NewTrainingScreenPreview() {
//    NewTrainingScreen()
}