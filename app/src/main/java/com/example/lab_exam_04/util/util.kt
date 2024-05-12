package com.example.lab_exam_04.util

import android.app.Dialog
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputEditText

fun Dialog.setupDialog(layoutResId:Int){
    setContentView(layoutResId)
    window!!.setLayout(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    setCancelable(false)
}

//validate the text editings
fun validateEditText(editText:EditText, textTextInputLayout: TextInputEditText):Boolean{
    return when{
        editText.text.toString().trim().isEmpty() ->{
            editText.error = "Required"
            false
        }else -> {
            textTextInputLayout.error = null
            true
        }
    }
}