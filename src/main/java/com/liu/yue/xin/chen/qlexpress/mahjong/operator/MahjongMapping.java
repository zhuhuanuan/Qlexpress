package com.liu.yue.xin.chen.qlexpress.mahjong.operator;

/**
 * 麻将（操作符绑定算法）
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月23日
 */
public enum MahjongMapping {
	/*** Operator *******/
	
	/******* Macro *******/
	/**
	 * 手牌
	 */
	HAND_MAHJONG("手牌", null),
	/**
	 * 吃牌堆
	 */
	CHI_MAHJONG("吃牌堆", null),
	/**
	 * 碰牌堆
	 */
	PENG_MAHJONG("碰牌堆", null),
	/**
	 * 杠牌堆
	 */
	GANG_MAHJONG("杠牌堆", null),
	
	/******* function *******/
	
	
	
	
	;

	/**
	 * 操作符名称
	 */
	private String name;
	/**
	 * 算法类
	 */
	private Class cls;

	MahjongMapping(String name, Class cls) {
		this.name = name;
		this.cls = cls;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getCls() {
		return cls;
	}

	public void setCls(Class cls) {
		this.cls = cls;
	}

}
