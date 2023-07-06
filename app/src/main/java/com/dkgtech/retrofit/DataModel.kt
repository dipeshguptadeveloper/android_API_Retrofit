package com.dkgtech.retrofit

data class DataModel(
    val quotes: List<QuoteModel>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

data class QuoteModel(
    val id: Int,
    val quote: String,
    val author: String

)
