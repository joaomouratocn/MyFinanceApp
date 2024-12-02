package br.com.devjmcn.myfinanceapp.ui.composes

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devjmcn.myfinanceapp.R

@Composable
fun Dialog(
    onDismissRequest: (() -> Unit)?,
    confirmText:String,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
    iconColor:Color = Color.Unspecified,
    iconContentDescription:String
) {
    AlertDialog(
        icon = {
            Icon(
                icon,
                tint = iconColor,
                contentDescription = iconContentDescription,
                modifier = Modifier.size(48.dp)
            )
        },
        title = {
            if(dialogTitle != ""){
                Text(text = dialogTitle)
            }
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = { //chamdo assim que o dialog é encerrado
            if (onDismissRequest != null) {
                onDismissRequest()
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(confirmText)
            }
        },
        dismissButton = {
            if (onDismissRequest != null){
                TextButton(
                    onClick = {
                        onDismissRequest()
                    }
                ) {
                    Text(stringResource(R.string.str_cancel))
                }
            }
        }
    )
}

@Preview
@Composable
private fun DialogPreview() {
    MaterialTheme {
        Dialog(
            onDismissRequest = {},
            confirmText = "OK",
            onConfirmation = {},
            dialogText = "Dialog Text",
            dialogTitle = "Title Dialog",
            icon = Icons.Default.Android,
            iconContentDescription = "Image content description"
        )
    }
}
