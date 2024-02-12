package com.example.balanse.presentation.features.auth.viewModels

import androidx.lifecycle.ViewModel
import com.example.balanse.domain.usecases.auth.GetFirstLoginStatusUseCase
import com.example.balanse.presentation.features.auth.state.FirstLoginStatusState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.balanse.domain.usecases.auth.MarkFirstLoginStatusUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getFirstLoginStatusUseCase: GetFirstLoginStatusUseCase,
    private val markFirstLoginStatusUseCase: MarkFirstLoginStatusUseCase
) : ViewModel(){
    private val _firstLoginStatusState = MutableStateFlow(FirstLoginStatusState())
    val firstLoginStatusState = _firstLoginStatusState

    fun getFirstLoginStatus() {
        _firstLoginStatusState.value = FirstLoginStatusState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val result = getFirstLoginStatusUseCase.execute(Unit)
            if (result.data != false){
                markFirstLoginStatusUseCase.execute(Unit)
            }
            _firstLoginStatusState.value = FirstLoginStatusState(isLoading = false, isFirstLogin = result.data ?: false)
        }
    }
}