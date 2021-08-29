package com.helicoptera.android.view.authorization.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicoptera.togerio.authorization.validation.PasswordValidator
import com.helicoptera.togerio.authorization.validation.UsernameValidator

class RegistrationViewModel : ViewModel() {

    private val usernameValidator = UsernameValidator()
    private val passwordValidator = PasswordValidator()

    private val _username = MutableLiveData("")
    var username: MutableLiveData<String>
        get() = _username
        set(value) {
            _username.value = value.value
        }

    private val _password = MutableLiveData("")
    var password: MutableLiveData<String>
        get() = _password
        set(value) {
            _password.value = value.value
        }

    private val _passwordRepetition = MutableLiveData("")
    var passwordRepetition: MutableLiveData<String>
        get() = _passwordRepetition
        set(value) {
            _passwordRepetition.value = value.value
        }

    private val _navigateToContent = MutableLiveData(false)
    val navigateToContent: LiveData<Boolean>
        get() = _navigateToContent

    fun onNavigateToContent() {
        _navigateToContent.value = false
    }

    fun onRegistrationClick() {
        val userNameValidationResult = usernameValidator.validateUsername(_username.value)
        if (userNameValidationResult.valid) {
            val passwordValidationResult = passwordValidator.validatePassword(_password.value)
            if (passwordValidationResult.valid) {
                if (_password.value == _passwordRepetition.value) {
                    _navigateToContent.value = true
                }
            }
        }
    }
}