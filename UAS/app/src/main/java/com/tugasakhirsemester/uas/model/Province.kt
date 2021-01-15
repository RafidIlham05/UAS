package com.tugasakhirsemester.uas.model
import com.google.gson.annotations.SerializedName

data class Province(
    @SerializedName("Kode_Provi")
    val code: Int,
    @SerializedName("Provinsi")
    val province: String,
    @SerializedName("Kasus_Posi")
    val positive: Int,
    @SerializedName("Kasus_Semb")
    val recover: Int,
    @SerializedName("Kasus_Meni")
    val death: Int
) // berisi variabel dari api, menggunakan SerializedName karena pada api menggunakan awal huruf kapital dan tidak sesuai kaidah kothlin
