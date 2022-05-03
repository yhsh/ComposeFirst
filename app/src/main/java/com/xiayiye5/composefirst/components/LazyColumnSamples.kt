package com.xiayiye5.composefirst.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

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
 * 创建时间：2022/5/3 8:24
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：LazyColumn带滚动的列表
 */

@OptIn(ExperimentalMaterialApi::class, androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun LazyColumnSamples() {
    val dataList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
    val scrollerState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    //滑动方法一
    //此方法会一次性创建所以的item会有内存泄漏的风险，不建议使用
    Column() {
        Row(
            //Row和Column默认不可滚动，需要添加下面的滚动属性才可以
            modifier = Modifier
                .horizontalScroll(scrollerState)
                .height(45.dp)
        ) {
            dataList.forEachIndexed { _, listValue ->
                ListItem(
                    secondaryText = { Text(text = "滚动演示$listValue") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null
                        )
                    },
                    text = { Text(text = "滚动$listValue") },
                    trailing = { Text(text = "右边$listValue") },
                    modifier = Modifier.clickable {
                        //开启线程
                        coroutineScope.launch {
                            //点击后滑动,下面2个方法会阻塞主线程，所以需要单独开启线程
//                        scrollerState.animateScrollTo(200)
                            if (scrollerState.value == scrollerState.maxValue) {
                                scrollerState.animateScrollBy(-200f)
                            } else {
                                scrollerState.animateScrollBy(200f)
                            }
                        }
                    })
                //下面是监听生命周期的方法
                DisposableEffect(Unit) {
                    //创建的时候走此方法
                    Log.d("LazyColumnSamples-onCreate", listValue.toString())
                    onDispose {
                        //销毁的时候走此方法
                        Log.d("LazyColumnSamples-onDestroy", listValue.toString())
                    }
                }
                Divider(thickness = 0.5.dp, color = Color.Red)
            }
        }

        val scrollerLazyStata = rememberLazyListState()
        //滑动方法一 使用系统提供的LazyRow实现,自带缓存机制和ListView类似
        //此方法会一次性创建整个屏幕占据多少item的数量，每次滑动会再创建一个销毁一个，建议使用
        var scrollerEndPosition = 0
        LazyRow(Modifier.height(45.dp), state = scrollerLazyStata) {
            stickyHeader {
                Text(text = "我是浮动标签", color = Color.Red)
            }
            items(dataList) { position ->
                ListItem(
                    secondaryText = { Text(text = "横向滑动列表$position") },
                    trailing = { Text(text = "横向滚动标题$position") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = null
                        )
                    }, text = { Text(text = "横向右边$position") }, modifier = Modifier.clickable {
                        coroutineScope.launch {
                            if (position == dataList.size || scrollerEndPosition == dataList.size) {
                                scrollerEndPosition = if (position == 1) 1 else dataList.size
                                Log.d("滑动左边", position.toString())
                                scrollerLazyStata.animateScrollToItem(position - 1)
//                                scrollerLazyStata.animateScrollBy(-200f)
                            } else {
                                Log.d("滑动右边", position.toString())
                                scrollerLazyStata.animateScrollToItem(position)
//                                scrollerLazyStata.animateScrollToItem(200)
                            }
//                            scrollerLazyStata.animateScrollBy(200f)
                        }
                    })
                Divider(thickness = 0.5.dp, color = Color.Red)
                DisposableEffect(Unit) {
                    //创建的时候走此方法
                    Log.d("创建", position.toString())
                    onDispose {
                        //销毁的时候走此方法
                        Log.d("销毁", position.toString())
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LazyColumnSamplesPreview() {
    LazyColumnSamples()
}

