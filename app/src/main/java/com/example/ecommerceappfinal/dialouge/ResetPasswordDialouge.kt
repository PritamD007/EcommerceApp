package com.example.ecommerceappfinal.dialouge

import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.ecommerceappfinal.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.setupBottomSheetDialog(
    onSendClick: (String) -> Unit

){
       val dialog = BottomSheetDialog(requireContext())
       val view = layoutInflater.inflate(R.layout.reset_password_dialouge, null)
        dialog.setContentView(view)
    dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
    dialog.show()

    val edEmail = view.findViewById<EditText>(R.id.edResetPassword)
    val btnSend = view.findViewById<Button>(R.id.btnSendResetPassword)
    val btnCancel = view.findViewById<Button>(R.id.btnCancelResetPassword)

    btnSend.setOnClickListener{
    val email = edEmail.text.toString().trim()
        onSendClick(email)
        dialog.dismiss()
    }

    btnCancel.setOnClickListener{
        dialog.dismiss()
    }
}
