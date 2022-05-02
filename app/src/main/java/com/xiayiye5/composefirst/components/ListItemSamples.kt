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
 * 创建时间：2022/5/2 19:44
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：ListItem列表布局基本用法,有bug待修复
 */
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemSamples() {
    var listData by remember {
        mutableStateOf(
            listOf(
                ListItemModel("张三", false),
                ListItemModel("李四", false),
                ListItemModel("王五", false),
                ListItemModel("小六", false),
                ListItemModel("黄七", false)
            )
        )
    }
    Column() {
        listData.forEachIndexed { index, itemModel ->
            ListItem(
                icon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = null) },
                secondaryText = { Text(text = itemModel.name) },
                trailing = {
                    Checkbox(checked = itemModel.isCheck, onCheckedChange = { isSelect ->
                        listData = listData.mapIndexed { i, model ->
                            if (index == i) {
                                itemModel.isCheck = !model.isCheck
                            } else {
                                itemModel.isCheck = model.isCheck
                            }
                            return@mapIndexed itemModel
                        }
                        Log.d("ListItemSamples", "打印数据${listData}--是否选中：$isSelect")
                    })
                }, text = { Text(text = itemModel.name + index) })
            Divider(thickness = 0.5.dp, color = Color.Red, startIndent = 10.dp)
        }
    }
}

data class ListItemModel(val name: String, var isCheck: Boolean)

@Preview
@Composable
fun ListItemSamplesPreview() {
    ListItemSamples()
}

