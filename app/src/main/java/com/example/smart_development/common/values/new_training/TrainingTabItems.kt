package com.example.smart_development.common.values.new_training

import com.example.smart_development.R
import com.example.smart_development.feature_training_session.domain.model.training_types.Descriptions
import com.example.smart_development.feature_training_session.domain.model.training_types.TrainingStyle
import com.example.smart_development.feature_training_session.domain.model.training_types.Types

val trainingTabItems = listOf(
    TrainingStyle(
        type = Types.strenght,
        description = Descriptions.strength,
        image = R.drawable.strength_training_image
    ), TrainingStyle(
        type = Types.resistance,
        description = Descriptions.resistance,
        image = R.drawable.resistance_training_image
    ), TrainingStyle(
        type = Types.hypertrophy,
        description = Descriptions.hypertrophy,
        image = R.drawable.hypertrophy_training_image
    )
)