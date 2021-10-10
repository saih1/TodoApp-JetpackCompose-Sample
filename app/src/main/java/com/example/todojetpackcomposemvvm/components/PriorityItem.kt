package com.example.todojetpackcomposemvvm.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todojetpackcomposemvvm.data.models.Priority
import com.example.todojetpackcomposemvvm.ui.theme.LARGE_PADDING
import com.example.todojetpackcomposemvvm.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.todojetpackcomposemvvm.ui.theme.Shapes
import com.example.todojetpackcomposemvvm.ui.theme.Typography

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
//            drawRoundRect(color = priority.color)
//            drawArc(color = priority.color, startAngle = 25F, sweepAngle = 310F, useCenter = true, alpha = 1F)
        }
        Text(
            modifier = Modifier.padding(start = LARGE_PADDING),
            text = priority.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview
@Composable
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.MEDIUM)
}