package com.xiayiye5.composefirst.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.xiayiye5.composefirst.util.RoutePathUtil

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
 * 创建时间：2022/5/17 21:17
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：navigation页面跳转携带参数的基本用法
 */

@Composable
fun PageJumpSamples() {
    val mNavController = rememberNavController()
    NavHost(navController = mNavController, startDestination = RoutePathUtil.PAGE_JUMP_SAMPLES) {
        composable(
            route = RoutePathUtil.PAGE_JUMP_SAMPLES,
        ) {
            ActivityOne {
                //携带参数如下:方法一
//                mNavController.navigate(route = "${RoutePathUtil.ACTIVITY_TWO}/张三/23") {
                //携带参数如下:方法二
                mNavController.navigate(route = "${RoutePathUtil.ACTIVITY_TWO}?name=张三&age=23") {
                    //类似Activity中的SingleTop
                    launchSingleTop = true
                }
            }
        }
        composable(
            //参数格式如下:方法一
//            route = "${RoutePathUtil.ACTIVITY_TWO}/{name}/{age}",
            //参数格式如下:方法二
            route = "${RoutePathUtil.ACTIVITY_TWO}?name={name}&age={age}",
            arguments = listOf(navArgument("name") {
                //设置参数类型
                type = NavType.StringType
                defaultValue = "王二麻子"
            }, navArgument("age") {
                //设置参数类型
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getInt("age")
            ActivityTwo(name ?: "王二麻子", age ?: -1) {
                mNavController.popBackStack()
            }
        }
    }
}

@Composable
fun ActivityOne(navigation: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null
                )
            }, title = {
                Text(text = "好好学习，天天向上！")
            }, actions = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                Text(text = "编辑")
            })
        }
    ) {
        Column() {
            Text(text = "学习不是为了别人，而是为了自己！")
            Button(onClick = {
                //跳转到学习页面
                navigation()
            }) {
                Text(text = "点击开始学习")
            }
        }
    }
}

@Composable
fun ActivityTwo(name: String, age: Int, navigation: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null
                )
            }, title = {
                Text(text = "学习强大自己！")
            }, actions = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                Text(text = "编辑")
            })
        }
    ) {
        Column() {
            Text(text = "我是${name}今年${age}岁，只有学习，才能成就自己！")
            Button(onClick = {
                //跳转到学习页面
                navigation()
            }) {
                Text(text = "点击返回")
            }
        }
    }
}

@Preview
@Composable
fun PageJumpSamplesPreview() {
    PageJumpSamples()
}