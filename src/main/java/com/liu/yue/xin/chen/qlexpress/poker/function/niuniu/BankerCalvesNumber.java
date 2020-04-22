package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 庄家牛点数
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class BankerCalvesNumber extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		for (int m = 0; m <= 1; m++) {
			for (int n = m + 1; n <= 2; n++) {
				for (int z = n + 1; z <= 3; z++) {
					Poker poker = pokers.get(m); // 第一张牌
					int mm = poker.getNumber().getNiuNum();
					Poker poker2 = pokers.get(n);// 第二张牌
					int nn = poker2.getNumber().getNiuNum();
					Poker poker3 = pokers.get(z);// 第三张牌
					int zz = poker3.getNumber().getNiuNum();
					if ((mm + nn + zz) % 10 == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
