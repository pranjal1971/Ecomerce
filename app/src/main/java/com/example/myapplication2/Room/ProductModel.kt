package com.example.myapplication2.Room

import android.security.identity.AccessControlProfileId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "products")
data class ProductModel(
    @PrimaryKey
    @NotNull
    val productId: String,

    @ColumnInfo(name="product_name")
    val product_name: String?,

    @ColumnInfo(name="productCoverimg")
    val productCoverimg: String? ,

    @ColumnInfo(name="product_sp")
    val product_sp: String? ,




)
