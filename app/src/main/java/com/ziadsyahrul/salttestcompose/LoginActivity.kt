package com.ziadsyahrul.salttestcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ziadsyahrul.salttestcompose.ui.theme.SaltComposeTestTheme
import com.ziadsyahrul.salttestcompose.utils.Resource
import com.ziadsyahrul.salttestcompose.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaltComposeTestTheme() {
                Login()
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalMaterialApi
@Composable
fun Login(viewModel: UserViewModel = hiltViewModel()) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Email",
            modifier = Modifier.padding(start = 5.dp),
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            singleLine = true
        )
        Text(
            text = "Password",
            modifier = Modifier.padding(start = 5.dp),
            textAlign = TextAlign.Start
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            scope.launch {
                val result = viewModel.loginUser(email, password)

                if (result is Resource.Error) {
                    Toast.makeText(context, "${result.message}", Toast.LENGTH_SHORT).show()
                    Log.d("Login", "${result.message}")
                } else if (result is Resource.Success) {
                    context.startActivity(Intent(context, MainActivity::class.java))
                    Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                }
            }

        }) {
            Text(text = "Login")
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SaltComposeTestTheme {
        Login()
    }
}