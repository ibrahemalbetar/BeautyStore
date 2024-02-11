package com.ibrahimalbitar.beautystore.data.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel

@Parcelize
class ProductsResp : ArrayList<ProductsResp.Product>(), Parcelable {
    @Parcelize
    @Entity(tableName = "products")
    data class Product(
        @ColumnInfo(name = "name")val name: String?, @ColumnInfo(name = "image_link") val image_link: String?,
        @ColumnInfo(name = "price") val price: String? ="0") : Parcelable{
        @IgnoredOnParcel
        @PrimaryKey(autoGenerate = true)
        var id = 0
    }
}