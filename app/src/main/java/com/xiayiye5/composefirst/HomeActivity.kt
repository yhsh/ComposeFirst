package com.xiayiye5.composefirst

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xiayiye5.composefirst.components.*
import com.xiayiye5.composefirst.util.RoutePathUtil

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
 * 文件说明：首页学习案例列表页面,Navigation导航路由组件的基本用法
 */
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewPage()
        }
    }
}

@Composable
fun ComposeViewPage() {
    val current = LocalContext.current
    val mNavController = rememberNavController()
    //默认为首页地址
    NavHost(navController = mNavController, startDestination = RoutePathUtil.MAIN) {
        composable(route = RoutePathUtil.MAIN) {
            AndroidView(factory = { mContext ->
                LayoutInflater.from(mContext).inflate(R.layout.home_activity, null, false)
            }) { xmlRootView ->
                val lvCompose = xmlRootView.findViewById<ListView>(R.id.lv_compose)
                lvCompose.setOnItemClickListener { _, _, position, _ ->
                    when (position) {
                        0 -> startActivity(current, Intent(current, MainActivity::class.java), null)
                        1 -> mNavController.navigate(RoutePathUtil.TEXT_SAMPLES)
                        2 -> mNavController.navigate(RoutePathUtil.CLICKABLE_TEXT_SAMPLES)
                        3 -> mNavController.navigate(RoutePathUtil.MODIFIER_SAMPLES)
                        4 -> mNavController.navigate(RoutePathUtil.BUTTON_SAMPLES)
                        5 -> mNavController.navigate(RoutePathUtil.ICON_SAMPLES)
                        6 -> mNavController.navigate(RoutePathUtil.IMAGE_SAMPLES)
                        7 -> mNavController.navigate(RoutePathUtil.STATE_SAMPLES)
                        8 -> mNavController.navigate(RoutePathUtil.SWITCH_SAMPLES)
                        9 -> mNavController.navigate(RoutePathUtil.TEXT_FILED_SAMPLES)
                        10 -> mNavController.navigate(RoutePathUtil.PROGRESS_INDICATOR_SAMPLES)
                        11 -> mNavController.navigate(RoutePathUtil.SLIDER_SAMPLES)
                        12 -> mNavController.navigate(RoutePathUtil.CARD_SAMPLES)
                        13 -> mNavController.navigate(RoutePathUtil.BOX_SAMPLES)
                        14 -> mNavController.navigate(RoutePathUtil.COLUMN_SAMPLES)
                        15 -> mNavController.navigate(RoutePathUtil.ROW_SAMPLES)
                        16 -> mNavController.navigate(RoutePathUtil.SPACER_SAMPLES)
                        17 -> mNavController.navigate(RoutePathUtil.DIVIDER_SAMPLES)
                        18 -> mNavController.navigate(RoutePathUtil.RADIOBUTTON_SAMPLES)
                        19 -> mNavController.navigate(RoutePathUtil.CHECKBOX_SAMPLES)
                        20 -> mNavController.navigate(RoutePathUtil.LIST_ITEM_SAMPLES)
                        21 -> mNavController.navigate(RoutePathUtil.LAZY_COLUMN_SAMPLES)
                        22 -> mNavController.navigate(RoutePathUtil.LAZY_VERTICAL_GRID_SAMPLES)
                        23 -> mNavController.navigate(RoutePathUtil.CONSTRAINT_LAYOUT_SAMPLES)
                        24 -> mNavController.navigate(RoutePathUtil.CONSTRAINT_LAYOUT2_SAMPLES)
                        25 -> mNavController.navigate(RoutePathUtil.TAB_ROW_SAMPLES)
                        26 -> mNavController.navigate(RoutePathUtil.DROP_DOWN_MENU_SAMPLES)
                        27 -> mNavController.navigate(RoutePathUtil.SURFACE_SAMPLES)
                        28 -> mNavController.navigate(RoutePathUtil.SCAFFOLD_TOP_BAR_SAMPLES)
                        29 -> mNavController.navigate(RoutePathUtil.SCAFFOLD_BOTTOM_BAR_SAMPLES)
                        30 -> mNavController.navigate(RoutePathUtil.SCAFFOLD_MENU_SAMPLES)
                        31 -> mNavController.navigate(RoutePathUtil.BACK_DROP_SCAFFOLD_SAMPLES)
                        32 -> mNavController.navigate(RoutePathUtil.BOTTOM_SHEET_SCAFFOLD_SAMPLES)
                        33 -> mNavController.navigate(RoutePathUtil.DIALOG_SAMPLES)
                        34 -> mNavController.navigate(RoutePathUtil.ALERTDIALOG_SAMPLES)
                        35 -> mNavController.navigate(RoutePathUtil.COMPOSE_VIEW_SAMPLES)
                        36 -> mNavController.navigate(RoutePathUtil.PAGE_JUMP_SAMPLES)
                        37 -> mNavController.navigate(RoutePathUtil.ANIMATION_SAMPLES)
                        38 -> mNavController.navigate(RoutePathUtil.ACCOMPANIST_PAGER)
                    }
                }
            }
        }
        //文本基本用法页面
        composable(route = RoutePathUtil.TEXT_SAMPLES) {
            TextSamples()
        }
        //Text的高级用法
        composable(route = RoutePathUtil.CLICKABLE_TEXT_SAMPLES) {
            ClickAbleTextSamples()
        }
        //Modifier可以修饰控件的很多属性，大小，布局，样式，可点击等
        composable(route = RoutePathUtil.MODIFIER_SAMPLES) {
            ModifierSamples()
        }
        //Button和ButtonText按钮的基本用法
        composable(route = RoutePathUtil.BUTTON_SAMPLES) {
            ButtonSamples()
        }
        //图标，图片资源基本用法 Icon只能使用矢量图片 Image可以显示png等图片
        composable(route = RoutePathUtil.ICON_SAMPLES) {
            IconSamples()
        }
        //Image的基本用法
        composable(route = RoutePathUtil.IMAGE_SAMPLES) {
            ImageSamples()
        }
        //state状态用法
        composable(route = RoutePathUtil.STATE_SAMPLES) {
            StateSamples()
        }
        //switch切换开关基础用法
        composable(route = RoutePathUtil.SWITCH_SAMPLES) {
            SwitchSamples()
        }
        //TextFiled文本输入框基本用法
        composable(route = RoutePathUtil.TEXT_FILED_SAMPLES) {
            TextFiledSamples()
        }
        //ProgressIndicator进度条的基本用法
        composable(route = RoutePathUtil.PROGRESS_INDICATOR_SAMPLES) {
            ProgressIndicatorSamples()
        }
        //Slider可拖动的进度条
        composable(route = RoutePathUtil.SLIDER_SAMPLES) {
            SliderSamples()
        }
        //Card卡片布局基本用法
        composable(route = RoutePathUtil.CARD_SAMPLES) {
            CardSamples()
        }
        //Box布局容器控件基本用法
        composable(route = RoutePathUtil.BOX_SAMPLES) {
            BoxSamples()
        }
        //Column垂直布局基本用法
        composable(route = RoutePathUtil.COLUMN_SAMPLES) {
            ColumnSamples()
        }
        //Row水平布局基本用法
        composable(route = RoutePathUtil.ROW_SAMPLES) {
            RowSamples()
        }
        //Spacer空格、占位符控件基本使用方法
        composable(route = RoutePathUtil.SPACER_SAMPLES) {
            SpacerSamples()
        }
        //Divider分割线控件的基本用法
        composable(route = RoutePathUtil.DIVIDER_SAMPLES) {
            DividerSamples()
        }
        //RadioButton按钮基本用法
        composable(route = RoutePathUtil.RADIOBUTTON_SAMPLES) {
            RadioButtonSamples()
        }
        //CheckBox勾选控件基本用法
        composable(route = RoutePathUtil.CHECKBOX_SAMPLES) {
            CheckBoxSamples()
        }
        //ListItem列表布局基本用法
        composable(route = RoutePathUtil.LIST_ITEM_SAMPLES) {
            ListItemSamples()
        }
        //LazyColumn带滚动的列表
        composable(route = RoutePathUtil.LAZY_COLUMN_SAMPLES) {
            LazyColumnSamples()
        }
        //LazyVerticalGrid网格布局基本用法
        composable(route = RoutePathUtil.LAZY_VERTICAL_GRID_SAMPLES) {
            LazyVerticalGridSamples()
        }
        //ConstraintLayout约束布局基本用法
        composable(route = RoutePathUtil.CONSTRAINT_LAYOUT_SAMPLES) {
            ConstraintLayoutSamples()
        }
        //ConstraintLayout约束布局高级用法
        composable(route = RoutePathUtil.CONSTRAINT_LAYOUT2_SAMPLES) {
            ConstraintLayout2Samples()
        }
        //TabRow指示器基本用法
        composable(route = RoutePathUtil.TAB_ROW_SAMPLES) {
            TabRowSamples()
        }
        //DropDownMenu菜单控件的基本用法
        composable(route = RoutePathUtil.DROP_DOWN_MENU_SAMPLES) {
            DropDownMenuSamples()
        }
        //Surface容器的基本使用
        composable(route = RoutePathUtil.SURFACE_SAMPLES) {
            SurfaceSamples()
        }
        //Scaffold脚手架控件基本用法之topBar
        composable(route = RoutePathUtil.SCAFFOLD_TOP_BAR_SAMPLES) {
            ScaffoldTopBarSamples()
        }
        //Scaffold脚手架控件基本用法之bottomBar控件之BottomNavigation
        composable(route = RoutePathUtil.SCAFFOLD_BOTTOM_BAR_SAMPLES) {
            ScaffoldBottomBarSamples()
        }
        //Scaffold之侧滑菜单
        composable(route = RoutePathUtil.SCAFFOLD_MENU_SAMPLES) {
            ScaffoldMenuSamples()
        }
        //BackDropScaffold基本用法
        composable(route = RoutePathUtil.BACK_DROP_SCAFFOLD_SAMPLES) {
            BackDropScaffoldSamples()
        }
        //BottomSheetScaffold之底部滑出菜单基本用法
        composable(route = RoutePathUtil.BOTTOM_SHEET_SCAFFOLD_SAMPLES) {
            BottomSheetScaffoldSamples()
        }
        //Dialog基本用法-可以自己定义布局
        composable(route = RoutePathUtil.DIALOG_SAMPLES) {
            DialogSamples()
        }
        //AlertDialog弹框的基本用法-系统内置的弹窗
        composable(route = RoutePathUtil.ALERTDIALOG_SAMPLES) {
            AlertDialogSamples()
        }
        //Compose中使用XML布局和XML布局中使用Compose的基本用法
        composable(route = RoutePathUtil.COMPOSE_VIEW_SAMPLES) {
            ComposeViewSamples()
        }
        //navigation页面跳转携带参数的基本用法
        composable(route = RoutePathUtil.PAGE_JUMP_SAMPLES) {
            PageJumpSamples()
        }
        composable(route = RoutePathUtil.ANIMATION_SAMPLES) {
            AnimationSamples()
        }
        composable(route = RoutePathUtil.ACCOMPANIST_PAGER) {
            AccompanistPagerSample()
        }
    }
}
