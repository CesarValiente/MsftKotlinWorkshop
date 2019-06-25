package com.microsoft.msftbreweryworkshop.ext

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.microsoft.msftbreweryworkshop.MSFTBreweryApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val Context.app: MSFTBreweryApplication
    get() = applicationContext as MSFTBreweryApplication

fun Context?.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    this?.let { context ->
        Toast.makeText(context, message, duration).show()
    }
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    context.showToast(message, duration)
}

fun FragmentManager.inTransaction(block: FragmentTransaction.() -> Unit) = beginTransaction().apply(block).commit()

fun AppCompatActivity.replaceFragment(fragmentContainerId: Int, fragment: Fragment, fragmentName: String?, addToBackStack: Boolean = false) {
    fragmentContainerId?.let {
        supportFragmentManager.inTransaction {
            replace(it, fragment)

            if (addToBackStack) {
                addToBackStack(fragmentName)
            }
        }
    }
}

fun<T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {
    val callBackKt = CallBackKt<T>()
    callback.invoke(callBackKt)
    this.enqueue(callBackKt)
}

class CallBackKt<T>: Callback<T> {

    var onResponse: ((Response<T>) -> Unit)? = null
    var onFailure: ((t: Throwable?) -> Unit)? = null

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure?.invoke(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        onResponse?.invoke(response)
    }

}