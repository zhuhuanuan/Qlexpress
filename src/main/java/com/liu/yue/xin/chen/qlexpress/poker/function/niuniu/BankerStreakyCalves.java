package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 庄家 五花牛
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class BankerStreakyCalves extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		// 遍历 如果手牌的牌num 小于11 则不是五花牛
		for (Poker poker : pokers) {
			if (poker.getNumber().getNum() <= 10)
				return false;
		}
		return true;
	}

}
