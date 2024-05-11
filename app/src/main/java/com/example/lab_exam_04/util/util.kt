package com.example.lab_exam_04.util

import android.app.Dialog
import android.widget.LinearLayout

fun Dialog.setupDialog(layoutResId:Int){
    setContentView(layoutResId)
    window!!.setLayout(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    setCancelable(false)
}