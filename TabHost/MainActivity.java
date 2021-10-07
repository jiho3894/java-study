package com.example.tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41730015 B반 김지호");

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("Dog").setIndicator("강아지");
        tabSpecDog.setContent(R.id.tabDog);
        tabHost.addTab(tabSpecDog);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("Cat").setIndicator("고양이");
        tabSpecCat.setContent(R.id.tabCat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecRabbit = tabHost.newTabSpec("Rabbit").setIndicator("토끼");
        tabSpecRabbit.setContent(R.id.tabRabbit);
        tabHost.addTab(tabSpecRabbit);

        TabHost.TabSpec tabSpecPi = tabHost.newTabSpec("Pi").setIndicator("파이");
        tabSpecPi.setContent(R.id.tabPi);
        tabHost.addTab(tabSpecPi);

        tabHost.setCurrentTab(0);

    }
}