package com.moondroid.ex_paging.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.moondroid.ex_paging.data.Data
import com.moondroid.ex_paging.databinding.ItemSampleBinding

class PagingAdapter:  PagingDataAdapter<Data, PagingViewHolder>(diffCallback){
    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(ItemSampleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class PagingViewHolder(
    private val binding: ItemSampleBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.data = data
        binding.executePendingBindings()
    }
}