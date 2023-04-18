package com.example.weatherclothet.util

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.showToast(message: Any) {
    Toast.makeText(this@showToast, message.toString(), Toast.LENGTH_SHORT).show()
}


fun Fragment.showToast(message: Any) {
    activity?.runOnUiThread {
        Toast.makeText(requireContext(), message.toString(), Toast.LENGTH_SHORT).show()
    }
}