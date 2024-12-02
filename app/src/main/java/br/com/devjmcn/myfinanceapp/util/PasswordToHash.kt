package br.com.devjmcn.myfinanceapp.util

import org.mindrot.jbcrypt.BCrypt

object PassToHash {
    fun hashPassword(password:String):String{
        return BCrypt.hashpw(password, BCrypt.gensalt(12))
    }

    fun comparePassword(insertPass:String, storedPass:String):Boolean{
        return BCrypt.checkpw(insertPass, storedPass)
    }
}
