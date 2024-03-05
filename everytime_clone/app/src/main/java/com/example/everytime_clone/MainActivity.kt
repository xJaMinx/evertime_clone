package com.example.everytime_clone

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.everytime_clone.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat


class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar : Toolbar = findViewById(R.id.include)
        setSupportActionBar(toolbar)

        mBinding?.include?.profile?.setOnClickListener {
            mBinding?.drawerLayout?.openDrawer(GravityCompat.END)
        }

    }

    fun setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    //supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout, ()).commit()
                    true
                }
                else -> false
            }
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