package com.example.lab_exam_04

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.lab_exam_04.databinding.ActivityMainBinding
import com.example.lab_exam_04.util.setupDialog

class MainActivity : AppCompatActivity() {

    private val mainBinding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val addTaskDialogBox : Dialog by lazy {
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.add_task_dialog)
        }
    }

    private val updateTaskDialogBox : Dialog by lazy {
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.update_task_dialog)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val addCloseImgBtn = addTaskDialogBox.findViewById<ImageView>(R.id.closeImg)
        val updateCloseImgBtn = updateTaskDialogBox.findViewById<ImageView>(R.id.closeImg)

        addCloseImgBtn.setOnClickListener { addTaskDialogBox.dismiss() }
        updateCloseImgBtn.setOnClickListener { updateTaskDialogBox.dismiss() }

        mainBinding.addTaskFABtn.setOnClickListener {
            addTaskDialogBox.show()
        }
    }
}