package com.moondroid.ex_paging.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
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
    val pagingData = repository.getData("1").cach
    var data: Flow<PagingData<Data>>
    fun getData() {
        viewModelScope.launch {
            repository.getData("1").collect {
                Log.e("TAG", "list: $it")
            }
        }
    }
}