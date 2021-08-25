package com.example.composedialogfragment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedialogfragment.ui.theme.ComposeDialogFragmentTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDialogFragmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainLayout(this::openDialog)
                }
            }
        }
    }

    fun openDialog() {
        MainDialogFragment().show(supportFragmentManager, "tag")
    }
}

@Composable
fun MainLayout(onOpenDialog: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var str by remember { mutableStateOf("") }
        TextField(value = str, onValueChange = { str = it } )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { onOpenDialog() }) {
            Text("Open Dialog")
        }
    }
}
