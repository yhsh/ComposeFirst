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
 * 创建时间：2022/5/5 21:01
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：DropDownMenu菜单控件的基本用法
 */
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DropDownMenuSamples() {
    var close by remember {
        mutableStateOf(false)
    }
    val mContext = LocalContext.current
    Column() {
        Button(onClick = { close = true }) {
            Text(text = "点我弹出菜单栏")
        }
        DropdownMenu(expanded = close, onDismissRequest = {
            //点击外部空白消失
            close = false
        }) {
            DropdownMenuItem(onClick = {
                showToast(mContext, "点击了数学！")
                close = false
            }) {
                Text(text = "数学", textAlign = TextAlign.Center)
            }
            DropdownMenuItem(onClick = {
                showToast(mContext, "点击了语文！")
                close = false
            }) {
                Text(text = "语文", textAlign = TextAlign.Center)
            }
            DropdownMenuItem(onClick = {
                showToast(mContext, "点击了计算机！")
                close = false
            }) {
                Text(text = "计算机", textAlign = TextAlign.Center)
            }
        }
    }
}

fun showToast(mContext: Context, msg: String) {
    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
fun DropDownMenuSamplesPreview() {
    DropDownMenuSamples()
}

