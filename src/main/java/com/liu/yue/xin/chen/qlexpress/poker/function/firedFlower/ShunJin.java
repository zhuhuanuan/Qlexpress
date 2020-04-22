package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.Type;
import com.ql.util.express.Operator;


/**
 * 顺金算法</br>
 * 1.花色相同的顺子组成的牌型
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class ShunJin extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		// 根据花色进行分类
		Map<Type, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getType, Collectors.toList()));
		if (collect.keySet().size() != 1)
			return false;
		boolean checkShunZi = Poker.checkShunZi(pokers);
		if (checkShunZi)
			return true;
		return false;
	}

}
