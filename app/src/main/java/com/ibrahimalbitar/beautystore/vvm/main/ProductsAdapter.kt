package com.ibrahimalbitar.beautystore.vvm.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimalbitar.beautystore.data.model.ProductsResp.Product
import com.ibrahimalbitar.beautystore.databinding.ProductItemBinding
import com.ibrahimalbitar.beautystore.listener.ProductItemActionsListener

class ProductsAdapter constructor(val listener: ProductItemActionsListener) : RecyclerView.Adapter<MainViewHolder>() {

    var productsList = mutableListOf<Product>()

    fun setMovies(movies: List<Product>) {
        this.productsList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val product = productsList[position]
            holder.binding.name.text = product.name
           Glide.with(holder.itemView.context).load(product.image_link).into(holder.binding.imageview)

            holder.binding.shareFb.setOnClickListener{
                listener.shareProduct(FacebookAppID, product.image_link.toString())
            }

            holder.binding.shareInsta.setOnClickListener{
                listener.shareProduct(InstagramAppID, product.image_link.toString())
            }
        }

    override fun getItemCount(): Int {
        return productsList.size
    }
}

class MainViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

}