package com.sunpra.memories.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunpra.memories.data.Repository
import com.sunpra.memories.data.ServiceProvider
import com.sunpra.memories.model.RegistrationBody
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {

    private val repository: Repository = Repository(ServiceProvider.memoriesService)

    private val _uiState = MutableStateFlow(RegistrationUIState())
    val uiState = _uiState.asStateFlow()

    private val _message = MutableStateFlow<String?>(null)
    val message = _message.asStateFlow()

    fun clearMessage() {
        _message.update { null }
    }

    fun onNameChanged(value: String) {
        _uiState.update { oldState ->
            oldState.copy(name = value)
        }
    }

    fun onEmailChanged(value: String) {
        _uiState.update { oldState ->
            oldState.copy(email = value)
        }
    }

    fun onPasswordChanged(value: String) {
        _uiState.update { oldState ->
            oldState.copy(password = value)
        }
    }

    fun onConfirmPasswordChanged(value: String) {
        _uiState.update { oldState ->
            oldState.copy(confirmPassword = value)
        }
    }

    fun onSubmitBtnClicked() {
        val uiState = _uiState.value
        val registrationBody = RegistrationBody(
            name = uiState.name,
            email = uiState.email,
            password = uiState.password,
            confirmPassword = uiState.confirmPassword
        )
        viewModelScope.launch {
            val result: Result<String> = repository.registerUser(registrationBody)
            if (result.isSuccess) {
                // Navigate to home screen
            }else{
                _message.update {
                    result.exceptionOrNull()?.message ?: "Registration failed"
                }
            }
        }
    }
}


data class RegistrationUIState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)

