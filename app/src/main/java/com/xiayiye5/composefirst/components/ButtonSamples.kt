package com.xiayiye5.composefirst.components

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
 * 创建时间：2022/5/1 18:13
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Button和ButtonText按钮的基本用法
 */
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonSamples() {
    //如果同时设置modifier点击事件，此时只会走button的点击事件1，不会走modifier的点击事件2
    Row(
        //设置子控件居中显示
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        //设置外层父布局充满宽度
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { Log.d("ButtonSamples", "点击了我1") },
            Modifier.clickable { Log.d("ButtonSamples", "点击了我2") },
            //设置button的背景色，内容色就是文本颜色
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(120, 135, 213),
                contentColor = Color.Red
            )
        ) {
            //如果设置了按钮的内容色，又在下面Text中设置了文字颜色，下面的颜色会覆盖按钮的内容色contentColor
            Text(text = "点击了才算是兄弟！", color = Color.White)
        }
        TextButton(onClick = { Log.d("ButtonSamples", "点击了纯文本按钮") }) {
            Text(text = "纯文本按钮不带边框")
        }
    }
}

@Preview
@Composable
fun ButtonSamplesPreview() {
    ButtonSamples()
}

