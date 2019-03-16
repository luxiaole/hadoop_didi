package com.alvinalexander

object Utils {
  implicit  class  StringImprovements(val s: String){
    def increment = s.map(c=>(c+1).toChar)
  }
}
