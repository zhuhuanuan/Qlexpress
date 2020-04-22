package com.liu.yue.xin.chen.qlexpress.poker.function.sangong;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 三公
 * J 11
 * Q 12
 * K 13
 * 中任意3张但点数不全部相同的牌
 */
public class SanGong  extends Operator{
	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers=	(List<Poker>) list[0];
		if(pokers.size()!=3)return false;
		int num=0;
		for (Poker poker : pokers) {
			if(poker.getNumber().getId()==11 || poker.getNumber().getId() == 12 || poker.getNumber().getId() == 13) {
				num++;
			}
		}
		return num==3?true:false;
	}

}
