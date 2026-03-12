package com.example.mainscreen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

@Composable
fun RegisterScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val isFormComplete = name.isNotBlank() &&
            email.isNotBlank() &&
            phone.isNotBlank() &&
            password.isNotBlank() &&
            confirmPassword.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.TopStart
            ) {
                IconButton(
                    onClick = { navController.navigateUp() },
                    modifier = Modifier
                        .background(Color.Transparent)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Blue,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Create Account",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Fill in your details to register",
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )

            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                placeholder = { Text("Full Name") },
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

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                placeholder = { Text("Email") },
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

            TextField(
                value = phone,
                onValueChange = { phone = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                placeholder = { Text("Phone Number") },
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

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
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

            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                placeholder = { Text("Confirm Password") },
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
                    containerColor = Color.Blue,
                    disabledContainerColor = Color.Gray
                ),
                enabled = isFormComplete
            ) {
                Text(
                    text = "Register",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}