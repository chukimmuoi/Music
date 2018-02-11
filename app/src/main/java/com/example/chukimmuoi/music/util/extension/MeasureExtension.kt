package com.example.chukimmuoi.music.util.extension

import android.content.res.Resources

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 10/02/2018.
 */

// https://stackoverflow.com/questions/4605527/converting-pixels-to-dp#12147550

/**
 * Converts a pixel value to a density independent pixels (DPs).
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code pixels} in DPs.
 */
fun Float.convertPixelToDp(resources: Resources) : Float{
    return this / resources.displayMetrics.density
}

/**
 * Converts a density independent pixels (DPs) value to a pixel.
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code Dps} in pixels.
 */
fun Float.convertDpToPixel(resources: Resources) : Float {
    return this * resources.displayMetrics.density
}

/**
 * Converts a pixel value to a density independent pixels (DPs).
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code pixels} in DPs.
 */
fun Int.convertPixelToDp(resources: Resources) : Int {
    return Math.round(this / resources.displayMetrics.density)
}

/**
 * Converts a density independent pixels (DPs) value to a pixel.
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code Dps} in pixels.
 */
fun Int.convertDpToPixel(resources: Resources) : Int{
    return Math.round(this * resources.displayMetrics.density)
}