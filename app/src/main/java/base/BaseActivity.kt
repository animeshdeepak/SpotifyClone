package base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    open fun observers() {}
    open fun initViews() {}
}