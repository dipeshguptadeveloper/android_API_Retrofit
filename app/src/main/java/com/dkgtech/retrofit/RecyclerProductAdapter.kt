package com.dkgtech.retrofit

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerProductAdapter(val context: Context, val arrProduct: List<ProductModel>) :
    RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtBrand = itemView.findViewById<TextView>(R.id.txtBrand)
        val txtRating = itemView.findViewById<TextView>(R.id.txtRating)
        val txtDescription = itemView.findViewById<TextView>(R.id.txtDescription)
        val txtDiscount = itemView.findViewById<TextView>(R.id.txtDiscount)
        val txtPrice = itemView.findViewById<TextView>(R.id.txtPrice)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        val txtStock = itemView.findViewById<TextView>(R.id.txtStock)
        val imgProduct = itemView.findViewById<ImageView>(R.id.imgProduct)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_row, parent, false))
    }

    override fun getItemCount(): Int {
        return arrProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = arrProduct[position]
        holder.txtBrand.text = (product.brand)
        holder.txtRating.text = ("${product.rating}")
        holder.txtDescription.text = (product.description)
        holder.txtDiscount.text = ("- ${product.discountPercentage} %")
        holder.txtPrice.text = ("\u20B9 ${product.price}")
        holder.txtTitle.text = (product.title)
        holder.txtStock.text = ("${product.stock}")
        Glide.with(context).load(Uri.parse(product.thumbnail)).into(holder.imgProduct)

    }
}