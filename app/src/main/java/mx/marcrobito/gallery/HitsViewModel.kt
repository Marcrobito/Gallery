package mx.marcrobito.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitsViewModel(private val repository:Repository = RepositoryImpl() ):ViewModel() {
    private val _hits = MutableLiveData<List<Hit>>(listOf())
    val hits: LiveData<List<Hit>> get() = _hits

    fun getHits(image:String = "cat"){
        viewModelScope.launch {
            _hits.value = withContext(Dispatchers.IO){
                repository.getHitsList(image)
            }
        }
    }

}