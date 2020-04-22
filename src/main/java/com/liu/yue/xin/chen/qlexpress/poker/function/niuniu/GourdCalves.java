package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;
import com.ql.util.express.Operator;

/**
 * 葫芦牛 ： 三张点数相同的牌加两张点数相同的牌
 * 
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@SuppressWarnings("unchecked")
public class GourdCalves extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		// 先根据牌的牌值进行分类组合
		Map<PokerNumber, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));
		int size = collect.keySet().size();
		// 如果分类组合不是2个组合的则不是炸弹牛
		if (size != 2) {
			return false;
		}

		int tem = 0; // 记录第一个组合的大小 如果第一个组合的大小为2 或者 3 则为 葫芦牛
		for (List<Poker> calves : collect.values()) {
			if (tem == 0) {
				tem = calves.size();
			}
		}
		if (tem == 2 || tem == 3)
			return true;
		return false;
	}

}
