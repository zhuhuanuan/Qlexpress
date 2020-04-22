package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.Type;
import com.ql.util.express.Operator;

/**
 * 同花牛 ： 五张手牌为同一花色
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@SuppressWarnings("unchecked")
public class SameFlowerCalves extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		// 将牌进行牌的花色进行组合
		Map<Type, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getType, Collectors.toList()));
		// 如果只有一个组合则为 同花牛
		if (collect.keySet().size() == 1)
			return true;
		return false;
	}

}
