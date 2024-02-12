package com.example.balanse.common.widgets.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.balanse.common.theme.BlackPrimary
import com.example.balanse.common.theme.YellowPrimary

@Composable
fun ButtonPrimary(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = YellowPrimary),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.width(120.dp)
    ) {
        Text(
            text = text,
            color = BlackPrimary
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPrimaryPreview(
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = YellowPrimary),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.width(200.dp)
    ) {
        Text(
            text = "testing button",
            color = BlackPrimary
        )
    }
}