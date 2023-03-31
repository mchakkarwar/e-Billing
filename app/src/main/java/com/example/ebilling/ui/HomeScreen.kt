package com.example

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.NavHostController
import com.example.ebilling.ui.Dashboard
import com.example.ebilling.ui.DeleteProduct
import com.example.ebilling.ui.EditProduct
import com.example.ebilling.ui.RegisterProduct
import com.example.ebilling.ui.Screens
import com.example.ebilling.ui.SearchProduct
import com.example.ebilling.ui.theme.EBillingTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("PrivateResource")
@Composable
fun HomeScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navigationMenuClicked: MutableState<String>,
    appBarTitle: State<String>

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
                            text = appBarTitle.value
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
                Divider()
                NavigationDrawer(
                    stringArrayResource(id = com.example.ebilling.R.array.drawer_items),
                    scaffoldState,
                    coroutineScope,
                    navigationMenuClicked,
                    navController
                )

            }) {
            Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(it))
            when(navigationMenuClicked.value){
                Screens.DashboardScreen().screenName -> Dashboard()
                Screens.RegisterProductScreen().screenName -> RegisterProduct()
                Screens.EditProductScreen().screenName -> EditProduct()
                Screens.DeleteProductScreen().screenName -> DeleteProduct()
                Screens.SearchProductScreen().screenName -> SearchProduct()
            }
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