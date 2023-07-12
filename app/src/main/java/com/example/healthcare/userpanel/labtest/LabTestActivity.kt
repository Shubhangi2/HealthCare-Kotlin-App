package com.example.healthcare.userpanel.labtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthcare.R

class LabTestActivity : AppCompatActivity() {
    val package1: Array<String> = arrayOf("package1 : Full Body Checkup", "", "", "", "999")
    val package2: Array<String> = arrayOf("Package2 : Blood Glucose Fasting", "", "", "", "299")
    val package3: Array<String> = arrayOf("package3 : COVID-19 Antibody - IgG", "", "", "", "899")
    val package4: Array<String> = arrayOf("pacckage4 : Thyroid Check", "", "", "", "499")
    val package5: Array<String> = arrayOf("pacckage5 : Immunity Check", "", "", "", "699")

    val arr = arrayOf(package1, package2, package3, package4, package5)

    val package_details : Array<String> = arrayOf(
        "Blood Glucose Fasting \n" +
                "Complete Hemogram \n" +
                "HBA1c \n" +
                "Iron studies \n" +
                "Kidney function test \n" +
                "LDH lactase dehydrogenase, serun \n" +
                "Lipid profile \n" +
                "Liver function test",
        "Blood glucose fasting",
        "COVID-19 Antibody - IgG",
        "Thyroid profile-Total (T3, T4 & Tsh Ultra-sensitive",
        "Complete Hemogram \n" +
                "CRP (C reactive protein) contitative, serun\n" +
                "Iron studies \n" +
                "Kidney function test \n" +
                "Vitamin-D Total-25 Hydroxy \n" +
                "Liver function test \n" +
                "Lipid Profile"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_test)
    }
}