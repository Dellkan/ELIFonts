package com.dellkan.elifonts;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public final class ELIFontsUtils {
	private static Map<String, Typeface> loadedFonts = new HashMap<>();
	private ELIFontsUtils() {}

	public static Typeface loadFont(Context context, String path) {
		if (!loadedFonts.containsKey(path)) {
			loadedFonts.put(path, Typeface.createFromAsset(context.getAssets(), path));
		}
		return loadedFonts.get(path);
	}

	public static void applyFont(TextView view, Typeface typeface) {
		if (view == null || typeface == null) return;
		view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
		view.setTypeface(typeface);
	}
}
