package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.thmanyah.R
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black
import androidx.compose.runtime.*
import com.airbnb.lottie.compose.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clipToBounds

@Composable
fun ErrorFullScreen(
    modifier: Modifier = Modifier,
    title: String,
    message: String? = null,
    retry: String = stringResource(R.string.retry_text),
    retryAction: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .padding(AppTheme.spaces.spaceL)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error_animation))
        val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

        Box(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
                .clipToBounds()
        )  {
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier =  Modifier.fillMaxSize()
                    .align(Alignment.Center)

            )
        }

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.spaces.spaceXs)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        message?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = AppTheme.spaces.spaceXs)
                    .align(Alignment.CenterHorizontally),
                text = it,
                textAlign = TextAlign.Center,
                color = Black
            )
        }
        retryAction?.let {
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                content = { Text(text = retry) },
                onClick = {
                    retryAction()
                })
        }
    }
}

@Preview
@Composable
fun ErrorFullScreenPreview() {

    ErrorFullScreen(
        title = "Something went wrong",
        retryAction = {}
    )

}