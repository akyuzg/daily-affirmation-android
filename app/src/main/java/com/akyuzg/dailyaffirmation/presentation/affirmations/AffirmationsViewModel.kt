package com.akyuzg.dailyaffirmation.presentation.affirmations

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akyuzg.dailyaffirmation.common.Resource
import com.akyuzg.dailyaffirmation.domain.usecase.affirmation.AffirmationUseCases
import com.akyuzg.dailyaffirmation.domain.usecase.affirmation.GetDailyAffirmationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AffirmationsViewModel @Inject constructor(
    private val affirmationUseCases: AffirmationUseCases,
    private val getDailyAffirmations: GetDailyAffirmationsUseCase,
): ViewModel() {

    private val _state = mutableStateOf(AffirmationsState())
    val state: State<AffirmationsState> = _state


    fun onEvent(e: AffirmationEvent){
        when(e) {
            is AffirmationEvent.BookmarkChanged -> affirmationUseCases.updateBookmark(e.affirmation).launchIn(viewModelScope)
            is AffirmationEvent.LikeChanged     -> affirmationUseCases.updateLike(e.affirmation).launchIn(viewModelScope)
        }
    }

    init {
        getAffirmations()
    }

    private fun getAffirmations(){
        getDailyAffirmations().onEach { result->
            when(result){
                is Resource.Success -> {
                    _state.value = AffirmationsState(affirmations = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = AffirmationsState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = AffirmationsState(
                        error = result.message ?: "An unexpected error occured.."
                    )
                }
            }

        }.launchIn(viewModelScope)
    }

}