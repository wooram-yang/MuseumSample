package com.moreflow.museumsample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moreflow.museumsample.entity.ImageRecord
import com.moreflow.museumsample.usecase.GetGalleryUseCase
import com.moreflow.museumsample.usecase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MuseumListViewModel @Inject constructor(
    private val getGalleryUseCase: GetGalleryUseCase,
    private val getImageUseCase: GetImageUseCase
) : ViewModel() {
    val imageItems: MutableLiveData<ArrayList<ImageRecord>> by lazy {
        MutableLiveData<ArrayList<ImageRecord>>()
    }

    fun getGallery() {
        viewModelScope.launch {
            getGalleryUseCase(Unit).collect {
                Timber.i("데이터 올것인가!")
            }
        }
    }

    fun getImage(page: Int = 0) {
        viewModelScope.launch {
            getImageUseCase(page).collect {
                imageItems.postValue(it.records)
            }
        }
    }
}