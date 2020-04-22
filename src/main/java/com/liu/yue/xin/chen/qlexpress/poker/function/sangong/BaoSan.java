package com.liu.yue.xin.chen.qlexpress.poker.function.sangong;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 三公- 爆三 
 * 1.任意三张3组成的牌型
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class BaoSan extends Operator{

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers=	(List<Poker>) list[0];
		long count = pokers.stream().filter(e->e.getNumber().getId()==3).count();
		return count==3?true:false;
	}

}
