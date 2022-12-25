package com.example.composenavigation


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreenPage(
    navController: NavHostController
){
    var inputEntered by rememberSaveable{
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp)

        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
            ){
                Text(
                    text = "Enter Your name",
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = TextStyle.Default.copy(fontSize = 20.sp).fontSize
                )
                OutlinedTextField(
                    value = inputEntered,
                    onValueChange = {
                        if(it.length<=10)
                            inputEntered = it
                    },
                    Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    singleLine = true,
                    label = {
                        Text(
                            text = "Name"
                        )
                    },
                    textStyle = TextStyle.Default.copy(fontSize = 20.sp)

                )
                Button(
                    onClick = {
                              navController.navigate(Screen.Final.route.replace(oldValue = "{name}", newValue = inputEntered))
                    },
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "NEXT",
                        fontSize = TextStyle.Default.copy(fontSize = 20.sp).fontSize
                    )
                }
            }
        }
    }
}