package com.sergeenko.data.utils


class PosterPathBuilder{

    private val imageBasePath = "https://image.tmdb.org/t/p/"
    private val originalSize = "original"
    private val w500Size = "w500"

    private var size: Size = Size.w500

    enum class Size{
        w500, original
    }

    fun addSize(size: Size): PosterPathBuilder{
        this.size = size
        return this
    }

    fun build(path: String?): String{
        return buildString {
            append(imageBasePath)
            append(size.name)
            append(path)
        }
    }


}

