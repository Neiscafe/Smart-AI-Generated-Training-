package com.example.smart_development.feature_training_session.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.smart_development.common.createToast
import com.example.smart_development.feature_training_session.domain.util.Routes
import com.example.smart_development.feature_training_session.presentation.new_training_session.components.NewTrainingScreen
import com.example.smart_development.feature_training_session.presentation.theme.SmartDevelopmentTheme
import com.example.smart_development.feature_training_session.presentation.training_sessions.components.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartDevelopmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MAIN_SCREEN
                    ) {
                        composable(Routes.MAIN_SCREEN) {
                            MainScreen(
                                onNavigate = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                        composable(route = Routes.NEW_TRAINING_SCREEN, arguments = listOf(
                            navArgument(name = "trainingSessionName") {
                                type = NavType.StringType
                                defaultValue = ""
                            }
                        )) {
                            NewTrainingScreen(onPopBackStack = {
                                navController.popBackStack()
                            }, onCreateToast = {
                                createToast(this@MainActivity, it)
                            })
                        }
                    }
                }
            }
        }
    }


}