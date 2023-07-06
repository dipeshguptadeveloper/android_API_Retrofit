package com.dkgtech.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ApiHelper.create().getQuotes().enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {

                if (response?.code() == 200) {
                    val dataBody = response.body()
                    dataBody?.let {
                        for (quote in response.body()!!.quotes) {
//                        binding.txtQuotes.append("${quote.quote}\n- ${quote.author}\n\n")

                            binding.rcViewQuotes.layoutManager =
                                LinearLayoutManager(this@MainActivity)
                            binding.rcViewQuotes.adapter =
                                RecyclerQuoteAdapter(this@MainActivity, dataBody.quotes)

                        }
                    }

                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                Log.d("Network Error", "${t?.printStackTrace()}")
            }

        })

    }
}