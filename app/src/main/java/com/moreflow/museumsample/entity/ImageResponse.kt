package com.moreflow.museumsample.entity

data class ImageResponse(
    val info: ImageInfo,
    val records: ArrayList<ImageRecord>
): NetworkResponseModel

data class ImageInfo(
    val totalrecordsperquery: Int,
    val totalrecords: Int,
    val pages: Int,
    val page: Int,
    val next: String
)

data class ImageRecord(
    val id: Int,
    val imageid: Int,
    val fileid: Int,
    val idsid: Int,
    val caption: String,
    val alttext: String,
    val description: String,
    val copyright: String,
    val iiifbaseuri: String,
    val baseimageurl: String,
    val renditionnumber: String,
    val date: String,
    val height: String,
    val width: Int,
    val accesslevel: Int,
    val format: String,
    val technique: String,
    val lastupdate: String
)