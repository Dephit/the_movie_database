package com.sergeenko.themoviedatabase.utils

import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

class ShimmerDrawable {

    companion object{

        private val shimmer
            get() = Shimmer.AlphaHighlightBuilder()
                .setDuration(1500)
                .setBaseAlpha(0.95f)
                .setHighlightAlpha(0.85f)
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .setAutoStart(true)
                .build()

        val shimmerDrawable
            get() = ShimmerDrawable().apply {
                setShimmer(shimmer)
            }
    }
}