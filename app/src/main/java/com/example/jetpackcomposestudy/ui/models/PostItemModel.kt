package com.example.jetpackcomposestudy.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PostItemModel(
    val author:String,
    val title:String,
    val text:String,
    val date:String
): Parcelable{
    //TODO(override toString method to pass complex object)
}