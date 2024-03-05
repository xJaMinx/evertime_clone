package com.example.everytime_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.everytime_clone.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private var mBinding: ActivityRegisterBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding?.root?.setOnClickListener { // 빈공간 클릭시 키보드 내리기
            hideKeyboard()
        }

        mBinding?.btBack?.setOnClickListener {
            finish()
        }
    }
    private fun hideKeyboard() { //키보드 내리는 매소드
        val currentFocusView = currentFocus
        if (currentFocusView != null) {
            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                currentFocusView.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}