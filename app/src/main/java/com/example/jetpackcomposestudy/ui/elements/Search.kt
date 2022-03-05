package com.example.jetpackcomposestudy.ui.elements

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.ui.theme.Shapes

@Composable
fun Search() {
    var textValue by remember {
        mutableStateOf("")
    }
    val focusRequest = FocusRequester()
    val focusManager=LocalFocusManager.current
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            placeholder = {
                Text(text = "Search...")
            },
            shape = Shapes.large,
            modifier = Modifier
                .padding(end = 12.dp)
                .weight(10f)
                .focusRequester(focusRequester = focusRequest)
                .clickable {
                    focusRequest.requestFocus()
                }
                ,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(241, 241, 252, 255)
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.e("TAG", textValue)
                    focusManager.clearFocus()
                    //TODO(Trigger searching func from viewmodel)
                }
            )
        )

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search icon",
            modifier = Modifier
                .size(32.dp)
                .weight(1f)
                .clickable {
                    focusManager.clearFocus()
                    Log.e("TAG", textValue)
                    //TODO(Trigger searching func from viewmodel)
                },
        )

    }
}


@Composable
@Preview
fun SearchPreview() {
    Search()
}