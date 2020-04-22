package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;

/**
 * 牛牛牌型比较器
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class NiuCompareUtil {

	/**
	 * 两个玩家的比较
	 * 
	 * @param p1
	 *            玩家1的牌型组合
	 * @param p2
	 *            玩家2的牌型组合
	 * @return true 玩家1赢了 false 玩家1输了
	 */
	public static boolean twoCompare(ProkerCombo p1, ProkerCombo p2) {
		if (p1.getId() > p2.getId()) {
			return true;
		} else if (p1.getId() < p2.getId()) {
			return false;
		} else {
			if (p1.getId() == 19 || p1.getId() == 18) {
				if (p1.getId() == 18) {
					Poker three = p1.getThree();
					Poker three2 = p2.getThree();
					if (three != null && three2 != null) {
						if (three.getId() > three2.getId()) {
							return true;
						} else if (three.getId() < three2.getId()) {
							return false;
						}
					}

				} else {
					Poker four = p1.getFour();
					Poker four2 = p2.getFour();
					if (four != null && four2 != null) {
						if (four.getId() > four2.getId()) {
							return true;
						} else if (four.getId() < four2.getId()) {
							return false;
						}
					}
				}
			} else {
				Poker m1 = p1.getMaxPoker();
				Poker m2 = p2.getMaxPoker();
				if (m1.getId() > m2.getId()) {
					return true;
				} else if (m1.getId() < m2.getId()) {
					return false;
				} else {

				}
			}
		}
		return false;
	}
}
