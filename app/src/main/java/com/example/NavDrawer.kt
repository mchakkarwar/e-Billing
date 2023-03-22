package com.example

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ebilling.showToastMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalUnitApi::class)
@Composable
fun NavDrawer(
    menus: Array<String>,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navigationMenuClicked: MutableState<String>,
    navHostController: NavHostController
) {
    menus.iterator().forEach { menuString ->
        val localContext = LocalContext.current
        ClickableText(
            AnnotatedString(menuString),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            style = TextStyle(
                fontSize = TextUnit(20f, TextUnitType.Sp)
            ),
            onClick = {
                showToastMessage(localContext, menuString)
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                    navigationMenuClicked.value = menuString

                    navHostController.navigate(menuString) {
                    }
                }
            })
        Divider()
    }
}
