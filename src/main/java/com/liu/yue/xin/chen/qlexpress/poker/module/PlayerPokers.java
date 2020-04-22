package com.liu.yue.xin.chen.qlexpress.poker.module;

import java.util.List;

/**
 * 玩家和扑克牌绑定
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class PlayerPokers {
	/**
	 * 玩家的id
	 */
	private long playerId;
	/**
	 * 玩家的扑克牌
	 */
	private List<Poker> pokers;

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public List<Poker> getPokers() {
		return pokers;
	}

	public void setPokers(List<Poker> pokers) {
		this.pokers = pokers;
	}
}
