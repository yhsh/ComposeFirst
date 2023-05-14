package com.xiayiye5.composefirst.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

/*
 * Copyright (c) 2023, 13343401268@163.com All Rights Reserved.
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
 * 创建时间：2023/5/14 16:15
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Compose中Animation动画的基本用法
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun AccompanistPagerSample() {
    val data = arrayListOf("学习", "任务", "菜单", "我的")
    val selectIndex = remember {
        mutableStateOf(0)
    }
    val pageState = rememberPagerState(pageCount = data.size)
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectIndex.value, indicator = { tabIndicator ->
            //设置指示器的颜色和位置
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabIndicator[selectIndex.value]),
                color = Color.Red
            )
        }) {
            data.forEachIndexed { index, tabContent ->
                Tab(selected = index == selectIndex.value, onClick = {
                    selectIndex.value = index
                    scope.launch {
                        pageState.scrollToPage(selectIndex.value)
                    }
                }, text = {
                    Text(
                        text = tabContent,
                        color = if (selectIndex.value == index) Color.Red else Color.White,
                        fontSize = if (selectIndex.value == index) 18.sp else 16.sp
                    )
                })

//                Button(onClick = {
//                    selectIndex.value = index
//                    scope.launch {
//                        pageState.scrollToPage(selectIndex.value)
//                    }
//                }) {
//                    Text(
//                        text = tabContent,
//                        color = if (selectIndex.value == index) Color.Red else Color.White,
//                        fontSize = if (selectIndex.value == index) 18.sp else 16.sp
//                    )
//                }
            }
        }
        HorizontalPager(state = pageState) { page ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (page) {
                    0 -> Text(text = data[0])
                    1 -> Text(text = data[1])
                    2 -> Text(text = data[2])
                    3 -> Text(text = data[3])
                }
                //修改tab的选中角标,下面必须使用currentPage，因为这个值会动态更新
                selectIndex.value = pageState.currentPage
            }
        }
    }
}

@Preview
@Composable
fun AccompanistPagerSamplePreview() {
    AccompanistPagerSample()
}