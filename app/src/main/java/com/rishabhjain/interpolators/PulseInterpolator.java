package com.rishabhjain.interpolators;

import android.view.animation.Interpolator;

public final class PulseInterpolator implements Interpolator {

    private final int duration;
    private final int offFor;
    public PulseInterpolator(int onFor, int offFor) {
        this.duration = onFor + offFor + 2;
        this.offFor = offFor;
    }

    @Override
    public float getInterpolation(float v) {
        v *= duration;
        if (v > 1) {
            v = duration - v - offFor;
        }
        return Math.max(0, Math.min(1, v));
    }
}
