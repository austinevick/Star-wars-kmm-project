package com.austinevick.starwarapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform