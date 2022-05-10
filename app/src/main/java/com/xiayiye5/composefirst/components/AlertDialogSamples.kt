package com.xiayiye5.composefirst.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

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
 * 创建时间：2022/5/10 21:14
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：AlertDialog弹框的基本用法-系统内置的弹窗
 */

@Composable
fun AlertDialogSamples() {
    var show by remember {
        mutableStateOf(false)
    }
    val app = LocalContext.current.applicationContext
    Divider(thickness = 1.dp, color = Color.Red)
    Column(Modifier.fillMaxWidth()) {
        Button(onClick = { show = true }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "点击弹窗")
        }
        if (show) {
            AlertDialog(onDismissRequest = { show = false }, confirmButton = {
                Button(onClick = {
                    show = false
                    Toast.makeText(app, "点击了确认", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "确认")
                }
            },
                //点击外面不消失弹框
                properties = DialogProperties(dismissOnClickOutside = false),
                dismissButton = {
                    Button(onClick = {
                        show = false
                        Toast.makeText(app, "点击了取消", Toast.LENGTH_SHORT).show()

                    }) {
                        Text(text = "取消")
                    }
                }, text = {
                    Text(text = "是否确认删除？")
                }, title = {
                    Text(text = "警告：删除操作")
                }
            )
        }
    }
}

@Preview
@Composable
fun AlertDialogSamplesPreview() {
    AlertDialogSamples()
}

