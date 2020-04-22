package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;


/**
 * 单牌
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@SuppressWarnings("unchecked")
public class Dan extends Operator{
	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers=	(List<Poker>) list[0];
		if(pokers.size()==3)return true;
		return false;
	}

}
