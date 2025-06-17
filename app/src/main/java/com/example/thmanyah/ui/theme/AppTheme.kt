package com.example.thmanyah.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object AppTheme {
    private val LocalSpaces = staticCompositionLocalOf { Spaces() }
    private val LocalRadius = staticCompositionLocalOf { Radius() }
    private val LocalColors = staticCompositionLocalOf { Radius() }

    val radius
        @ReadOnlyComposable
        @Composable
        get() = LocalRadius.current

    val spaces
        @ReadOnlyComposable
        @Composable
        get() = LocalSpaces.current

    val typography
        @ReadOnlyComposable
        @Composable
        get() = MaterialTheme.typography

    val colors
        @ReadOnlyComposable
        @Composable
        get() = LocalColors.current

}