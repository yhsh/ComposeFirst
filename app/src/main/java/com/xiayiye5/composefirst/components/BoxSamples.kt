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
 * 创建时间：2022/5/2 14:58
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Box布局容器控件基本用法
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxSamples() {
    Box(
        //设置子布局在布局中中居中显示
        contentAlignment = Alignment.Center
    ) {
        /*Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Blue)
        ) {

        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                //设置子布局整体在父布局中居中显示
                .align(Alignment.Center)
        )*/
        BoxWithConstraints(contentAlignment = Alignment.Center) {
            if (maxHeight > maxWidth) {
                Text(
                    text = "父布局",
                    Modifier
                        .size(100.dp)
                        .background(Color.Blue),
                    color = Color.Red,
                    //设置文本居中显示
                    textAlign = TextAlign.Center
                )
            } else {
                Text(
                    text = "子布局",
                    Modifier
                        .size(50.dp)
                        .background(Color.Yellow),
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}

@Preview
@Composable
fun BoxSamplesPreview() {
    BoxSamples()
}

