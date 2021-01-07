package com.tugasakhirsemester.uas.api


import com.tugasakhirsemester.uas.model.Indonesia
import com.tugasakhirsemester.uas.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<Indonesia>>

    @GET("indonesia/provinsi")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}