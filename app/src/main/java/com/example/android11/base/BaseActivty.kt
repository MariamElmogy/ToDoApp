package com.example.android11.base

import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivty :AppCompatActivity(){

    fun showDialog(title:String?=null,
                   message:String,
                   posActionName:String?=null,
                   posAction:DialogInterface.OnClickListener?=null,
                   negActionName:String?=null,
                   negAction: DialogInterface.OnClickListener?=null){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setTitle(title)
        builder.setPositiveButton(posActionName, posAction)
        builder.setNegativeButton(negActionName, negAction)
        builder.show()
    }

    fun showDialog(titleId:Int?=null,
                   messageId:Int,
                   posActionName:Int?=null,
                   posAction:DialogInterface.OnClickListener?=null,
                   negActionName:Int?=null,
                   negAction: DialogInterface.OnClickListener?=null){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(messageId)
        builder.setTitle(title)
        if(titleId!=null)
            builder.setTitle(titleId)
        if(posActionName!=null)
            builder.setPositiveButton(posActionName, posAction)
        if(negActionName!=null)
            builder.setNegativeButton(negActionName, negAction)
        builder.show()
    }

    fun makeToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun makeToast(messageId: Int){
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show()
    }
}