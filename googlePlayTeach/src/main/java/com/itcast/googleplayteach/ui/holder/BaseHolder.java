package com.itcast.googleplayteach.ui.holder;

import android.view.View;

import com.itcast.googleplayteach.ui.adapter.MyBaseAdapter;

/**
 * ViewHolder的基类
 * 
 * 此类实现了以下功能
 * 1. 初始化item布局
 * 2. findViewById方法(由子类在初始化布局时实现)
 * 2. 给view设置tag
 * 3. 刷新界面
 * 
 * 此类相当于是对{@link MyBaseAdapter}getView方法的封装，封装后使用该基类只需实现2个方法：
 * 1. 加载布局已经findViewById
 * @see #initView()
 * 2. 刷新页面
 * @see #refreshView
 *
 * 该基类也可以用于其他非MyBaseAdapter的情况，但是需要手动设置数据
 * @see #setData(Object)
 * 
 * @author Kevin
 * 
 */
public abstract class BaseHolder<T> {

	private View mRootView;// item的布局对象
	private T data;// item对应的数据

	public BaseHolder() {
		mRootView = initView();// 初始化布局
		mRootView.setTag(this);// 给view设置tag
	}

	// 初始化布局的方法必须由子类实现
	public abstract View initView();

	// 返回布局对象
	public View getRootView() {
		return mRootView;
	};

	// 设置数据
	public void setData(T data) {
		this.data = data;
		refreshView(data);
	}

	// 获取数据
	public T getData() {
		return data;
	}

	// 刷新界面,更新数据,子类必须实现
	public abstract void refreshView(T data);
}
