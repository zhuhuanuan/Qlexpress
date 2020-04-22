package com.liu.yue.xin.chen.qlexpress.poker.function.sangong;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;
import com.ql.util.express.Operator;

/**
 * 三条算法
 *  除3以外其它任意三张相同点数的牌
 */
public class SanTao  extends Operator{

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers=	(List<Poker>) list[0];
		// 根据牌值进行分类
		Map<PokerNumber, List<Poker>> collect = pokers.stream().collect(Collectors.groupingBy(Poker :: getNumber,Collectors.toList()));
		Set<PokerNumber> keySet = collect.keySet(); 
		if(keySet.size()==1)return true;
		return false;
	}

}
