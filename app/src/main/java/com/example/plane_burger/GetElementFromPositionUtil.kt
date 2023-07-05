package com.example.plane_burger

import android.content.res.Resources
import android.content.res.TypedArray

fun getPhotoFromPosition(resources: Resources, i: Int): Photo {
    val iconsArray = resources.obtainTypedArray(R.array.icons)
    var descriptionImagesArray: TypedArray? = null
    val titlesArray = resources.getStringArray(R.array.titles)
    val descriptionTitlesArray = resources.getStringArray(R.array.descriptionTitles)
    val descriptionsArray = resources.getStringArray(R.array.descriptions)
    val yearsArray = resources.getIntArray(R.array.years)

    val photoList = mutableListOf<Photo>()

    var photoDescription: Int? = null
    try{
        descriptionImagesArray = resources.obtainTypedArray(R.array.descriptionImages)
        photoDescription = descriptionImagesArray.getResourceId(i, 0)
    } catch (_:Throwable){}

    val photo = Photo(
        imageRes = iconsArray.getResourceId(i, 0),
        title = titlesArray[i],
        year = yearsArray[i].toString(),
        titleDescription = descriptionTitlesArray[i],
        description = descriptionsArray[i],
        photoDescription = photoDescription
    )
    photoList.add(photo)


    iconsArray.recycle()
    descriptionImagesArray?.recycle()

    return photo
}

fun getWholeElementsPositions(resources: Resources): List<Int>{
    val iconsArray = resources.obtainTypedArray(R.array.icons)
    val result = mutableListOf<Int>()
    for(i in 0 until iconsArray.length()){
        result.add(i)
    }
    iconsArray.recycle()
    return result
}

fun getTitle(resources: Resources,  i: Int): String{
    val titlesArray = resources.getStringArray(R.array.titles)
    return titlesArray[i]
}