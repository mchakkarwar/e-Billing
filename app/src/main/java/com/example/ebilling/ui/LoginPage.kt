package com.example.ebilling.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ebilling.R

@Preview(showBackground = true)
@Composable
fun login(onLoginClicked: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.wrapContentWidth()) {
            Text(
                text = stringResource(id = R.string.enter_username),
                modifier = Modifier.wrapContentWidth()
            )
            val username = remember {
                mutableStateOf("")
            }
            TextField(value = username.value, onValueChange = {
                username.value = it
            })
            Spacer(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(8.dp)
            )
            Text(text = stringResource(id = R.string.enter_password))
            val password = remember {
                mutableStateOf("")
            }
            TextField(value = password.value, onValueChange = {
                password.value = it
            })
            Spacer(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(16.dp)
            )
            Button(enabled = username.value.isNotEmpty() && password.value.isNotEmpty(), onClick = {
                onLoginClicked()
            }) {
                Text(text = stringResource(id = R.string.login))
            }
            Text(text = stringResource(id = R.string.not_registered_signup))
        }
    }
}