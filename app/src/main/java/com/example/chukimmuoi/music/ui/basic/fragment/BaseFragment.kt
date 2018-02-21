package com.example.chukimmuoi.music.ui.basic.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chukimmuoi.music.ui.basic.BaseActivity

/**
 * @author  : Hanet Electronics
 * @Skype   : chukimmuoi
 * @Mobile  : +84 167 367 2505
 * @Email   : muoick@hanet.com
 * @Website : http://hanet.com/
 * @Project : Music
 * Created by chukimmuoi on 13/02/2018.
 */
abstract class BaseFragment : Fragment(), FragmentView {

    private var mActivity: BaseActivity? = null

    private var mFragmentListener: OnFragmentListener? = null

    /**
     * 1. Call when Fragment connect Activity. [onDetach]
     *
     * @param context
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        mActivity = activity as BaseActivity

        if (mActivity is OnFragmentListener) {
            mFragmentListener = mActivity
        }
    }

    /**
     * 2. Use onCreate variable not UI. [onDestroy]
     * eg: context, adapter, arrayList
     *
     * @param savedInstanceState bien luu trang thai truoc do, dung khi muon khoi phuc lai.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { createVariableStart(it) }

        createVariableNormal(savedInstanceState)
    }

    /**
     * 3. Set layout XML. [onDestroyView]
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setLayout(inflater, container, savedInstanceState)
    }

    /**
     * 4. Set variable UI.
     *
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createVariableView(view, savedInstanceState)
    }

    /**
     * 5. Call when Activity complete method. [onCreate]
     *
     * @param savedInstanceState
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    /**
     * 5. Call when fragment ready show on screen. [onStop]
     */
    override fun onStart() {
        super.onStart()
    }

    /**
     * 6. Handle resources. Multi screen. [onPause]
     */
    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        mActivity = null
        mFragmentListener = null

        super.onDetach()
    }

    /**
     * Noi khai bao cac bien duoc truyen tu activity hoac fragment khac
     *
     * @param bundle bien nay luu cac gia tri duoc truyen co the la string, int, boolean, ...
     * */
    abstract fun createVariableStart(bundle: Bundle)

    /**
     * Noi khai bao cac bien cac bien thong thuong de xu ly tinh toan maf khong phai UI
     * */
    abstract fun createVariableNormal(savedInstanceState: Bundle?)

    /**
     * Noi khai bao, xu ly cac bien lien quan den UI nhu button, edit text, text view, ...
     * */
    abstract fun createVariableView(view: View?, savedInstanceState: Bundle?)

    /**
     * Add layout hien thi cho fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState dung de khoi phuc lai du lieu truoc do
     *
     * @return view or null
     * */
    abstract fun setLayout(inflater: LayoutInflater?,
                           container: ViewGroup?,
                           savedInstanceState: Bundle?): View

    interface OnFragmentListener {
        /**
         * Handle event multi fragment
         *
         * @param layoutId
         * @param event
         */
        fun onFragmentAction(layoutId: Int, event: Int)
    }

    override fun findingFragment(layoutId: Int): Fragment? {
        return mActivity?.findingFragment(layoutId, childFragmentManager)
    }

    override fun findingFragment(tag: String): Fragment? {
        return mActivity?.findingFragment(tag, childFragmentManager)
    }

    override fun displayFragment(layoutContainer: Int, fragment: Fragment, tag: String,
                                 isSaveCache: Boolean, bundle: Bundle?) {
        mActivity?.displayFragment(layoutContainer, fragment, tag, isSaveCache, bundle, childFragmentManager)
    }

    override fun displayMultiFragment(layoutContainer: Int, fragment: Fragment, tag: String,
                                      tagParent: String, bundle: Bundle?) {
        mActivity?.displayMultiFragment(layoutContainer, fragment, tag, tagParent, bundle, childFragmentManager)
    }

    override fun backStackFragmentHome() {
        mActivity?.backStackFragmentHome(childFragmentManager)
    }

    override fun onBackPressed() {
        mActivity?.onBackPressed(childFragmentManager)
    }
}