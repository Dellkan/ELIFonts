package com.dellkan.elifonts;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class ELIFontsTypeSpan extends MetricAffectingSpan {
	private final Typeface typeface;

	public ELIFontsTypeSpan(@NonNull Typeface typeface) {
		if (typeface == null) {
			throw new IllegalArgumentException("typeface is null");
		}

		this.typeface = typeface;
	}

	@Override
	public void updateMeasureState(TextPaint drawState) {
		apply(drawState);
	}

	@Override
	public void updateDrawState(TextPaint drawState) {
		apply(drawState);
	}

	private void apply(final Paint paint) {
		final Typeface oldTypeface = paint.getTypeface();
		final int oldStyle = oldTypeface != null ? oldTypeface.getStyle() : 0;
		final int fakeStyle = oldStyle & ~typeface.getStyle();

		if ((fakeStyle & Typeface.BOLD) != 0) {
			paint.setFakeBoldText(true);
		}

		if ((fakeStyle & Typeface.ITALIC) != 0) {
			paint.setTextSkewX(-0.25f);
		}

		paint.setTypeface(typeface);
	}
}
