package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;
import com.ql.util.express.Operator;

/**
 * 顺子牛 ： 五张手牌为顺子
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@SuppressWarnings("unchecked")
public class OrderCalves extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];

		Map<PokerNumber, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));

		if (collect.keySet().size() != 5)
			return false;
		int num = 0;// 记录牌的值 从最小的牌值开始记录
		for (Poker poker : pokers) {
			if (num == 0) {
				num = poker.getNumber().getNum();
			} else {
				num++;
				if (num != poker.getNumber().getNum()) {
					return false;
				}
			}
		}

		return true;
	}

}
