package com.liu.yue.xin.chen.qlexpress.poker.operator;

/**
 * 扑克牌规则
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class PokerRule {
	/**
	 * 是否始终扫描所有胡牌的表达式，不管前面的表达式是否为true,用于算分时，叠加表达式的分数
	 */
	public static boolean ALWAYS_SCAN_HU = false;
	/**
	 * 规则名称
	 */
	private String name;

	/**
	 * 规则类型，默认有hu gang peng chi
	 */
	private String type;
	/**
	 * 表达式
	 */
	private String express;
	/**
	 * 规则id
	 */
	private int id;

	private int rate;

	public static boolean isALWAYS_SCAN_HU() {
		return ALWAYS_SCAN_HU;
	}

	public static void setALWAYS_SCAN_HU(boolean aLWAYS_SCAN_HU) {
		ALWAYS_SCAN_HU = aLWAYS_SCAN_HU;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return new StringBuilder("{").append("\"name\":\"").append(name).append('\"').append(",\"type\":\"")
				.append(type).append('\"').append(",\"id\":\"").append(id).append('\"').append(",\"rate\":\"")
				.append(rate).append('\"').append(",\"express\":\"").append(express).append('\"').append('}')
				.toString();
	}

}
