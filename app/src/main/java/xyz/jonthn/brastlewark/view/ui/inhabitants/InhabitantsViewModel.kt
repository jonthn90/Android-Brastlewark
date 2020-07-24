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
import xyz.jonthn.usescases.SearchByName

class InhabitantsViewModel(
    private val getInhabitants: GetInhabitants,
    private val searchByName: SearchByName
) : ViewModel() {

    private val _inhabitants = MutableLiveData<List<Inhabitant>>()
    val inhabitants: LiveData<List<Inhabitant>> get() = _inhabitants

    private val _navigateToInhabitant = MutableLiveData<Event<Int>>()
    val navigateToInhabitant: LiveData<Event<Int>> get() = _navigateToInhabitant

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _loading.value = true
            _inhabitants.value = getInhabitants.invoke()
            _loading.value = false
        }
    }

    fun onInhabitantClicked(inhabitant: Inhabitant) {
        Timber.d("$inhabitant")
        _navigateToInhabitant.value = Event(inhabitant.id)
    }

    fun searchByName(name: String) {
        viewModelScope.launch {
            _loading.value = true
            _inhabitants.value = searchByName.invoke(name)
            _loading.value = false
        }
    }
}