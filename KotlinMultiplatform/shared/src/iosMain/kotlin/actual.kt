package com.yasiralijaved.kotlinmultiplatform.shared

import platform.UIKit.UIDevice

actual fun platformName() : String {
    return "iOS " + UIDevice.currentDevice.systemVersion
}