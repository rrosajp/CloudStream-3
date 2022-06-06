package com.lagradost.cloudstream3.syncproviders.providers

import com.lagradost.cloudstream3.syncproviders.InAppAuthAPIManager

class OpenSubtitlesApi(index : Int) : InAppAuthAPIManager(index) {
    override val idPrefix = "opensubtitles"
    override val name = "OpenSubtitles"
}