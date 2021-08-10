package com.niuma.gta

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import com.permissionx.guolindev.PermissionX

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    var requestAllFileCode: Int = 65
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTools = dataTools(this,11)
        //权限请求
        PermissionX.init(this)
            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE)
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(deniedList, "即将申请的权限是程序必须依赖的权限", "我已明白")
            }
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(deniedList, "您需要去应用程序设置当中手动开启权限", "我已明白")
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    Toast.makeText(this, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "您拒绝了如下权限：$deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        //安装游戏按钮
        val button1: Button = findViewById(R.id.main_button1)
        button1.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.main_button1),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //教程按钮
        val button2: Button = findViewById(R.id.main_button2)
        button2.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.main_button2),
                R.string.activity_main_snackbar1,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        //进群按钮
        val button3: Button = findViewById(R.id.main_button3)
        button3.setOnClickListener {
            joinQQGroup("UTMWb9dokuq8aeIfEJdD5EwbFnAdVvcF")
        }
        //零花钱按钮
        val button4: Button = findViewById(R.id.main_button4)
        button4.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://shimo.im/docs/9jkpkpvVtXhrhykr/"))
            startActivity(intent)
        }
        //免费专区按钮
        val button5: Button = findViewById(R.id.main_button5)
        button5.setOnClickListener {
            val intent: Intent = Intent(this, FreeActivity::class.java)
            startActivity(intent)
        }
        //会员专区按钮
        val button6: Button = findViewById(R.id.main_button6)
        button6.setOnClickListener {
            val intent: Intent = Intent(this, VipActivity::class.java)
            startActivity(intent)
        }
        //最新活动按钮
        val button7: Button = findViewById(R.id.main_button7)
        button7.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://shimo.im/docs/PYCgp93Dwcg63k3q/"))
            startActivity(intent)
        }
        //最新推荐按钮
        val button8: Button = findViewById(R.id.main_button8)
        button8.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://shimo.im/docs/HcY99Jr3VTpJKtyT/"))
            startActivity(intent)
        }
        //文件授权按钮
        val button9: Button = findViewById(R.id.main_button9)
        button9.setOnClickListener {
            dataTools.requestPermission();//申请权限
        }
        //全部文件权限申请按钮
        val button10: Button = findViewById(R.id.main_button10)
        button10.setOnClickListener {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                Toast.makeText(this@MainActivity,"当前设备不是android11无法申请",Toast.LENGTH_SHORT).show();
            }
            if (dataTools.isAllFilePermission()){
                Toast.makeText(this@MainActivity,"权限已获取",Toast.LENGTH_SHORT).show();
            }else{
                dataTools.requestAllFilePermission(requestAllFileCode);
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val dataTools = dataTools(this,11)
        dataTools.savePermissions(requestCode, resultCode, data) //保存权限
        if (requestCode == requestAllFileCode) {
            if (dataTools.isAllFilePermission()) {
                Toast.makeText(this@MainActivity, "全部文件读写权限已成功获取", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "您未授权全部文件读写权限", Toast.LENGTH_SHORT).show()
            }
        }
    }
    /****************
     *
     * 发起添加群流程。群号：牛马游戏免费5群(879412144) 的 key 为： UTMWb9dokuq8aeIfEJdD5EwbFnAdVvcF
     * 调用 joinQQGroup(UTMWb9dokuq8aeIfEJdD5EwbFnAdVvcF) 即可发起手Q客户端申请加群 牛马游戏免费5群(879412144)
     *
     * @param key 由官网生成的key
     * @return 返回true表示呼起手Q成功，返回false表示呼起失败
     ******************/
    fun joinQQGroup(key: String)
    : Boolean {
        val intent: Intent = Intent()
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key))
        return try {
            startActivity(intent)
            true
        }catch (e: Exception){
            false
        }
    }

@SuppressLint("ShowToast")
    fun toast(text:String,context: Context){
        val toast:Toast = Toast.makeText(context,text,Toast.LENGTH_LONG)
    }

}
