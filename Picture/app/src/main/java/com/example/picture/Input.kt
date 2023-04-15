package com.example.picture

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.Picture.R

@Composable
fun User_Input(navController: NavController){
    var heightValue by remember { mutableStateOf("") }
    var widthValue by remember { mutableStateOf("") }
    var categoryValue by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(36.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        Text(
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
        )

        Spacer(modifier = Modifier.height(30.dp))

        HeightGrid(
            value = heightValue,
            onValueChange = { heightValue = it })

        Spacer(modifier = Modifier.height(10.dp))

        WidthGrid(value = widthValue,
            onValueChange = { widthValue = it })

        Spacer(modifier = Modifier.height(30.dp))


        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "kitten"},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.cat),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "dog"},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.dog),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "bunny"},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.bunny),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "books"},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.books),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "cars"},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.cars),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "flowers"},
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.flowers),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = { navController.navigate("Show Image/$widthValue/$heightValue/$categoryValue") },
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.view),
                fontSize = 18.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}
