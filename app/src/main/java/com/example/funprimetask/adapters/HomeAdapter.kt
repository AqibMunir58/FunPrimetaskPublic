package com.example.funprimetask.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.funprimetask.databinding.CardRecyclerItemsBinding
import com.example.funprimetask.model.DataResponse

class HomeAdapter(
    val photoList: DataResponse,
    val listener : RecyclerItemClick
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(val binding: CardRecyclerItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardRecyclerItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    interface RecyclerItemClick{
        fun getItem(position : Int )
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.title.text = photoList[position].title
        Glide.with(holder.itemView.context).load(photoList[position].thumbnailUrl).into(holder.binding.thambnail)
        holder.itemView.setOnClickListener {
            listener.getItem(position)
        }

    }
}