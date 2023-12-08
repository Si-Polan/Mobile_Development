package com.gatenzteam.sipolan.ui.activity.verification

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.MailLock
import androidx.compose.material.icons.filled.MarkEmailUnread
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gatenzteam.sipolan.MainActivity
import com.gatenzteam.sipolan.R
import com.gatenzteam.sipolan.ui.component.CustomIconButton
import com.gatenzteam.sipolan.ui.component.CustomTextField
import com.gatenzteam.sipolan.ui.font.Poppins

class VerificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerificationScreen()
        }
    }

    @Composable
    fun VerificationScreen(
        modifier: Modifier = Modifier
    ) {
        var otpCode by rememberSaveable { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = colorResource(R.color.color_palette1))
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 25.dp, vertical = 30.dp)
        ){
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "Verify your Account",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = Poppins.poppinsFamily,
                        fontWeight = FontWeight(700),
                        color = colorResource(R.color.color_palette3),
                        textAlign = TextAlign.Start,
                    ),
                    modifier = modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod et dolore magna aliqua.",
                    style = TextStyle(
                        fontSize = 14.83.sp,
                        fontFamily = Poppins.poppinsFamily,
                        fontWeight = FontWeight(400),
                        color = colorResource(R.color.color_palette4),
                        textAlign = TextAlign.Start,
                    ),
                    modifier = modifier
                        .padding(bottom = 15.dp)
                )
            }

            Box(
                modifier = modifier
                    .height(320.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .height(240.dp)
                        .align(Alignment.BottomCenter)
                        .background(
                            color = colorResource(id = R.color.color_palette3),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(horizontal = 25.dp)
                ){
                    Text(
                        text = "Kami mengirimkan kode OTP ke Email anda",
                        style = TextStyle(
                            fontSize = 14.83.sp,
                            fontFamily = Poppins.poppinsFamily,
                            fontWeight = FontWeight(600),
                            color = colorResource(R.color.color_palette1),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = modifier
                            .padding(top = 80.dp, bottom = 10.dp)
                    )

                    CustomTextField(
                        value = otpCode,
                        onValueChange = { otpCode = it },
                        label = "Kode OTP",
                        labelColor = colorResource(id = R.color.color_palette1),
                        singleLine = true,
                        placeholder = "Masukan Kode OTP",
                        placeholderColor = colorResource(id = R.color.color_palette1),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.MailLock,
                                contentDescription = null,
                                tint = colorResource(R.color.color_palette1)
                            )
                        },
                        color = OutlinedTextFieldDefaults.colors(
                            cursorColor = colorResource(id = R.color.color_palette1),
                            focusedLabelColor = colorResource(id = R.color.color_palette1),
                            unfocusedLabelColor = colorResource(id = R.color.color_palette1),
                            focusedTextColor = colorResource(id = R.color.color_palette1),
                            focusedBorderColor = colorResource(id = R.color.color_palette2),
                            unfocusedBorderColor = colorResource(id = R.color.color_palette2)
                        )
                    )

                }
                Image(
                    painter = painterResource(id = R.drawable.logo_verification),
                    contentDescription = null,
                    modifier = modifier
                        .size(150.dp)
                        .align(Alignment.TopCenter)
                )
            }

            Text(
                text = "Belum menerima Email OTP?",
                style = TextStyle(
                    fontSize = 14.83.sp,
                    fontFamily = Poppins.poppinsFamily,
                    fontWeight = FontWeight(400),
                    color = colorResource(R.color.color_palette4),
                    textAlign = TextAlign.Center,
                ),
                modifier = modifier
                    .padding(vertical = 20.dp)
            )

            CustomIconButton(
                onClick = {
                    startActivity(Intent(this@VerificationActivity, MainActivity::class.java))
                    finish()
                },
                icon = Icons.Filled.MarkEmailUnread,
                text = "Kirim Ulang",
                modifier = modifier
                    .width(190.dp)
            )
        }
    }
}