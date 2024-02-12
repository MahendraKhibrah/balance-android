package com.example.balanse.presentation.features.auth.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.balanse.common.theme.WhiteBalance
import com.example.balanse.common.theme.WhiteParagraph
import com.example.balanse.domain.models.auth.OnboardItem
import com.example.balanse.presentation.features.auth.viewModels.OnboardingViewModel
import com.example.balanse.presentation.navigation.AppRoute
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun OnboardPage(
    viewModel: OnboardingViewModel = hiltViewModel<OnboardingViewModel>(),
    navController: NavHostController,
    ) {
    val onboardItems = viewModel.getOnboardItems(LocalContext.current)
    val pagerState: PagerState = rememberPagerState(
        pageCount = fun(): Int {
            return onboardItems.count()
        },
        initialPage = 0,
    )

    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pagerState) {
                val onboardItem = onboardItems[it]
                OnboardItem(onboardItem = onboardItem, pagerState = pagerState, navController)
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Text(text = "Skip",
                style = WhiteParagraph, modifier = Modifier.padding(16.dp).clickable {
                    navController.navigate(AppRoute.LoginOrRegister.route)
                },
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                repeat(onboardItems.count()) {
                    val color =if (it == pagerState.currentPage) Color.White else Color.White.copy(alpha = 0.5f)
                    Row {
                        Box(modifier = Modifier.width(32.dp)) {}
                        Canvas(
                            modifier = Modifier
                                .size(16.dp)
                        ) {
                            if (it != pagerState.currentPage)
                            drawCircle(color = color, radius = 8.dp.toPx())
                            else {
                                drawCircle(color = color, radius = 8.dp.toPx(), center = Offset(size.width * 2, size.height / 2) )
                                drawRect(
                                    color = color,
                                    size = Size(32.dp.toPx(), 16.dp.toPx()),

                                )
                                drawCircle(color = color, radius = 8.dp.toPx(), center = Offset(size.width - size.width, size.height / 2) )

                            }

                        }
                        Box(modifier = Modifier.width(32.dp)) {}
                    }
                }
            }
            Box (Modifier.height(LocalConfiguration.current.screenWidthDp.dp / 8)){}
        }

    }
}

@Composable
fun OnboardItem(
    onboardItem: OnboardItem,
    pagerState: PagerState,
    navController: NavHostController,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = onboardItem.color),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val color = if (onboardItem.isDark) Color.White else Color.Black
        Image(
            painter = painterResource(id = onboardItem.image),
            contentDescription = null,
            Modifier
                .width(screenWidth * 2 / 3)
                .height(screenWidth * 4 / 5)
        )
        Text(text = onboardItem.title, style = WhiteBalance, color = color)
        Box(Modifier.height(16.dp))
        Text(text = onboardItem.description, style = WhiteParagraph, textAlign = TextAlign.Center, color= color)
        Box(Modifier.height(26.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(screenWidth / 3)
                .height(screenWidth / 3)
                .clickable {
                        scope.launch {
                            if (pagerState.currentPage < pagerState.pageCount - 1)
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            else
                                navController.navigate(AppRoute.LoginOrRegister.route)
                    }
                },

            ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(color = color, radius = (size.minDimension / 3), center = center)

                drawCircle(
                    color = color,
                    style = Stroke(width = 2.dp.toPx())
                )
            }
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowRight,
                contentDescription = "Arrow Forward",
                modifier = Modifier
                    .padding(16.dp)
                    .size(48.dp, 48.dp),
                tint = if(onboardItem.isDark) Color.Black else Color.White,

                )
        }
    }

}