package com.moreflow.museumsample.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.moreflow.museumsample.R
import com.moreflow.museumsample.databinding.FragmentMuseumDetailBinding

class MuseumDetailFragment : Fragment() {
    private lateinit var binding: FragmentMuseumDetailBinding

    private val args: MuseumDetailFragmentArgs by navArgs()
    private val url by lazy(LazyThreadSafetyMode.NONE) { args.url }
    private val desc by lazy(LazyThreadSafetyMode.NONE) { args.desc }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuseumDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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