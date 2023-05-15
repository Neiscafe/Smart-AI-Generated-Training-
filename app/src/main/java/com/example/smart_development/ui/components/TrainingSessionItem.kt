package com.example.smart_development.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smart_development.model.TrainingSession
import com.example.smart_development.ui.samples.trainingSessionSample

@Composable
fun TrainingSessionItem(item: TrainingSession) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Gray),
        modifier = Modifier

    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)) {
            Column(
                Modifier
                    .padding(5.dp)
            ) {
                Text(text = item.title, fontSize = 20.sp)
                Text(text = item.type, fontSize = 16.sp)
            }
        }
    }
}

@Preview
@Composable
fun TrainingSessionItemPreview() {
    TrainingSessionItem(item = trainingSessionSample[1])
}