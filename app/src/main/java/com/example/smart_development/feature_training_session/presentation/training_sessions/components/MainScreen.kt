package com.example.smart_development.feature_training_session.presentation.training_sessions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import com.example.smart_development.feature_training_session.domain.usecases.MainScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import com.example.smart_development.feature_training_session.presentation.training_sessions.TrainingSessionsViewModel
import com.example.smart_development.feature_training_session.presentation.training_sessions.components.TrainingSessionItem
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigate: (UiEvent.Navigate) -> Unit = {},
    viewModel: TrainingSessionsViewModel = koinViewModel(),
) {
    val trainingSessions = viewModel.getAllTrainings().collectAsState(initial = emptyList<TrainingSession>())
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{event ->
            when (event){
                is UiEvent.Navigate -> onNavigate(event)
                else -> {}
            }
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(MainScreenEvent.CreateButtonClicked)
                },
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
    ) {
        Box(Modifier.padding(it)) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Text(
                    text = "Current Training Sessions",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400)
                )
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding()
                ) {
                    items(trainingSessions.value) { trainingSession ->
                        Spacer(modifier = Modifier.size(10.dp))
                        TrainingSessionItem(item = trainingSession,
                            onEvent = viewModel::onEvent,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {})
                    }
                }
            }

        }
    }
}
