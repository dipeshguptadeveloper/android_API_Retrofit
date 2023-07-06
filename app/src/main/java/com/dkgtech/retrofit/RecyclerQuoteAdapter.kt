package com.dkgtech.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerQuoteAdapter(val context: Context, val arrQuote: List<QuoteModel>) :
    RecyclerView.Adapter<RecyclerQuoteAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtQuote = itemView.findViewById<TextView>(R.id.txtQuote)
        val txtAuthor = itemView.findViewById<TextView>(R.id.txtAuthor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.quote_row, parent, false))
    }

    override fun getItemCount(): Int {
        return arrQuote.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtQuote.append(arrQuote[position].quote)
        holder.txtAuthor.append(arrQuote[position].author)

//        holder.txtQuote.text = arrQuote[position].quote
//        holder.txtAuthor.text = arrQuote[position].author
    }
}