package com.sergeenko.themoviedatabase.utils

import android.os.Build
import android.os.Bundle
import java.io.Serializable

class BundleSerializableExtractor {

     companion object{
         inline fun<reified T: Serializable> extractValue(bundle: Bundle?, tag: String): T?{
             val value = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                 bundle?.getSerializable(tag, T::class.java)
             } else {
                 bundle?.getSerializable(tag)
             }
            return value as T?
         }
     }
}