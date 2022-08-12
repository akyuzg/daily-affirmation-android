package com.akyuzg.dailyaffimration.presentation.affirmations

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akyuzg.dailyaffimration.common.Resource
import com.akyuzg.dailyaffimration.domain.usecase.*
import com.akyuzg.dailyaffimration.domain.usecase.affirmation.AffirmationUseCases
import com.akyuzg.dailyaffimration.domain.usecase.affirmation.GetDailyAffirmationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AffirmationsViewModel @Inject constructor(
    private val getDailyAffirmationsUseCase: GetDailyAffirmationsUseCase,
    private val affirmationUseCases: AffirmationUseCases,

    ): ViewModel() {

    private val _state = mutableStateOf(AffirmationsState())
    val state: State<AffirmationsState> = _state


    fun onEvent(event: AffirmationEvent){
        when(event) {
            is AffirmationEvent.BookmarkChanged -> {
                affirmationUseCases.updateBookmark(event.affirmation.id, event.selected)
            }
            is AffirmationEvent.LikeChanged -> {
                affirmationUseCases.updateLike(event.affirmation.id, event.selected)
            }
        }
    }


    init {
        getAffirmations()
    }

    private fun getAffirmations(){
        getDailyAffirmationsUseCase().onEach { result->
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
                is Resource.Message -> {
                    _state.value = AffirmationsState(message = result.message ?: "Unexpected message")
                }
            }

        }.launchIn(viewModelScope)
    }

}