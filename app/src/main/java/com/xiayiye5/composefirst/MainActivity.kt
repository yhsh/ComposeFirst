package com.xiayiye5.composefirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xiayiye5.composefirst.components.*
import com.xiayiye5.composefirst.ui.theme.ComposeFirstTheme

/**
 * @author xiayiye5
 * 此项目为compose基本学习项目，都是基础控件内容
 */
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
    //添加列表滚动属性
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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
        RowSamples()
        SpacerSamples()
        DividerSamples()
        RadioButtonSamples()
        CheckBoxSamples()
        ListItemSamples()
        LazyColumnSamples()
//        LazyVerticalGridSamples()
        ConstraintLayoutSamples()
        ConstraintLayout2Samples()
        TabRowSamples()
        DropDownMenuSamples()
        SurfaceSamples()
        ScaffoldTopBarSamples()
        ScaffoldBottomBarSamples()
        ScaffoldMenuSamples()
        BackDropScaffoldSamples()
        BottomSheetScaffoldSamples()
        DialogSamples()
        AlertDialogSamples()
        ComposeViewSamples()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeFirstTheme {
        Greeting("Android")
    }
}