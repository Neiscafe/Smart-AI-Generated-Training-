package com.example.smart_development.feature_training_session.domain.usecases

import androidx.annotation.DrawableRes
import com.example.smart_development.R

enum class TrainingType {
    STRENGTH{
        override val type = "Strength"
        override val description = "Low reps and volume, acute intensity"
        override val image = R.drawable.strength_training_image
    },
    HYPERTROPHY {
        override val type = "Hypertrophy"
        override val description = "Medium reps and volume, general intensity"
        override val image = R.drawable.hypertrophy_training_image
    },
    RESISTANCE {
        override val type = "Resistance"
        override val description = "High reps and volume, prolonged intensity"
        override val image = R.drawable.resistance_training_image
    };
    abstract val type: String
    abstract val description: String
    abstract val image: Int
}
