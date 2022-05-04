package com.xiayiye5.composefirst.components

/*
 * Copyright (c) 1522, smuyyh@gmail.com All Rights Reserved.
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
 * 创建时间：2022/5/4 20:12
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：ConstraintLayout约束布局基本用法
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutSamples() {
    var select by remember {
        mutableStateOf(false)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Blue)
    ) {
        val (icon, phone, name, checkBox) = createRefs()
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            modifier = Modifier.constrainAs(icon) {
                //子控件的上对父控件的上
                top.linkTo(parent.top)
                //子控件的下对父控件的下
                bottom.linkTo(parent.bottom)
                //子控件的左对父控件的左
                start.linkTo(parent.start, margin = 15.dp)
            }
        )
        Text(
            text = "手机号",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.constrainAs(phone) {
                //子控件的左对父控件的icon控件的右
                start.linkTo(icon.end, margin = 15.dp)
                //子控件的上对父控件的上
                top.linkTo(icon.top)
            }
        )
        Text(text = "姓名", color = Color.Red, modifier = Modifier.constrainAs(name) {
            //子控件的左对icon控件的右
            start.linkTo(icon.absoluteRight, margin = 15.dp)
            //子控件的上对父控件的下
            top.linkTo(phone.bottom)
        })
        Checkbox(
            checked = select,
            onCheckedChange = { select = it },
            modifier = Modifier.constrainAs(checkBox) {
//                absoluteRight.linkTo(parent.absoluteRight, 15.dp)
//                top.linkTo(parent.top)
//                bottom.linkTo(parent.bottom)
                //简单写法,垂直居中
                centerVerticallyTo(parent)
                //子控件的右对父控件的右
                end.linkTo(parent.end, margin = 15.dp)
            })
    }
}

@Preview
@Composable
fun ConstraintLayoutSamplesPreview() {
    ConstraintLayoutSamples()
}

