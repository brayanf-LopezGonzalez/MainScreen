package com.example.mainscreen.screens

import android.provider.ContactsContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    navController: NavController
) {

    /* estados */
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember {mutableStateOf(false)}

    var title by remember { mutableStateOf("Hello!") }

    fun isValidEmail (email: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Button(
                    onClick = {
                        navController.navigateUp()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Blue
                    )
                ) {
                    Text(
                        text = "← Back",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(150.dp))

            Text(
                text =  title /*"Hello!"*/,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Sign in",
                fontSize = 35.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )

            TextField(
                value = email,
                onValueChange = { email = it
                                emailError = !isValidEmail(email = it)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                placeholder = { Text("Email") },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                isError = emailError,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Blue

                )
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                placeholder = { Text("Password") },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Blue
                )

            )

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}