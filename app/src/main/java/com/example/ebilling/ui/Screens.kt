package com.example.ebilling.ui

sealed class Screens(val screenName: String) {
    class DashboardScreen() : Screens("Dashboard")
    class RegisterProductScreen() : Screens("Register Product")
    class EditProductScreen() : Screens("Edit Product")
    class DeleteProductScreen() : Screens("Delete Product")
    class SearchProductScreen() : Screens("Search Product")
}