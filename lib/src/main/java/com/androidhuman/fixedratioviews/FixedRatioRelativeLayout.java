/*
 * Copyright (C) 2015 Taeho Kim <jyte82@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.androidhuman.fixedratioviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class FixedRatioRelativeLayout extends RelativeLayout {

    private static final float DEFAULT_ASPECT_RATIO = 0.75f;

    private float aspectRatio = DEFAULT_ASPECT_RATIO;

    public FixedRatioRelativeLayout(Context context) {
        super(context);
        init(context, null);
    }

    public FixedRatioRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FixedRatioRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.FixedRatioViews);
            aspectRatio = arr.getFloat(R.styleable.FixedRatioViews_aspectRatio, DEFAULT_ASPECT_RATIO);
            arr.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = Math.round(width * aspectRatio);
        setMeasuredDimension(width, height);
    }

    public void setAspectRatio(float ratio) {
        aspectRatio = ratio;
        requestLayout();
    }

    public float getAspectRatio() {
        return aspectRatio;
    }
}
