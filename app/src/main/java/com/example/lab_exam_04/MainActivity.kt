package com.example.lab_exam_04

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ImageView
import com.example.lab_exam_04.databinding.ActivityMainBinding
import com.example.lab_exam_04.util.setupDialog
import com.example.lab_exam_04.util.validateEditText
import com.google.android.material.textfield.TextInputEditText

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

    private val loadingDialog : Dialog by lazy {
        Dialog(this,R.style.DialogCustomTheme).apply {
            setupDialog(R.layout.loading_dialog)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        val addCloseImgBtn = addTaskDialogBox.findViewById<ImageView>(R.id.closeImg)


        addCloseImgBtn.setOnClickListener { addTaskDialogBox.dismiss() }

        val addEDTitle = addTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskTitle)
        val addEDTitleL = addTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskTitleL)

        addEDTitle.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){}
            override fun onTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){}
            override fun afterTextChanged(s: Editable){
                validateEditText(addEDTitle,addEDTitleL)
            }
        })

        val addETDesc = updateTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskDesc)
        val addETDescL = updateTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskDescL)

        addETDesc.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){ }
            override fun onTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){ }
            override fun afterTextChanged(s: Editable){
                validateEditText(addETDesc,addETDescL)
            }
        })

        val updateCloseImgBtn = updateTaskDialogBox.findViewById<ImageView>(R.id.closeImg)
        updateCloseImgBtn.setOnClickListener { updateTaskDialogBox.dismiss() }


        mainBinding.addTaskFABtn.setOnClickListener {
            addTaskDialogBox.show()
        }
    }
}