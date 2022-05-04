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
 * 创建时间：2022/5/4 21:11
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：ConstraintLayout约束布局高级用法
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

const val iconId = "icon"
const val cityId = "city"
const val addressId = "address"
const val selectId = "select"

@Composable
fun ConstraintLayout2Samples() {
    var check by remember {
        mutableStateOf(false)
    }
    //一定要将constrainId设置到下面的约束布局中，否则不生效
    val constrainId = ConstraintSet {
        val icon = createRefFor(iconId)
        val city = createRefFor(cityId)
        val address = createRefFor(addressId)
        val select = createRefFor(selectId)
        //下面布局对齐请参考ConstraintLayoutSamples实例，基本是一样的
        constrain(icon) {
            centerVerticallyTo(parent)
            start.linkTo(parent.start, margin = 15.dp)
        }
        constrain(city) {
            top.linkTo(icon.top)
            start.linkTo(icon.end, margin = 15.dp)
        }
        constrain(address) {
            top.linkTo(city.bottom)
            start.linkTo(icon.end, margin = 15.dp)
        }
        constrain(select) {
            centerVerticallyTo(parent)
            end.linkTo(parent.end, margin = 15.dp)
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color(111, 222, 255))
            .fillMaxWidth()
            .height(60.dp),
        //下面必须设置对应的id，否则不生效
        constraintSet = constrainId
    ) {
        //写四个子控件
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            modifier = Modifier.layoutId(iconId)
        )
        Text(text = "城市", color = Color.White, modifier = Modifier.layoutId(cityId))
        Text(text = "地址", color = Color.Red, modifier = Modifier.layoutId(addressId))
        Checkbox(
            checked = check,
            onCheckedChange = { check = it },
            modifier = Modifier.layoutId(selectId)
        )
    }
}

@Preview
@Composable
fun ConstraintLayout2SamplesPreview() {
    ConstraintLayout2Samples()
}

