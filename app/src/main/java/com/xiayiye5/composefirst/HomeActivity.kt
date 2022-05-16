package com.xiayiye5.composefirst

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity

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
 * 创建时间：2022/5/16 11:03
 * 个人小站：http://yhsh.wap.ai(已挂)
 * 最新小站：http://www.iyhsh.icoc.in
 * 联系作者：企鹅 13343401268
 * 博客地址：http://blog.csdn.net/xiayiye5
 * 项目名称：ComposeFirst
 * 文件包名：com.xiayiye5.composefirst
 * 文件说明：首页学习案例列表页面
 */
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val lvCompose = findViewById<ListView>(R.id.lv_compose)
        lvCompose.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> openComposeListPage()
            }
        }
    }

    /**
     * 跳转Compose列表页面
     */
    private fun openComposeListPage() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}