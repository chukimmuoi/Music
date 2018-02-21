package com.example.chukimmuoi.music.ui.basic.fragment

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 17/02/2018.
 */
interface FragmentView {

    /**
     * @param layoutId
     * @return
     * */
    fun findingFragment(@IdRes layoutId: Int) : Fragment?

    /**
     * @param tag
     * @return
     * */
    fun findingFragment(tag: String) : Fragment?

    /**
     * @param layoutContainer
     * @param fragment
     * @param tag
     * @param isSaveCache
     * @param bundle
     * */
    fun displayFragment(@IdRes layoutContainer: Int, fragment: Fragment, tag: String,
                        isSaveCache: Boolean = true, bundle: Bundle? = null)

    /**
     * @param layoutContainer
     * @param fragment
     * @param tag
     * @param tagParent
     * @param bundle
     * */
    fun displayMultiFragment(@IdRes layoutContainer: Int, fragment: Fragment, tag: String,
                             tagParent: String = "", bundle: Bundle? = null)

    /**
     *
     * */
    fun backStackFragmentHome()

    /**
     *
     * */
    fun onBackPressed()
}