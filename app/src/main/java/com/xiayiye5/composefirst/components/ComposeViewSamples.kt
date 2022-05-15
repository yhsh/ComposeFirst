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
 * 创建时间：2022/5/15 15:00
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst.components
 * 文件说明：Compose中使用XML布局和XML布局中使用Compose的基本用法
 */
import android.view.LayoutInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.xiayiye5.composefirst.R

@Composable
fun ComposeViewSamples() {
    Column(
        modifier = Modifier
            .background(Color.White)
            //这里得设置最大宽度，不然下面的xml布局的宽度不会充满手机宽度
            .fillMaxWidth()
    ) {
        Text(text = "我是Compose布局中的文本控件")
        AndroidView(factory = { mContext ->
            //Compose中使用XML布局的方法
            LayoutInflater.from(mContext).inflate(R.layout.compose_view_layout, null, false)
        }) { rootView ->
            //XML布局中使用Compose的方法
            val composeViewLayout = rootView.findViewById<ComposeView>(R.id.cv_layout)
            composeViewLayout.setContent {
                Text(text = "我是ComposeView布局里面的内容")
            }
        }
    }
}

@Preview
@Composable
fun ComposeViewSamplesPreview() {
    ComposeViewSamples()
}

