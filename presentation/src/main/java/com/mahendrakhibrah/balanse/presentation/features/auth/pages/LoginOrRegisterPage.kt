package com.mahendrakhibrah.balanse.presentation.features.auth.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahendrakhibrah.balanse.common.theme.BlackPrimary
import com.mahendrakhibrah.balanse.common.R
import com.mahendrakhibrah.balanse.common.buttons.ButtonPrimary
import com.mahendrakhibrah.balanse.common.buttons.CustomOutlinedButton
import com.mahendrakhibrah.balanse.common.theme.WhiteParagraph
import com.mahendrakhibrah.balanse.common.theme.WhiteTitle

@Preview(showBackground = true)
@Composable
fun LoginOrRegisterPage() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BlackPrimary)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.secondary_logo),
            contentDescription = "",
            modifier = Modifier.size(width = (screenWidth), height = screenWidth * 6 / 5)
        )
        Text(
            text = stringResource(id = R.string.welcome),
            style = WhiteTitle,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.login_or_register_description),
            style = WhiteParagraph,
            textAlign = TextAlign.Center
        )
        Box(modifier = Modifier.size(16.dp))
        Row {
            ButtonPrimary(text = "LOGIN", onClick = { /*TODO*/ })
            Box(modifier = Modifier.size(16.dp))
            CustomOutlinedButton(text = "REGISTER", onClick = { /*TODO*/ })
        }
    }
}