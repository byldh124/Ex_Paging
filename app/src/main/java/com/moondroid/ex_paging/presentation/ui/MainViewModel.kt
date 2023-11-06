package com.moondroid.ex_paging.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.moondroid.ex_paging.data.Data
import com.moondroid.ex_paging.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    fun getData(): Flow<PagingData<Data>> {
        return repository.getData().cachedIn(viewModelScope)
    }
}