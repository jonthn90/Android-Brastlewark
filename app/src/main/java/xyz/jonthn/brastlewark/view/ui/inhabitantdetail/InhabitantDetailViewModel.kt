package xyz.jonthn.brastlewark.view.ui.inhabitantdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.jonthn.domain.Inhabitant
import xyz.jonthn.usescases.FindInhabitantById

class InhabitantDetailViewModel(
    private val inhabitantId: Int,
    private val findInhabitantById: FindInhabitantById
) : ViewModel() {

    private val _inhabitant = MutableLiveData<Inhabitant>()
    val inhabitant: LiveData<Inhabitant> get() = _inhabitant

    init {
        viewModelScope.launch {

            _inhabitant.value = findInhabitantById.invoke(inhabitantId)
        }
    }

}