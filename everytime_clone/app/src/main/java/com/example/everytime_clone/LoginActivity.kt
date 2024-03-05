package com.example.everytime_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.everytime_clone.databinding.ActivityLoginBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard

class LoginActivity : AppCompatActivity() {

    private var mBinding: ActivityLoginBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding?.root?.setOnClickListener { // 빈공간 클릭시 키보드 내리기
            hideKeyboard()
        }

        mBinding?.btSignup?.setOnClickListener {//회원가입 버튼 클릭시 RegisterActivity 생성 및 이동
            val registerActivityIntent = Intent(this,RegisterActivity::class.java)
            startActivity(registerActivityIntent)
        }
        mBinding?.btLogin?.setOnClickListener { //로그인 버튼 클릭시 MainActivity 생성 및 이동 (로그인 기능 미구현)
            val mainActivityIntent = Intent(this,MainActivity::class.java)
            startActivity(mainActivityIntent)
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