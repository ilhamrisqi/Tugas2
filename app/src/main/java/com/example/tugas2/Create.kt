package com.example.tugas2

import Database.GlobalVar
import Model.Ayam
import Model.Hewan
import Model.Kambing
import Model.Sapi
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.tugas2.databinding.ActivityCreateBinding
import com.example.tugas2.databinding.ActivityMainBinding

class Create : AppCompatActivity() {

    private lateinit var viewBind : ActivityCreateBinding
    private lateinit var hewan: Hewan
    private var position = -1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        GetIntent()
        Listener()
    }


    private fun GetIntent(){
        position = intent.getIntExtra("position", -1 )
        if(position != -1){
            val user = GlobalVar.listDataHewan[position]
            Display(user)
        }
    }

    private fun Display(user: Hewan){
        viewBind.NamatextInputLayout.editText?.setText(user.nama)
        viewBind.UsiatextInputLayout2.editText?.setText(user.usia)

    }


    private fun Listener(){
        viewBind.SimpanButton.setOnClickListener{
            var nama = viewBind.NamatextInputLayout.editText?.text.toString().trim()
            var usia = viewBind.UsiatextInputLayout2.editText?.text.toString().trim()
            var radioId = viewBind.radioGroup.checkedRadioButtonId
            var radioButton = findViewById<RadioButton>(radioId)
            var type = radioButton.text.toString()
            if( type == "Ayam"){
                hewan = Ayam(nama,type,usia)
            }else if(type== "Sapi"){
                hewan = Sapi(nama,type,usia)
            }else if (type == "Kambing"){
                hewan = Kambing(nama,type,usia)
            }

            checker()
        }

    }


    //pengecekan
    private fun checker(){
        var isCompleted = true
        //nama
        if(hewan.nama!!.isEmpty()){
            viewBind.NamatextInputLayout.error ="Tolong isi Nama dengan benar!"
            isCompleted = false
        }
        else{
            viewBind.NamatextInputLayout.error = ""
        }

        //usia
        if (hewan.usia!!.isEmpty()){
            viewBind.UsiatextInputLayout2.error ="Tolong isi Usia Hewan dengan benar!"
            isCompleted = false
        }
        else{
            viewBind.UsiatextInputLayout2.error =""
        }


        if (isCompleted){
            if(position== -1){
                GlobalVar.listDataHewan.add(hewan)
            }else{
                GlobalVar.listDataHewan[position] = hewan
            }
            finish()
        }

    }


}