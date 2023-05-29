package uz.gita.newsapp.presentation.ui.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.newsapp.R
import uz.gita.newsapp.databinding.DialogChooseLanguageBinding

class ChooseLanguageDialog : DialogFragment(R.layout.dialog_choose_language){
    private var chooseCountryListener: ((String)-> Unit)? = null
    private val binding by viewBinding(DialogChooseLanguageBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        clickEvents()
    }

    private fun clickEvents()= with(binding){
        usa.setOnClickListener{
            chooseCountryListener?.invoke("us")
            dismiss()
        }
        russia.setOnClickListener{
            chooseCountryListener?.invoke("ru")
            dismiss()
        }
        france.setOnClickListener{
            chooseCountryListener?.invoke("fr")
            dismiss()
        }
        india.setOnClickListener{
            chooseCountryListener?.invoke("in")
            dismiss()
        }
        australia.setOnClickListener{
            chooseCountryListener?.invoke("au")
            dismiss()
        }
        gBritain.setOnClickListener{
            chooseCountryListener?.invoke("gb")
            dismiss()
        }
    }

    fun setChooseCountryListener(f: (String)-> Unit){
        chooseCountryListener = f
    }
}