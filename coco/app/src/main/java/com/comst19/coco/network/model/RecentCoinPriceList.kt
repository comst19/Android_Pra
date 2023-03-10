package com.comst19.coco.network.model

import com.comst19.coco.dataModel.RecentPriceData

data class RecentCoinPriceList (

    val status : String,
    val data : List<RecentPriceData>

)