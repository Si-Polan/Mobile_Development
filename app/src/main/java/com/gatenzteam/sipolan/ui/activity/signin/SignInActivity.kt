package com.gatenzteam.sipolan.ui.activity.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.activity.forgot.ForgotActivity
import com.gatenzteam.sipolan.ui.activity.signup.SignUpActivity
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomText
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins
import com.gatenzteam.sipolan.ui.theme.ColorPalette1
import com.gatenzteam.sipolan.ui.theme.ColorPalette3
import com.gatenzteam.sipolan.ui.theme.ColorPalette4
import com.gatenzteam.sipolan.ui.theme.SiPolanTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreen()
        }
    }

    @Composable
    private fun SignInScreen(
        modifier: Modifier = Modifier
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var visibilityPassword by rememberSaveable { mutableStateOf(false) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = ColorPalette1)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 30.dp)
        ){
            CustomText(
                text = stringResource(id = R.string.signin_title),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight(700),
                    color = ColorPalette3,
                    )
            )
            CustomText(
                text = stringResource(id = R.string.signin_subtitle),
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontWeight = FontWeight(400),
                    color = ColorPalette4,
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .padding(bottom = 25.dp)
            )
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = stringResource(id = R.string.signin_input_email),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = ColorPalette3
                    )
                },
                singleLine = true,
                modifier = modifier.padding(bottom = 15.dp)
            )

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = stringResource(id = R.string.signin_input_pass),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = ColorPalette3
                    )
                },
                trailingIcon = {
                    val icon = if (visibilityPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    val tintIcon = if (visibilityPassword) ColorPalette3 else ColorPalette4

                    IconButton(onClick = {visibilityPassword = !visibilityPassword}){
                        Icon(
                            imageVector  = icon,
                            contentDescription = null,
                            tint = tintIcon
                        )
                    }
                },
                visualTransformation = if (visibilityPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                modifier = modifier.padding(bottom = 15.dp)
            )
            Text(
                text = stringResource(id = R.string.signin_forgot),
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(700),
                    color = ColorPalette3,
                ),
                modifier = modifier
                    .padding(top = 15.dp, bottom = 30.dp)
                    .clickable {
                        startActivity(Intent(this@SignInActivity, ForgotActivity::class.java))
                    }
            )

            CustomIconButton(
                onClick = {
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    finish()
                },
                icon = Icons.Filled.Login,
                text = stringResource(id = R.string.signin_button)
            )


            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .padding(vertical = 30.dp)
            ){
                Divider(
                    color = ColorPalette4,
                )
                CustomText(
                    style = TextStyle(
                        background = ColorPalette1,
                        color = ColorPalette4,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    ),
                    text = stringResource(id = R.string.signin_divider),
                    modifier = modifier
                        .width(150.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                val context = LocalContext.current
                Button(
                    onClick = {
                        Toast.makeText( context, R.string.login_fb, Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(ColorPalette3),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(90.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = null,
                        tint = ColorPalette1,
                        modifier = modifier
                            .size(25.dp)
                    )
                }

                Button(
                    onClick = {
                        Toast.makeText( context, R.string.login_google, Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(ColorPalette3),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(50.dp)
                        .width(90.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = null,
                        tint = ColorPalette1,
                        modifier = modifier
                            .size(22.dp)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(vertical = 15.dp)
            ){
                CustomText(
                    style = TextStyle(
                        background = ColorPalette1,
                        color = ColorPalette4,
                        fontSize = 12.sp
                    ),
                    text = stringResource(id = R.string.signin_no_account)
                )
                CustomText(
                    style = TextStyle(
                        background = ColorPalette1,
                        color = ColorPalette3,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700)
                    ),
                    text = stringResource(id = R.string.signin_signup),
                    modifier = modifier
                        .clickable {
                            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
                        }
                )
            }
        }
    }

    @Preview
    @Composable
    fun SignInScreenPreview() {
        SiPolanTheme {
            SignInScreen()
        }
    }
}