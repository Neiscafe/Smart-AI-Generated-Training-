package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smart_development.R

@Composable
fun TrainingTab(trainingType: TrainingType) {

    val brush = Brush.horizontalGradient(listOf(Color.Black, Color.Transparent))

    Card(
        modifier = Modifier.fillMaxWidth(), border = BorderStroke(
            width = 3.dp, color = Color.Black
        ), shape = RoundedCornerShape(30.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = trainingType.image),
                contentDescription = "hypertrophy",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.blur(
                    radiusX = 1.dp, radiusY = 10.dp, edgeTreatment = BlurredEdgeTreatment(
                        RoundedCornerShape(10.dp)
                    )
                )
//                colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0f) })
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Text(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(600),
                    text = trainingType.type,
                    color = Color.White
                )
//                Text(
//                    fontSize = 16.sp, fontWeight = FontWeight(400), text = trainingType.description
//                )
            }
        }
    }
    Spacer(modifier = Modifier.size(5.dp))
}

@Preview(showBackground = true)
@Composable
fun TrainingTabPreview() {
    TrainingTab(
        TrainingType(
            type = Types.hypertrophy,
            description = Descriptions.hypertrophy,
            image = R.drawable.resistance_training_image
        )
    )
}