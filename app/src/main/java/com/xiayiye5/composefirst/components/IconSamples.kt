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
 * 创建时间：2022/5/1 18:52
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：图标，图片资源基本用法 Icon只能使用矢量图片 Image可以显示png等图片
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xiayiye5.composefirst.R

@Composable
fun IconSamples() {
    Row(
        Modifier
            .border(1.dp, color = Color.Blue)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        //方法一 系统默认图标
        Icon(imageVector = Icons.Default.Home, contentDescription = null)
        //方法二 drawable文件夹下面ImageVector矢量图片 painter格式
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_5g_24),
            contentDescription = null
        )
        //方法三 drawable和mipmap文件夹下面图标 bitmap格式
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.image_bitmap),
//            tint = Color.Red,
            contentDescription = null
        )
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.image_bitmap),
//            tint = Color.Red,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun IconSamplesPreview() {
    IconSamples()
}

