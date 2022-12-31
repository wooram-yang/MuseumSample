package com.moreflow.museumsample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.moreflow.museumsample.R
import com.moreflow.museumsample.databinding.ActivityDetailBinding
import timber.log.Timber

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private var url: String = ""
    private var desc: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        url = intent.getStringExtra("URL") ?: ""
        desc = intent.getStringExtra("DESC") ?: ""

        setupUI()
        setupDataBinding()
    }

    private fun setupUI() {
        Glide.with(binding.imageView.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .skipMemoryCache(true)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imageView)
    }

    private fun setupDataBinding() {
    }
}