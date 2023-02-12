package base

import androidx.lifecycle.ViewModel
import com.example.domain.repository.PrefRepository
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var prefRepository: PrefRepository

    fun saveValueToPref(key: String, value: Any?) = prefRepository.save(key, value)

    fun getStringValueFromPref(key: String): String? = prefRepository.getString(key)

    fun removeFromPref(key: String) = prefRepository.removeFromPref(key)

    fun clearPref() = prefRepository.clearPref()
}