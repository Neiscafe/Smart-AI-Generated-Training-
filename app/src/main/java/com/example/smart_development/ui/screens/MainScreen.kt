package com.example.smart_development.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smart_development.model.TrainingSession
import com.example.smart_development.ui.components.TrainingSessionItem
import com.example.smart_development.ui.samples.trainingSessionSample

@Composable
fun MainScreen(trainingSessions: List<TrainingSession>) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Current Training Sessions", fontSize = 24.sp, fontWeight = FontWeight(400))
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding()) {
            items(trainingSessions) { trainingSession ->
                Spacer(modifier = Modifier.size(10.dp))
                TrainingSessionItem(item = trainingSession)
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(trainingSessionSample)
}