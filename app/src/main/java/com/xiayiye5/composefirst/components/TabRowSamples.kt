package com.xiayiye5.composefirst.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
 * 创建时间：2022/5/5 19:49
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：TabRow指示器基本用法
 */


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TabRowSamples() {
    var selectIndex by remember {
        mutableStateOf(0)
    }
    var tabIndex by remember {
        mutableStateOf(1)
    }
    var difIndex by remember {
        mutableStateOf(2)
    }
    Column {
        //1.自定义控件,根据需求放对应的控件
        TabRow(selectedTabIndex = selectIndex) {
            Button(onClick = { selectIndex = 0 }) {
                Text(
                    text = "学习",
                    color = if (selectIndex == 0) Color.Red else Color.White,
                    fontSize = if (selectIndex == 0) 18.sp else 16.sp
                )
            }
            Button(onClick = { selectIndex = 1 }) {
                Text(
                    text = "任务",
                    color = if (selectIndex == 1) Color.Red else Color.White,
                    fontSize = if (selectIndex == 1) 18.sp else 16.sp
                )
            }
            Button(onClick = { selectIndex = 2 }) {
                Text(
                    text = "菜单",
                    color = if (selectIndex == 2) Color.Red else Color.White,
                    fontSize = if (selectIndex == 2) 18.sp else 16.sp
                )
            }
            Button(onClick = { selectIndex = 3 }) {
                Text(
                    text = "我的",
                    color = if (selectIndex == 3) Color.Red else Color.White,
                    fontSize = if (selectIndex == 3) 18.sp else 16.sp
                )
            }
        }

        //2.原生控件,根据需求放置对应的控件
        TabRow(selectedTabIndex = tabIndex) {
            Tab(selected = tabIndex == 0, onClick = {
                tabIndex = 0
            }, selectedContentColor = Color.Red, unselectedContentColor = Color.White) {
                Text(
                    text = "首页",
//                    color = if (tabIndex == 0) Color.Red else Color.White,
                    fontSize = if (tabIndex == 0) 18.sp else 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Tab(selected = tabIndex == 1, onClick = {
                tabIndex = 1
            }, selectedContentColor = Color.Red, unselectedContentColor = Color.White) {
                Text(
                    text = "作业",
//                    color = if (tabIndex == 1) Color.Red else Color.White,
                    fontSize = if (tabIndex == 1) 18.sp else 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Tab(selected = tabIndex == 2, onClick = {
                tabIndex = 2
            }, selectedContentColor = Color.Red, unselectedContentColor = Color.White) {
                Text(
                    text = "练习",
//                    color = if (tabIndex == 2) Color.Red else Color.White,
                    fontSize = if (tabIndex == 2) 18.sp else 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Tab(selected = tabIndex == 3, onClick = {
                tabIndex = 3
            }, selectedContentColor = Color.Red, unselectedContentColor = Color.White) {
                Text(
                    text = "我的",
//                    color = if (tabIndex == 3) Color.Red else Color.White,
                    fontSize = if (tabIndex == 3) 18.sp else 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        //3.原生自带样式的tab
        TabRow(selectedTabIndex = difIndex) {
            Text(
                text = "第一种",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(0.dp, 30.dp, 0.dp, 30.dp)
                    .clickable { difIndex = 0 }
            )
            Tab(selected = difIndex == 1, onClick = { difIndex = 1 }, icon = {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }, text = { Text(text = "删除") })
            LeadingIconTab(
                selected = difIndex == 2,
                onClick = { difIndex = 2 },
                text = { Text(text = "第三种") }, icon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null
                    )
                }, modifier = Modifier.padding(0.dp, 13.dp, 0.dp, 13.dp)
            )
        }
    }
}

@Preview
@Composable
fun TabRowSamplesPreview() {
    TabRowSamples()
}

