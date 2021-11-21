package com.example.aula2_iesb_lodjinha.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.lodjinha.repositories.LodjinhaRepository
import br.com.lodjinha.ui.viewmodels.MainViewModel

class MainViewModelProvideFactory(
    private val repository: LodjinhaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
