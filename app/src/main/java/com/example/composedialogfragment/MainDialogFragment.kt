package com.example.composedialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import com.example.composedialogfragment.ui.theme.ComposeDialogFragmentTheme

class MainDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        val view = ComposeView(requireContext()).apply {
            setContent {
                ComposeDialogFragmentTheme {
                    Layout()
                }
            }
        }
        return AlertDialog.Builder(activity)
            .setView(view)
            .setCancelable(false)
            .create().apply {
                setCanceledOnTouchOutside(false)
            }
    }

    @Composable
    fun Layout() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            var str by remember { mutableStateOf("") }
            TextField(value = str, onValueChange = { str = it } )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {dismiss()}) {
                Text("Close")
            }
        }
    }
}
