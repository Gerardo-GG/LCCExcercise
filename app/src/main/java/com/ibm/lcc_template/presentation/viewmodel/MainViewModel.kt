package com.ibm.lcc_template.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ibm.lcc_template.domain.MainUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
): ViewModel() {
}