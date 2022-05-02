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
 * 创建时间：2022/5/2 17:26
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：RadioButton按钮基本用法
 */
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.RadioButton
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonSamples() {
    //单个按钮的用法
    var singleButton by remember {
        mutableStateOf(false)
    }
    var bigButton by remember {
        mutableStateOf(listOf(false, false))
    }
    val context = LocalContext.current
    Column {
        RadioButton(selected = singleButton, onClick = {
            singleButton = !singleButton
            Toast.makeText(context, if (singleButton) "选中了" else "未选中", Toast.LENGTH_SHORT).show()
        })
        Divider(thickness = 0.5.dp, color = Color.Red, startIndent = 5.dp)
        bigButton.forEachIndexed { index, b ->
            RadioButton(selected = b, onClick = {
                bigButton = bigButton.mapIndexed { position, _ ->
                    //改变选中状态的值
                    index == position
                }
            })
        }
    }
}

@Preview
@Composable
fun RadioButtonSamplesPreview() {
    RadioButtonSamples()
}

