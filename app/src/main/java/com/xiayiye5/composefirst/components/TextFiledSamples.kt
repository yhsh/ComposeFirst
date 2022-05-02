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
 * 创建时间：2022/5/2 8:08
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：TextFiled文本输入框基本用法
 */
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFiledSamples() {
    //用于记录文本输入框的输入的数据
    var inputText by remember {
        mutableStateOf("")
    }
    val pwd = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column() {
        TextField(
            value = inputText,
            onValueChange = {
                //将输入框里面的数据赋值给记录的变量
                inputText = it
            },
            //输入框左边的标题
            label = {
                Text(text = "账号")
            },
            //输入框的提示语类似hint
            placeholder = {
                Text(text = "请输入账号")
            },
            //输入框左边的图标
            leadingIcon = {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "左边的图标")
            },
            //设置键盘参数
            keyboardOptions = KeyboardOptions(
                //设置键盘类动作为搜索按钮
                imeAction = ImeAction.Search,
                //设置键盘类似为纯文本
                keyboardType = KeyboardType.Text
            ),
            //设置输入框文本当行显示
            singleLine = true,
            //设置最大为1行
            maxLines = 1,
            //设置外部边框以及边框颜色
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, color = Color.Blue),
            //设置点击键盘的搜索动作按钮的监听
            keyboardActions = KeyboardActions(onSearch = {
                Toast.makeText(context, "当前输入的数据为：$inputText", Toast.LENGTH_SHORT).show()
            }),
            //设置输入框的背景色为透明
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
        )
        OutlinedTextField(
            value = TextFieldValue(text = pwd.value),
            onValueChange = {
                pwd.value = it.text
            },
            keyboardActions = KeyboardActions(onNext = {
                Toast.makeText(context, "当前输入的密码为：${pwd.value}", Toast.LENGTH_SHORT).show()
            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.NumberPassword
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "请输入密码")
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Menu, contentDescription = "密码") },
            label = { Text(text = "密码") }
        )
    }
}

@Preview
@Composable
fun TextFiledSamplesPreview() {
    TextFiledSamples()
}

