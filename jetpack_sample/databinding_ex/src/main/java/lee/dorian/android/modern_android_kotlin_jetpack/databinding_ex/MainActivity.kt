package lee.dorian.android.modern_android_kotlin_jetpack.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import lee.dorian.android.modern_android_kotlin_jetpack.databinding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            val thisActivity = this@MainActivity
            lifecycleOwner = thisActivity
            viewModel = ViewModelProvider(thisActivity).get(MainViewModel::class.java)
        }
    }

}