package com.example.todojetpackcomposemvvm.data.models

import androidx.compose.ui.graphics.Color
import com.example.todojetpackcomposemvvm.ui.theme.HighPriorityColor
import com.example.todojetpackcomposemvvm.ui.theme.LowPriorityColor
import com.example.todojetpackcomposemvvm.ui.theme.MediumPriorityColor
import com.example.todojetpackcomposemvvm.ui.theme.NonePriorityColor

enum class Priority (val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}