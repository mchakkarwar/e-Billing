package com.example

import android.view.View
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ebilling.ui.theme.EBillingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navigationMenuClicked: MutableState<String>
) {
    EBillingTheme {
        Scaffold(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = com.example.ebilling.R.string.home_screen),
                            modifier = Modifier.padding(25.dp),
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                               scaffoldState.drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    }
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                Text(
                    stringResource(id = androidx.compose.ui.R.string.navigation_menu),
                    modifier = Modifier.padding(25.dp)
                )
                Divider()
                NavigationDrawer(
                    stringArrayResource(id = com.example.ebilling.R.array.drawer_items),
                    scaffoldState,
                    coroutineScope,
                    navigationMenuClicked,
                    navController
                )

            }) {
            Text(text = navigationMenuClicked.value, Modifier.padding(it))
        }
    }
}

@Composable
fun NavigationDrawer(
    drawerItems: Array<String>,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navigationMenuClicked: MutableState<String>,
    navController: NavHostController
) {
    NavDrawer(
        drawerItems,
        scaffoldState,
        coroutineScope,
        navigationMenuClicked,
        navController
    )
}