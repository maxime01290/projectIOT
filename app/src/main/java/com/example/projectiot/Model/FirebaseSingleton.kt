package com.example.projectiot.Model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


object FirebaseSingleton {
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("ActiveMode")
    var r:DatabaseReference = myRef.child("r")
    var g:DatabaseReference = myRef.child("g")
    var b:DatabaseReference = myRef.child("b")
    var nbLed:DatabaseReference = myRef.child("nbLed")
    var tmpClignotement:DatabaseReference = myRef.child("tmpCligotement")
}