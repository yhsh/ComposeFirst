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
 * 创建时间：2022/5/2 17:47
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：CheckBox勾选控件基本用法
 */
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckBoxSamples() {
    var singleCheckBox by remember {
        mutableStateOf(false)
    }
    var bigCheckBox by remember {
        mutableStateOf(listOf(false, false))
    }
    Column() {
        //单个勾选框
        Checkbox(checked = singleCheckBox, onCheckedChange = {
            singleCheckBox = it
        })
        //多个勾选框
        bigCheckBox.forEachIndexed { i, check ->
            Checkbox(checked = check, onCheckedChange = {
                bigCheckBox = bigCheckBox.mapIndexed { j, isSelect ->
                    if (i == j) {
                        !isSelect
                    } else {
                        isSelect
                    }
                }
            })
        }
    }
}

@Preview
@Composable
fun CheckBoxSamplesPreview() {
    CheckBoxSamples()
}

