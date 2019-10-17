package com.example.zhpan.circleviewpager.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.zhpan.circleviewpager.R;
import com.example.zhpan.circleviewpager.viewholder.SlideModeViewHolder;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.enums.IndicatorSlideMode;
import com.zhpan.bannerview.enums.IndicatorStyle;
import com.zhpan.bannerview.utils.DpUtils;

import java.util.Arrays;
import java.util.List;

public class IndicatorStyleActivity extends AppCompatActivity {
    private String[] picUrls = {"http://pic31.nipic.com/20130801/11604791_100539834000_2.jpg",
            "http://pic37.nipic.com/20140115/7430301_100825571157_2.jpg",
            "http://pic29.nipic.com/20130507/8952533_183922555000_2.jpg",
            "http://b-ssl.duitang.com/uploads/item/201706/10/20170610095055_G5LM8.jpeg"};
    private BannerViewPager<String, SlideModeViewHolder> mViewPagerSmoothSlide;
    private List<String> mList;

    private BannerViewPager<String, SlideModeViewHolder> mViewPagerNormalSlide;

    private BannerViewPager<String, SlideModeViewHolder> mViewPagerDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_slide_mode);
        setTitle(getString(R.string.indicator_style));
        mList = Arrays.asList(picUrls);
        initCircleNormalSlide();
        initCircleSmoothSlide();
        initDashIndicator();
    }

    private void initDashIndicator() {
        mViewPagerDash = findViewById(R.id.banner_view_dash);
        mViewPagerDash.setAutoPlay(true).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorGap(DpUtils.dp2px(5))
                .setScrollDuration(1000)
                .setIndicatorHeight(DpUtils.dp2px(2.5f))
                .setIndicatorStyle(IndicatorStyle.DASH)
                .setIndicatorWidth(DpUtils.dp2px(10),DpUtils.dp2px(5))
                .setHolderCreator(SlideModeViewHolder::new)
                .setIndicatorColor(Color.parseColor("#888888"),
                        Color.parseColor("#118EEA")).create(mList);
    }

    private void initCircleSmoothSlide() {
        mViewPagerSmoothSlide = findViewById(R.id.banner_view);
        mViewPagerSmoothSlide.setAutoPlay(true).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorGap(DpUtils.dp2px(7))
                .setScrollDuration(1000)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
                .setIndicatorRadius(DpUtils.dp2px(6), DpUtils.dp2px(7))
                .setHolderCreator(SlideModeViewHolder::new)
                .setIndicatorColor(Color.parseColor("#935656"),
                        Color.parseColor("#CCFF4C39")).create(mList);
    }

    private void initCircleNormalSlide() {
        mViewPagerNormalSlide = findViewById(R.id.banner_view_normal_slide);
        mViewPagerNormalSlide.setAutoPlay(true).setCanLoop(true)
                .setRoundCorner(DpUtils.dp2px(5))
                .setIndicatorGap(DpUtils.dp2px(7))
                .setScrollDuration(1000)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setIndicatorWidth(DpUtils.dp2px(8))
                .setIndicatorSlideMode(IndicatorSlideMode.NORMAL)
                .setHolderCreator(SlideModeViewHolder::new)
                .setIndicatorColor(Color.parseColor("#888888"),
                        Color.parseColor("#118EEA")).create(mList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPagerSmoothSlide.stopLoop();
        mViewPagerNormalSlide.stopLoop();
        mViewPagerDash.stopLoop();
    }
}