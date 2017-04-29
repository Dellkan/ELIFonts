package com.dellkan.elifonts.sample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dellkan.elifonts.FontHook;
import com.dellkan.enhanced_layout_inflater.ELIConfig;
import com.dellkan.enhanced_layout_inflater.ELIContextWrapper;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void attachBaseContext(Context newBase) {
		super.attachBaseContext(new ELIContextWrapper(newBase, new ELIConfig.Builder()
				.addHook(new FontHook("fonts/grand_stylus.ttf"))
				.enablePostCallbacks()
				.build()));
	}
}
