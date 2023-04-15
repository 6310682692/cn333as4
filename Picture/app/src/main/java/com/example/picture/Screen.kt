package com.example.picture

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.Picture.R

@Composable
fun HeightGrid(value: String,
              onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.height),
            fontSize = 16.sp) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus()})

    )
}

@Composable
fun WidthGrid(value: String,
             onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.width),
            fontSize = 16.sp) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus()})
    )
}

@Composable
fun User_View(navController: NavController,
                width : String,
                height: String,
                category: String){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(36.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        Text(
            text = stringResource(R.string.Pict),
            textAlign = TextAlign.Center,
            fontSize = 27.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Spacer(modifier = Modifier.height(20.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://loremflickr.com/$width/$height/$category")
                .crossfade(true)
                .build(),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.home),
                fontSize = 18.sp,
            )
        }
    }
}
