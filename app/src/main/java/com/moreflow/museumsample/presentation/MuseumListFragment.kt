package com.moreflow.museumsample.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.moreflow.museumsample.databinding.FragmentMuseumListBinding
import com.moreflow.museumsample.entity.ImageRecord
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuseumListFragment : Fragment() {
    private lateinit var binding: FragmentMuseumListBinding
    private val viewModel: MuseumListViewModel by viewModels()
    private val adapter: MuseumListAdapter = MuseumListAdapter()

    private var page: Int = 1
    private var isItFirstLoad: Boolean = true
    private var isItEndOfDatas: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuseumListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this)[MuseumListViewModel::class.java]

        setupUI()
        setupDataBinding()
    }

    private fun setupUI() {
        val newLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.layoutManager = newLayoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setOnScrollChangeListener { _, _, _, _, _ ->
            val visibleItemCount = newLayoutManager.childCount
            val totalItemCount = newLayoutManager.itemCount
            val pastVisiblesItems = newLayoutManager.findFirstVisibleItemPosition()

            if ((visibleItemCount + pastVisiblesItems) >= totalItemCount && !isItEndOfDatas) {
                showLoading()

                viewModel.getImage(++page)
            }
        }

        adapter.setOnItemClickListener(object: MuseumListAdapter.OnItemClickListener {
            override fun onItemClick(item: ImageRecord) {
//                findNavController().navigate(
//                    MuseumListFragmentDirections.actionMuseumListFragmentToMuseumDetailFragment(
//                        item.baseimageurl,
//                        item.technique
//                    )
//                )

                startActivity(Intent(requireContext(), DetailActivity::class.java).apply {
                    putExtra("URL", item.baseimageurl)
                    putExtra("DESC", item.technique)
                })
            }
        })
    }

    private fun setupDataBinding() {
        val imageItemsObserver = Observer<ArrayList<ImageRecord>> { imageRecords ->
            isItEndOfDatas = imageRecords.size == 0

            adapter.submitList(adapter.currentList + imageRecords)

            hideLoading()
        }
        viewModel.imageItems.observe(viewLifecycleOwner, imageItemsObserver)

        if(adapter.currentList.size == 0) {
            showLoading()

            viewModel.getImage(page)
        }
    }

    private fun showLoading() {
        binding.spinView.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.spinView.visibility = View.INVISIBLE
    }
}