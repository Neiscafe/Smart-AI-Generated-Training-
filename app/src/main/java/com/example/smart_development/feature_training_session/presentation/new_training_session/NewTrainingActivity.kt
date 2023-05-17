package com.example.smart_development.feature_training_session.presentation.new_training_session

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smart_development.feature_training_session.domain.util.Routes
import com.example.smart_development.feature_training_session.presentation.theme.SmartDevelopmentTheme
import com.example.smart_development.feature_training_session.presentation.training_sessions.components.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewTrainingActivity : ComponentActivity() {
    private val viewModel by viewModel<NewTrainingSessionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartDevelopmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

