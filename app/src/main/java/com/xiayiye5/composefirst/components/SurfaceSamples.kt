package com.xiayiye5.composefirst.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xiayiye5.composefirst.R

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
 * #               ????????????         ??????BUG              #
 * #                                                   #
 */

/**
 * @author ?????????5???????????????
 * ???????????????2022/5/6 20:44
 * ???????????????http://yhsh.wap.ai(??????)
 * ???????????????http://www.iyhsh.icoc.in
 * ????????????????????? 13343401268
 * ???????????????http://blog.csdn.net/xiayiye5
 * ???????????????ComposeFirst
 * ???????????????com.xiayiye5.composefirst.components
 * ???????????????Surface?????????????????????
 */

@Composable
fun SurfaceSamples() {
    val scrollerState = rememberScrollState()
    Row(Modifier.horizontalScroll(scrollerState)) {
        //??????
        ImagePage(RectangleShape, Modifier.weight(1f))
        //??????
        ImagePage(RoundedCornerShape(30.dp), Modifier.weight(1f))
        //50%??????
        ImagePage(CircleShape, Modifier.weight(1f))
        //????????????
        ImagePage(CutCornerShape(30.dp), Modifier.weight(1f))
    }
}

@Composable
private fun ImagePage(shape: Shape, modifier: Modifier) {
    Surface(
        //??????shape??????
        shape = shape,
        //????????????
        border = BorderStroke(1.dp, color = Color.Red),
        //????????????
        elevation = 10.dp
    ) {
//    Surface(shape = shape, modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.image_bitmap), contentDescription = null
        )
    }
}

@Preview
@Composable
fun SurfaceSamplesPreview() {
    SurfaceSamples()
}

