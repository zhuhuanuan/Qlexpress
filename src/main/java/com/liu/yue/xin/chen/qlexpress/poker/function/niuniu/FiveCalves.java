package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 五小牛 ： 五张手牌单牌都不大于5，且五张牌总和小于或等于10
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class FiveCalves extends Operator {
	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		int sum = 0;
		for (Poker poker : pokers) {
			if (poker.getNumber().getNum() > 5) {
				return false;
			}
			sum += poker.getNumber().getNum();
		}
		return sum <= 10 ? true : false;
	}

}
