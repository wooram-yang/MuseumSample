package com.moreflow.museumsample.entity

data class GalleryResponse(
    val info: GalleryInfo,
    val records: ArrayList<GalleryRecord>
): NetworkResponseModel

data class GalleryInfo(
    val records: Int,
    val totalrecords: Int,
    val pages: Int,
    val info: Int
)

data class GalleryRecord(
    val gallerynumber: String,
    val objectcount: Int,
    val id: Int,
    val lastupdate: String,
    val floor: Int,
    val name: String,
    val theme: String,
    val galleryid: Int
)