package br.com.devjmcn.myfinanceapp.ui.composes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WaveBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val wavePath = Path().apply {
            moveTo(1440f, 0f)
            lineTo(1440f, 450f)
            cubicTo(1340.699f, 501.761f, 1241.397f, 553.522f, 1163f, 517f)
            cubicTo(1084.603f, 480.478f, 1027.11f, 355.675f, 918f, 306f)
            cubicTo(808.89f, 256.325f, 648.163f, 281.78f, 540f, 296f)
            cubicTo(431.837f, 310.22f, 376.239f, 313.206f, 295f, 287f)
            cubicTo(213.761f, 260.794f, 106.88f, 205.397f, 0f, 150f)
            lineTo(0f, 0f)
            lineTo(1440f, 0f)
            close()
        }


        drawPath(
            path = wavePath,
            color = Color(0xFF445e91),
            style = Fill
        )
    }
}

@Preview
@Composable
fun WaveBackgroundPreview() {
    WaveBackground(modifier = Modifier.fillMaxSize())
}

