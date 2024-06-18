package com.example.fillcare.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DrugResponse(
    val header : Header,
    val body : Body
)

@Serializable
data class Header(
    val resultCode : Int,
    val resultMsg : String,
)
@Serializable
data class Body(
    val pageNo : Int,
    val totalCount : Int,
    val numOfRows :Int?,
    val items : List<DrugItem>?
)

@Serializable
data class DrugItem(
    val entpName : String?,
    val itemName : String?,
    val itemSeq: String?,
    val efcyQesitm : String?,
    val useMethodQesitm : String?,
    val atpnWarnQesitm: String?,
    val atpnQesitm : String?,
    val intrcQesitm : String?,
    val seQesitm : String?,
    val depositMethodQesitm : String?,
    val openDe: String?,
    val updateDe :String?,
    val itemImage : String?,
    val bizrno : String?

)