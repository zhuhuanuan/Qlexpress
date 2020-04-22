package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;
import com.ql.util.express.Operator;

/**
 * 对子算法
 *  两种点数相同的牌型
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class duizi extends Operator{

	private static final long serialVersionUID = 1L;
	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers=	(List<Poker>) list[0];
		// 根据牌值进行分类
		Map<PokerNumber, List<Poker>> collect = pokers.stream().collect(Collectors.groupingBy(Poker :: getNumber,Collectors.toList()));
		Set<PokerNumber> keySet = collect.keySet();
		if(keySet.size()==2)return true; 
		return false;
	} 
	

}
