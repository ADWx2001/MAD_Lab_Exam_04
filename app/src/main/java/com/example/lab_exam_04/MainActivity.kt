package com.example.lab_exam_04

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.lab_exam_04.databinding.ActivityMainBinding
import com.example.lab_exam_04.util.setupDialog
import com.example.lab_exam_04.util.validateEditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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

        //add task start
        val addCloseImgBtn = addTaskDialogBox.findViewById<ImageView>(R.id.closeImg)
        addCloseImgBtn.setOnClickListener { addTaskDialogBox.dismiss() }

        val addEDTitle = addTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskTitle)
        val addEDTitleL = addTaskDialogBox.findViewById<TextInputLayout>(R.id.edTaskTitleL)

        addEDTitle.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){}
            override fun onTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){}
            override fun afterTextChanged(s: Editable){
                validateEditText(addEDTitle,addEDTitleL)
            }
        })

        val addETDesc = addTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskDesc)
        val addETDescL = addTaskDialogBox.findViewById<TextInputLayout>(R.id.edTaskDescL)

        addETDesc.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){ }
            override fun onTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){ }
            override fun afterTextChanged(s: Editable){
                validateEditText(addETDesc,addETDescL)
            }
        })

        mainBinding.addTaskFABtn.setOnClickListener {
            addTaskDialogBox.show()
        }

        val saveTaskBtn = addTaskDialogBox.findViewById<Button>(R.id.saveTaskBtn)
        saveTaskBtn.setOnClickListener {
            if(validateEditText(addEDTitle,addEDTitleL) && validateEditText(addETDesc,addETDescL)){
                addTaskDialogBox.dismiss()
                Toast.makeText(this,"Validated!",Toast.LENGTH_LONG).show()
                loadingDialog.show()
            }
        }

        //add task end

        //update task start here
        val updateEDTitle = updateTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskTitle)
        val updateEDTitleL = updateTaskDialogBox.findViewById<TextInputLayout>(R.id.edTaskTitleL)

        updateEDTitle.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){}
            override fun onTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){}
            override fun afterTextChanged(s: Editable){
                validateEditText(updateEDTitle,updateEDTitleL)
            }
        })

        val updateETDesc = updateTaskDialogBox.findViewById<TextInputEditText>(R.id.edTaskDesc)
        val updateETDescL = updateTaskDialogBox.findViewById<TextInputLayout>(R.id.edTaskDescL)

        updateETDesc.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){ }
            override fun onTextChanged(p0: CharSequence?, p1:Int, p2:Int, p3:Int){ }
            override fun afterTextChanged(s: Editable){
                validateEditText(updateETDesc,updateETDescL)
            }
        })


        val updateCloseImgBtn = updateTaskDialogBox.findViewById<ImageView>(R.id.closeImg)
        updateCloseImgBtn.setOnClickListener { updateTaskDialogBox.dismiss() }

        val updateTaskBtn = updateTaskDialogBox.findViewById<Button>(R.id.updateTaskBtn)
        updateTaskBtn.setOnClickListener {
            if(validateEditText(updateEDTitle,updateEDTitleL) && validateEditText(updateETDesc,updateETDescL)){
                updateTaskDialogBox.dismiss()
                Toast.makeText(this,"Validated!",Toast.LENGTH_LONG).show()
                loadingDialog.show()
            }
        }
        //update task end here
    }
}