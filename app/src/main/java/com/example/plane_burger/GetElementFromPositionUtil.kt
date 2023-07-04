package com.example.plane_burger

import android.content.res.Resources

fun getPhotoFromPosition(resources: Resources, i: Int): Photo {
    val iconsArray = resources.obtainTypedArray(R.array.icons)
    val descriptionImagesArray = resources.obtainTypedArray(R.array.descriptionImages)
    val titlesArray = resources.getStringArray(R.array.titles)
    val descriptionTitlesArray = resources.getStringArray(R.array.descriptionTitles)
    val descriptionsArray = resources.getStringArray(R.array.descriptions)
    val yearsArray = resources.getIntArray(R.array.years)

    val photoList = mutableListOf<Photo>()

    val photo = Photo(
        imageRes = iconsArray.getResourceId(i, 0),
        title = titlesArray[i],
        year = yearsArray[i].toString(),
        titleDescription = descriptionTitlesArray[i],
        description = descriptionsArray[i],
        photoDescription = descriptionImagesArray.getResourceId(i, 0)
    )
    photoList.add(photo)


    iconsArray.recycle()
    descriptionImagesArray.recycle()

    return photo
}