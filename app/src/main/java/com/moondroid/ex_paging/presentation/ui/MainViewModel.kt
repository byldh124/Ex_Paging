package com.moondroid.ex_paging.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moondroid.ex_paging.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    fun getData() {
        viewModelScope.launch {
            repository.getData("1").collect {
                Log.e("TAG", "list: $it")
            }
        }
    }
}