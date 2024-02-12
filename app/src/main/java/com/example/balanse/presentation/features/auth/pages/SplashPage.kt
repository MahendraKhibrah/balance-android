package com.example.balanse.presentation.features.auth.pages

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.balanse.R
import com.example.balanse.common.theme.*
import com.example.balanse.presentation.features.auth.viewModels.SplashViewModel
import com.example.balanse.presentation.navigation.AppRoute
import kotlinx.coroutines.delay


@Composable
fun SplashPage(
    navController: NavHostController,
    viewModel : SplashViewModel = hiltViewModel<SplashViewModel>()
    ) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val firstOpenAppState = viewModel.firstLoginStatusState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true ){
        viewModel.getFirstLoginStatus()
    }

    LaunchedEffect(key1 = firstOpenAppState.value){
        val isFirstOpenApp = firstOpenAppState.value.isFirstLogin
        if (isFirstOpenApp != null){
            delay(2000L)
            if (isFirstOpenApp){
                navController.navigate(AppRoute.Onboard.route)
            } else {
                navController.navigate(AppRoute.LoginOrRegister.route)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = BlackPrimary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_logo), contentDescription = null,
                modifier = Modifier.size(
                    width = (screenWidth * 2 / 3), height = screenWidth
                ),
            )
            Text(text = "Balanse", style = WhiteTitle, fontSize = 36.sp)
        }
        Canvas(modifier = Modifier.matchParentSize()) {
            drawCircle(color = YellowPrimary, radius = size.minDimension / 4, center = Offset(0f, 0f))
            drawCircle(color = YellowPrimary, radius = size.minDimension / 4, center = Offset(size.width, size.height))
        }
    }
}