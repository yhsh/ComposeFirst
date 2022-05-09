package com.xiayiye5.composefirst.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

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
 * 创建时间：2022/5/9 19:38
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：BackDropScaffold基本用法
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackDropScaffoldSamples() {
    val scope = rememberCoroutineScope()
    val state = rememberBackdropScaffoldState(BackdropValue.Concealed)
    BackdropScaffold(scaffoldState = state,
        appBar = {
            TopAppBar(navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null, Modifier.clickable {
                        scope.launch {
                            if (state.isConcealed) {
                                //如果关闭了就打开
                                state.reveal()
                            } else {
                                //如果打开了就关闭
                                state.conceal()
                            }
                        }
                    }
                )
            }, title = { Text(text = "点击试一下") })
        },
        backLayerContent = {
            LazyColumn() {
                items(20) {
                    ListItem(text = { Text(text = "我是后面内容$it", Modifier.background(Color.Red)) })
                }
            }
        }, frontLayerContent = {
            Text("我是前面的内容", modifier = Modifier.background(Color.Green))
        }, modifier = Modifier.height(300.dp)
    )
}

@Preview
@Composable
fun BackDropScaffoldSamplesPreview() {
    BackDropScaffoldSamples()
}

