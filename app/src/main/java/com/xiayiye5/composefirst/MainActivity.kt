package com.xiayiye5.composefirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xiayiye5.composefirst.components.*
import com.xiayiye5.composefirst.ui.theme.ComposeFirstTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFirstTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello $name!")
        TextSamples()
        ClickAbleTextSamples()
        ModifierSamples()
        ButtonSamples()
        IconSamples()
        ImageSamples()
        StateSamples()
        SwitchSamples()
        TextFiledSamples()
		ProgressIndicatorSamples()
        SliderSamples()
        CardSamples()
        BoxSamples()
        ColumnSamples()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFirstTheme {
        Greeting("Android")
    }
}