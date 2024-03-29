package com.cjinle.utils

import com.google.gson.Gson


class TestGson {
    fun run() {
        println("test gson ...")
        val gson = Gson()
        val memberInfo = MemberInfo(id=111, nickname = "hello", gender = 1, money = 9999)
        val jsonStr = gson.toJson(memberInfo)
        println(jsonStr)

//        val memberInfo2 = Gson().fromJson<MemberInfo>(jsonStr, MemberInfo::class.java)
        val memberInfo2 = gson.fromJson(jsonStr, MemberInfo::class.java)
        memberInfo2.id = 333
        println(memberInfo2)

        val memberInfo3 = memberInfo.copy(id=444, money=123123)
        println(memberInfo3)



    }
}