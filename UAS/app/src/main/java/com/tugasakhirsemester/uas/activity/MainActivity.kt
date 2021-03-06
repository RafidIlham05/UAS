package com.tugasakhirsemester.uas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tugasakhirsemester.uas.R
import android.content.Intent
import android.widget.Toast
import com.tugasakhirsemester.uas.api.Client
import com.tugasakhirsemester.uas.model.Indonesia
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        btnProvince.setOnClickListener{
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun showIndonesia(){ // untuk menampilkan data
        Client.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<Indonesia>> {

            override fun onFailure(call: Call<ArrayList<Indonesia>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<Indonesia>>,
                response: Response<ArrayList<Indonesia>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitilized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal
                
                // berisi variable yang akan menampung nilai – niali yang akan dipanggil
                
                tvPositive.text = positive
                tvHospitalized.text = hospitilized
                tvRecover.text = recover
                tvDeath.text = death
            }

        })
    }
}
