package com.sergeenko.data.utils

class RuntimeBuilder{

    fun build(path: Long?): String {
        if (path == null) {
            return ""
        }
        return path.toString()
    }


}