package com.example.smart_development.feature_training_session.presentation.new_training_session.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Popup

@Composable
fun TrainingAlertDialog(
    onConfirmButton: () -> Unit = {},
    onDismissButton: () -> Unit = {}, setShowDialog: (Boolean) -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = {
                onConfirmButton()
                setShowDialog(false)
            }) {
                Text(text = "Concluir")
            }
        },
        dismissButton = {
            TextButton(onClick = {onDismissButton()
                setShowDialog(false)
            }) {
                Text(text = "Cancelar")
            }
        },
        title = {
            Text(text = "Nomear treino")
        },
        text = {
            Text(text = "Dê um nome para seu treino")
        })
}