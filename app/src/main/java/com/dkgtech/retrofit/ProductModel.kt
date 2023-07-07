package com.dkgtech.retrofit

data class MainModel(
    val products: List<ProductModel>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

data class ProductModel(
    val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)
