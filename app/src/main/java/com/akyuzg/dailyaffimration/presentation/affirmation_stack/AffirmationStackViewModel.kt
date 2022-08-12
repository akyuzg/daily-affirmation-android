package com.akyuzg.dailyaffimration.presentation.affirmation_stack

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
class AffirmationStackViewModel @Inject constructor(
    private val getDailyAffirmationsUseCase: GetDailyAffirmationsUseCase,
    private val affirmationUseCases: AffirmationUseCases,

    ): ViewModel() {

    private val _state = mutableStateOf(AffirmationStackState())
    val state: State<AffirmationStackState> = _state


    fun onEvent(event: AffirmationEvents){
        when(event) {
            is AffirmationEvents.BookmarkChanged -> {
                affirmationUseCases.updateBookmark(event.affirmation.id, event.affirmation.bookmarked)
            }
            is AffirmationEvents.LikeChanged -> {
                affirmationUseCases.updateLike(event.affirmation.id, event.affirmation.liked)
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