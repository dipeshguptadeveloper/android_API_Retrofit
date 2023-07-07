package com.dkgtech.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.retrofit.databinding.ActivityProductsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiHelper.create().getProducts().enqueue(object : Callback<MainModel> {
            override fun onResponse(call: Call<MainModel>?, response: Response<MainModel>?) {
                if (response?.code() == 200) {
                    binding.rcViewProducts.layoutManager =
                        LinearLayoutManager(this@ProductsActivity)
                    binding.rcViewProducts.adapter =
                        RecyclerProductAdapter(this@ProductsActivity, response.body()!!.products)
                }
            }

            override fun onFailure(call: Call<MainModel>?, t: Throwable?) {
                Toast.makeText(this@ProductsActivity, "Network Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}