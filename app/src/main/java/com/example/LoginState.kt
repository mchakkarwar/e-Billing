package com.example

sealed interface LoginState {
    interface UsernameEntered : LoginState
    interface PasswordEntered : LoginState
    interface UsernameValid : LoginState
    interface PasswordValid : LoginState
}