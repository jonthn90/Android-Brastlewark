package xyz.jonthn.brastlewark.view.ui.inhabitants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber
import xyz.jonthn.brastlewark.common.Event
import xyz.jonthn.domain.Inhabitant
import xyz.jonthn.usescases.GetInhabitants

class InhabitantsViewModel(private val getInhabitants: GetInhabitants) : ViewModel() {

    private val _inhabitants = MutableLiveData<List<Inhabitant>>()
    val inhabitants: LiveData<List<Inhabitant>> get() = _inhabitants

    private val _navigateToInhabitant = MutableLiveData<Event<Int>>()
    val navigateToInhabitant: LiveData<Event<Int>> get() = _navigateToInhabitant

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _inhabitants.value = getInhabitants.invoke()
            //Timber.d("${_inhabitants.value}")
        }
    }

    fun onInhabitantClicked(inhabitant: Inhabitant) {
        Timber.d("$inhabitant")
        _navigateToInhabitant.value = Event(inhabitant.id)
    }
}