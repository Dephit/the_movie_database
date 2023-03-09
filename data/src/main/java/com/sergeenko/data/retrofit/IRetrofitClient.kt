package com.sergeenko.data.retrofit

interface IRetrofitClient{

    fun<T> create(java: Class<T>): T
}