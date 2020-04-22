package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 顺子算法</br>
 * 三张顺连的牌型 AKQ最大，A23最小
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class ShunZi extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {

		List<Poker> pokers = (List<Poker>) list[0];

		return Poker.checkShunZi(pokers);

	}

}
