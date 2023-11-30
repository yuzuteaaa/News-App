package com.example.splashscreen.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.splashscreen.presentation.onboarding.components.OnBoardingPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0){
            pages.size
        }

        val buttonState = remember{
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("","Next")
                    1 -> listOf("Next","Next")
                    2 -> listOf("Next","Lets Started")
                    else -> listOf("","")
                }
            }
        }
        HorizontalPager(pageCount = 0,state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
    }
}
