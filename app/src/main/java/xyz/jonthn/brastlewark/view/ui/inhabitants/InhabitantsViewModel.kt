package xyz.jonthn.brastlewark.view.ui.inhabitants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import xyz.jonthn.domain.Inhabitant
import xyz.jonthn.usescases.GetInhabitants

class InhabitantsViewModel(private val getInhabitants: GetInhabitants) : ViewModel(){

    private val _inhabitants = MutableLiveData<List<Inhabitant>>()
    val inhabitants: LiveData<List<Inhabitant>> get() = _inhabitants

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _inhabitants.value = getInhabitants.invoke()
        }
    }
}