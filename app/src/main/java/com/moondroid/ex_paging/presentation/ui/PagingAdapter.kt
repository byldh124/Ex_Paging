package com.moondroid.ex_paging.presentation.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.moondroid.ex_paging.data.Data

class PagingAdapter:  PagingDataAdapter<Data, PagingViewHolder>(diffCallback){

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        TODO("Not yet implemented")
    }

}

class PagingViewHolder(

): RecyclerView.ViewHolder(binding.root) {


}