package com.xiayiye5.composefirst.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.xiayiye5.composefirst.R

@Composable
fun TextSamples() {
    Text(
        //设置文本颜色
        text = stringResource(R.string.text_samples), color = Color(123, 145, 213),
        //设置中划线和下划线都有
        textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        ),
        //设置文字居左
        textAlign = TextAlign.Left,
        //设置宽度为最大宽度充满父布局
        modifier = Modifier.fillMaxWidth(),
        //设置文字大小,下面2个方法都可以
//        fontSize = TextUnit(18f, TextUnitType.Sp)
        fontSize = 20.sp,
        //设置字体
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        //设置文字间距
        letterSpacing = 10.sp,
        //设置省略号
        overflow = TextOverflow.Ellipsis,
//        lineHeight = 65.sp,
        //设置最大显示一行
        maxLines = 1
    )
}

@Preview
@Composable
fun TextSamplesPreview() {
    TextSamples()
}