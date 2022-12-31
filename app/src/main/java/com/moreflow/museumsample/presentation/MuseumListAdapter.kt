package com.moreflow.museumsample.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.moreflow.museumsample.R
import com.moreflow.museumsample.databinding.ItemMuseumListBinding
import com.moreflow.museumsample.entity.ImageRecord

class MuseumListAdapter: ListAdapter<ImageRecord, MuseumListAdapter.ViewHolder>(DIFF_CALLBACK) {
    interface OnItemClickListener {
        fun onItemClick(item: ImageRecord)
    }
    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_museum_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)

        holder.bind(data)
        holder.itemView.setOnClickListener {
            listener?.onItemClick(data)
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemMuseumListBinding.bind(view)

        fun bind(item: ImageRecord) {
            binding.root.setOnClickListener {
            }

            binding.titleTextView.text = item.technique

            Glide.with(binding.imageView.context)
                .load(item.baseimageurl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageView)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImageRecord>() {
            override fun areItemsTheSame(oldItem: ImageRecord, newItem: ImageRecord): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: ImageRecord, newItem: ImageRecord): Boolean =
                oldItem.id == newItem.id
        }
    }
}