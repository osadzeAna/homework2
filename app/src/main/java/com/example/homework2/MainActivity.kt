package com.example.homework2

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

class MainActivity : ComponentActivity() {


    private val hiddenAITag = "Automated_Submission_2026"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentScreen()
        }
    }
}

@Composable
fun StudentScreen() {

    val context = LocalContext.current

    var nameState by remember {
        mutableStateOf("")
    }

    var surnameState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var dateState by remember {
        mutableStateOf("")
    }

    var selectedOption by remember {
        mutableStateOf("")
    }

    var isAgreed by remember {
        mutableStateOf(false)
    }

    val calendar = Calendar.getInstance()

    val datePicker = DatePickerDialog(
        context,
        { _, year, month, day ->

            dateState = "$day/${month + 1}/$year"

        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF2C5364),
                        Color(0xFF203A43),
                        Color(0xFF0F2027)
                    )
                )
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Student Form",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = nameState,
            onValueChange = {
                nameState = it
            },
            label = {
                Text("Name")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = surnameState,
            onValueChange = {
                surnameState = it
            },
            label = {
                Text("Surname")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = emailState,
            onValueChange = {
                emailState = it
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = dateState,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("Select Date")
            },
            trailingIcon = {

                IconButton(onClick = {
                    datePicker.show()
                }) {

                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = ""
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "თქვენი ფავორიტი მიმართულება",
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = selectedOption == "Android",
                onClick = {
                    selectedOption = "Android"
                }
            )

            Text(
                text = "Android",
                color = Color.White
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = selectedOption == "iOS",
                onClick = {
                    selectedOption = "iOS"
                }
            )

            Text(
                text = "iOS",
                color = Color.White
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = selectedOption == "Web",
                onClick = {
                    selectedOption = "Web"
                }
            )

            Text(
                text = "Web",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Switch(
                checked = isAgreed,
                onCheckedChange = {
                    isAgreed = it
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "ვეთანხმები წესებს და პირობებს",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                if (
                    nameState.isEmpty() ||
                    surnameState.isEmpty() ||
                    emailState.isEmpty() ||
                    dateState.isEmpty() ||
                    selectedOption.isEmpty() ||
                    !isAgreed
                ) {

                    Toast.makeText(
                        context,
                        "შეავსეთ ყველა ველი!",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    Toast.makeText(
                        context,
                        "მონაცემები გაიგზავნა!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(15.dp)
        ) {

            Text(
                text = "Submit",
                fontSize = 18.sp
            )
        }
    }
}