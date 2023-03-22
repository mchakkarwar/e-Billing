package com.example

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ebilling.ui.theme.EBillingTheme

@Composable
fun HomeScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val navigationMenuClicked = remember {
        mutableStateOf("Home")
    }
    EBillingTheme {
        Scaffold(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(), topBar = {
                TopAppBar(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {

                }
            }, scaffoldState = scaffoldState, drawerContent = {
                Text(
                    stringResource(id = R.string.navigation_menu),
                    modifier = Modifier.padding(25.dp)
                )
                Divider()
                NavDrawer(
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