package com.example.ebilling

import androidx.lifecycle.ViewModel
import com.example.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository) : ViewModel(), Login {
    private var _isLoginClicked: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val isLoginClicked: Flow<Boolean> = _isLoginClicked

    override fun loginClicked() {
        _isLoginClicked.value = true
        repository.login("", "")
    }
}