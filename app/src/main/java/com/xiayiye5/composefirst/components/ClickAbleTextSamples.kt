package com.xiayiye5.composefirst.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.xiayiye5.composefirst.R

/*
 * Copyright (c) 2022, smuyyh@gmail.com All Rights Reserved.
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG            #
 * #                                                   #
 */

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2022/5/1 11:47
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Text的高级用法
 */
const val TAG = "ClickAbleTextSamples"

@Composable
fun ClickAbleTextSamples() {
    val annotatedString = buildAnnotatedString {
        append(stringResource(id = R.string.text_weight))
        pushStringAnnotation("yhsh", "http://www.baidu.com")
        withStyle(
            SpanStyle(
                color = Color(255, 54, 102),
                textDecoration = TextDecoration.LineThrough
            )
        ) {
            append("《扬宏豕协议》")
        }
        pop()
        append("和")
        pushStringAnnotation("xiayiye5", "http://www.sougou.com")
        withStyle(
            SpanStyle(
                Color(255, 100, 100),
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("《下一页5隐私》")
        }
        pop()
        append("后表示同意协议")
    }
    ClickableText(style = TextStyle(fontSize = 24.sp),
        modifier = Modifier.fillMaxWidth(),
        text = annotatedString, onClick = { position ->
            //通过下面的tag标识找到对应的位置
            annotatedString.getStringAnnotations("yhsh", start = position, end = position)
                .firstOrNull()?.let { annotation ->
                    Log.d(TAG, "点到我了，位置是：${annotation.item}")
                }
//            if (position in 12..19) {
//                Log.d(TAG, "点到我了，位置是：$position")
//            }
            annotatedString.getStringAnnotations("xiayiye5", start = position, end = position)
                .firstOrNull()?.let { xiayiye5 ->
                    Log.d(TAG, "点到我了，位置是：${xiayiye5.item}")
                }
        })
}

@Preview
@Composable
fun ClickAbleTextSamplesPreview() {
    ClickAbleTextSamples()
}