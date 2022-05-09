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
 * 创建时间：2022/5/9 20:31
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：BottomSheetScaffold之底部滑出菜单基本用法
 */
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScaffoldSamples() {
    val bottomState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    Divider(thickness = 0.5.dp, color = Color.Red)
    BottomSheetScaffold(scaffoldState = bottomState, topBar = {
        TopAppBar(navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null
            )
        }, title = {
            Text(text = "底部滑出菜单")
        })
    }, sheetContent = {
        Box(
            modifier = Modifier
                .height(130.dp)
                .fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Text(text = "向上可滑出底部菜单")
        }
        Column(
            Modifier
                .padding(64.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "我是底部菜单的内容")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                scope.launch {
//                        bottomState.bottomSheetState.expand()
                    bottomState.bottomSheetState.collapse()
                }
            }) {
                Text("关闭底部菜单")
            }
        }
    }, sheetPeekHeight = 130.dp, modifier = Modifier
        .height(500.dp)
        .fillMaxWidth()
    ) {
        Text("我是内容")
    }
}

@Preview
@Composable
fun BottomSheetScaffoldSamplesPreview() {
    BottomSheetScaffoldSamples()
}

