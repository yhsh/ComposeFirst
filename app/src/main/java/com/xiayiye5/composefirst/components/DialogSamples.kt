package com.xiayiye5.composefirst.components

/*
 * Copyright (c) 2022, 13343401268@163.com All Rights Reserved.
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
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2022/5/10 20:25
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Dialog基本用法-可以自己定义布局
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogSamples() {
    var show by remember {
        mutableStateOf(false)
    }
    Divider(thickness = 1.dp, color = Color.Red)
    Box(Modifier.fillMaxWidth()) {
        Button(onClick = {
            //显示弹框
            show = true
        }, Modifier.fillMaxWidth()) {
            Text(text = "点击弹框")
            if (show) {
                Dialog(onDismissRequest = { show = false }) {
                    Column(
                        Modifier
                            .size(250.dp, 100.dp)
                            .background(color = Color.Red),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "确认进行此任务吗？", Modifier.padding(0.dp, 30.dp, 0.dp, 0.dp))
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            //间隔相等
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            //设置在底部
                            verticalAlignment = Alignment.Bottom
                        ) {
                            //两个按钮
                            Button(
                                onClick = { show = false },
                                Modifier
                                    .width(100.dp)
                                    .padding(0.dp, 0.dp, 0.dp, 7.dp)
//                                    .weight(1f)
                            ) {
                                Text(text = "确认")
                            }
                            Button(
                                onClick = { show = false },
                                Modifier
                                    .width(100.dp)
                                    .padding(0.dp, 0.dp, 0.dp, 7.dp)
//                                    .weight(1f)
                            ) {
                                Text(text = "取消")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DialogSamplesPreview() {
    DialogSamples()
}

