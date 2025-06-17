package com.example.thmanyah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.thmanyah.presentation.features.HomeRoutes
import com.example.thmanyah.presentation.features.home.ui.HomeSectionScreen
import com.example.thmanyah.ui.theme.ThmanyahTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ThmanyahTaskTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
                    NavigationHost(navController, innerPadding)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val selectTab = remember { mutableStateOf<HomeRoutes>(HomeRoutes.Home) }
    val items = listOf(HomeRoutes.Home, HomeRoutes.Search)
    NavigationBar {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                label = { Text(screen.title) },
                selected = screen == selectTab.value,
                onClick = {
                    selectTab.value = screen
                    navController.navigate(screen.route)
                },
                icon = {
                    Icon(
                        if (index == 0)
                            Icons.Default.Home else
                            Icons.Default.Search,
                        contentDescription = screen.title
                    )
                }
            )
        }
    }
}