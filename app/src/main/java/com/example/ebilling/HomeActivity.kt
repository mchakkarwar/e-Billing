package com.example.ebilling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.HomeScreen
import com.example.NavDrawer
import com.example.ebilling.ui.Screens
import com.example.ebilling.ui.theme.EBillingTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EBillingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val coroutineScope = rememberCoroutineScope()
                    val scaffoldState =
                        rememberScaffoldState(rememberDrawerState(DrawerValue.Closed));
                    val navigationMenuClicked = remember {
                        mutableStateOf(Screens.DashboardScreen().screenName)
                    }
                    navController.enableOnBackPressed(true)
                    val homeTitle = stringResource(id = R.string.home_screen)
                    val appBarTitle = remember { mutableStateOf(homeTitle) }
                    NavHost(
                        navController = navController,
                        startDestination = Screens.RegisterProductScreen().screenName
                    ) {
                        composable(Screens.DashboardScreen().screenName) {
                            navController.popBackStack()
                            appBarTitle.value = Screens.DashboardScreen().screenName
                        }
                        composable(Screens.RegisterProductScreen().screenName) {
                            navController.popBackStack()
                            appBarTitle.value = Screens.RegisterProductScreen().screenName
                        }
                        composable(Screens.SearchProductScreen().screenName) {
                            navController.popBackStack()
                            appBarTitle.value = Screens.SearchProductScreen().screenName
                        }
                        composable(Screens.DeleteProductScreen().screenName) {
                            navController.popBackStack()
                            appBarTitle.value = Screens.DeleteProductScreen().screenName
                        }
                        composable(Screens.EditProductScreen().screenName) {
                            navController.popBackStack()
                            appBarTitle.value = Screens.EditProductScreen().screenName
                        }
                    }
                    HomeScreen(
                        navController,
                        scaffoldState,
                        coroutineScope,
                        navigationMenuClicked,
                        appBarTitle
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun defaultPreview() {
    Column() {
        NavDrawer(
            arrayOf("Create", "Search", "Delete"),
            rememberScaffoldState(),
            rememberCoroutineScope(),
            remember {
                mutableStateOf("Home")
            },
            NavHostController(LocalContext.current)
        )
    }
}

@Composable
fun mainContent(menuName: String) {
    Text(text = menuName)
}