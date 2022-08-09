package com.akyuzg.dailyaffimration.presentation.affirmation_stack

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akyuzg.dailyaffimration.common.Resource
import com.akyuzg.dailyaffimration.domain.usecase.GetDailyAffirmationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getDailyAffirmationsUseCase: GetDailyAffirmationsUseCase,
): ViewModel() {

    private val _state = mutableStateOf(AffirmationStackState())
    val state: State<AffirmationStackState> = _state


    init {
        getAffirmations()
    }

    private fun getAffirmations(){
        getDailyAffirmationsUseCase().onEach { result->
            when(result){
                is Resource.Success -> {
                    _state.value = AffirmationStackState(affirmations = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = AffirmationStackState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = AffirmationStackState(
                        error = result.message ?: "An unexpected error occured.."
                    )
                }
                is Resource.Message -> {
                    _state.value = AffirmationStackState(message = result.message ?: "Unexpected message")
                }
            }

        }.launchIn(viewModelScope)
    }




}