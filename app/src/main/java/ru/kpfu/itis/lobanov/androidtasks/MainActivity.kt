package ru.kpfu.itis.lobanov.androidtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import ru.kpfu.itis.lobanov.androidtasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var result: Double? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSavedValues(savedInstanceState)
        initETListeners()
        initButtonListener()
    }

    private fun initETListeners() { // composite method
        initETNameInputListener()
        initETHeightListener()
        initETWeightListener()
        initETAgeListener()
    }

    private fun initButtonListener() {
        val clickButton: Button? = findViewById(R.id.button)
        clickButton?.setOnClickListener {
            result = calcResult()
            setState()
        }
    }

    private fun calcResult(): Double? {
        with(binding) {
            val name: String = etNameInput.text.toString()
            val height: Int? = etHeightInput.text.toString().toIntOrNull()
            val weight: Double? = etWeightInput.text.toString().toDoubleOrNull()
            val age: Int? = etAgeInput.text.toString().toIntOrNull()
            if (name.isEmpty() || height == null || weight == null || age == null) {
                return null
            }
            if (name.length > MAX_LENGTH || height <= MIN_INT_VAL || height >= MAX_HEIGHT_VAL ||
                weight <= MIN_WEIGHT_VAL || weight >= MAX_WEIGHT_VAL ||
                age <= MIN_INT_VAL || age >= MAX_AGE) {
                return null
            }
            return name.length + height + weight + age
        }
    }

    private fun setState() {
        val text = binding.info
        if (result == null || result == 0.0) {
            text.text = "Данные введены некорректно"
        } else {
            text.text = "Ответ: $result"
        }
    }

    private fun initSavedValues(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            result = savedInstanceState.getDouble("RESULT_ARG")
            setState()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        result?.let { outState.putDouble("RESULT_ARG", it) }
    }

    private fun initETNameInputListener() {
        with(binding) {
            etNameInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (etNameInput.text.isNullOrEmpty()) {
                        binding.etNameInput.error = "Введите имя"
                    } else {
                        if (etNameInput.text.toString().length > MAX_LENGTH) {
                            binding.etNameInput.error = "Имя введено некорректно"
                        } else binding.etNameInput.error = null
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
        }
    }

    private fun initETHeightListener() {
        with(binding) {
            etHeightInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (etHeightInput.text.isNullOrEmpty()) {
                        binding.etHeightInput.error = "Введите рост"
                    } else {
                        if (etHeightInput.text.toString().toInt() !in MIN_INT_VAL..MAX_HEIGHT_VAL) {
                            binding.etHeightInput.error = "Рост введён некорректно"
                        } else binding.etHeightInput.error = null
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
        }
    }

    private fun initETWeightListener() {
        with(binding) {
            etWeightInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (etWeightInput.text.isNullOrEmpty()) {
                        binding.etWeightInput.error = "Введите вес"
                    } else {
                        if (etWeightInput.text.toString()
                                .toDouble() !in MIN_WEIGHT_VAL..MAX_WEIGHT_VAL
                        ) {
                            binding.etWeightInput.error = "Вес введён некорректно"
                        } else binding.etWeightInput.error = null
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
        }
    }

    private fun initETAgeListener() {
        with(binding) {
            etAgeInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (etAgeInput.text.isNullOrEmpty()) {
                        binding.etAgeInput.error = "Введите возраст"
                    } else {
                        if (etAgeInput.text.toString().toInt() !in MIN_INT_VAL..MAX_AGE) {
                            binding.etAgeInput.error = "Возраст введён некорректно"
                        } else binding.etAgeInput.error = null
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
        }
    }

    companion object {
        private const val MIN_INT_VAL = 0
        private const val MIN_WEIGHT_VAL = 0.0
        private const val MAX_LENGTH = 50
        private const val MAX_AGE = 150
        private const val MAX_HEIGHT_VAL = 250
        private const val MAX_WEIGHT_VAL = 250.0
    }
}
