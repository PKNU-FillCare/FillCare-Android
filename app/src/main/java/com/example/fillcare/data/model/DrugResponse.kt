package com.example.fillcare.data.model


data class DrugResponse(
    val header : Header,
    val body : Body
)
data class Header(
    val resultCode : Int,
    val resultMsg : String,
)
data class Body(
    val pageNo : Int,
    val totalCount : Int,
    val numOfRows :Int,
    val items : List<DrugItem>
)

data class DrugItem(
    val entpName : String,
    val itemName : String,
    val efficacy: String,
    val useMethod : String,
    val caution : String,
    val interaction : String,
    val sideEffect: String,
    val   depositMethod :String,
    val   itemImage : String,

)