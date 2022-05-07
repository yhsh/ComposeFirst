package com.xiayiye5.composefirst.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
 * #               佛祖保佑         永无BUG              #
 * #                                                   #
 */

/**
 * @author 下一页5（轻飞扬）
 * 创建时间：2022/5/7 20:33
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Scaffold脚手架控件基本用法之bottomBar控件之BottomNavigation
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ScaffoldBottomBarSamples() {
    var checkIndex by remember {
        mutableStateOf(0)
    }
    val bottomNumber = listOf("首页", "清除", "电话", "邮箱")
    val bottomIcon =
        listOf(Icons.Default.Home, Icons.Default.Clear, Icons.Default.Call, Icons.Default.Email)
    Divider(thickness = 0.5.dp, color = Color.Red)
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "我是标题")
        }, navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        }, actions = {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Text(text = "添加", Modifier.padding(10.dp, 0.dp, 20.dp, 0.dp))
        })
    }, bottomBar = {
        BottomNavigation() {
            bottomNumber.forEachIndexed { index, contentText ->
                BottomNavigationItem(
                    selected = checkIndex == index,
                    onClick = { checkIndex = index }, label = {
                        Text(text = contentText)
                    }, icon = {
                        if (checkIndex == index) {
                            BadgeBox(badgeContent = {
                                //显示消息气泡99+
                                Text(text = "99+")
                            }, contentColor = Color.White, backgroundColor = Color.Red) {
                                Icon(imageVector = bottomIcon[index], contentDescription = null)
                            }
                        } else {
                            Icon(imageVector = bottomIcon[index], contentDescription = null)
                        }
                    }, selectedContentColor = Color.Red, unselectedContentColor = Color.White
                )
            }
        }
    }, modifier = Modifier.height(480.dp)) {
        Text(text = "我是整个页面最重要的内容")
    }
}

@Preview
@Composable
fun ScaffoldBottomBarSamplesPreview() {
    ScaffoldBottomBarSamples()
}

