package com.example.balanse.common.widgets.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {

    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(
            width = 2.dp,
            color = color
        ),
        modifier = modifier.width(120.dp),
        colors = outlinedButtonColors(
            contentColor = color,
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(text = text)
    }
}