package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.ArrayList;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 牛点数</br>
 * 10 牛牛 任意三张手牌之和为10的倍数，其余两张牌之和为10的倍数</br>
 * 9 牛九 任意三张手牌之和为10的倍数，其余两张牌之和个位数为9</br>
 * 8 牛八 任意三张手牌之和为10的倍数，其余两张牌之和个位数为8</br>
 * 7 牛七 任意三张手牌之和为10的倍数，其余两张牌之和个位数为7</br>
 * 6 牛六 任意三张手牌之和为10的 倍数，其余两张牌之和个位数为6</br>
 * 5 牛五 任意三张手牌之和为10的倍数，其余两张牌之和个位数为5</br>
 * 4 牛四 任意三张手牌之和为10的倍数，其余两张牌之和1个位数为4</br>
 * 3 牛三 任意三张手牌之和为10的倍数，其余两张牌之和个位数为3</br>
 * 2 牛二 任意三张手牌之和为10的倍数，其余两张牌之和个位数为2</br>
 * 1 牛一 任意三张手牌之和为10的倍数，其余两张牌之和个位数为1</br>
 * 0 没牛 任意三张手牌之和不为10，且无法构成任何牌型
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@SuppressWarnings("unchecked")
public class CalvesNumber extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers = (List<Poker>) list[0];
		boolean niuNum = false;
		List<Poker> sanPoker = null; // 可以组合成牛的 三张牌
		for (int m = 0; m <= 2; m++) {
			for (int n = m + 1; n <= 3; n++) {
				for (int z = n + 1; z <= 4; z++) {
					Poker poker = pokers.get(m); // 第一张牌
					int mm = poker.getNumber().getNiuNum();
					Poker poker2 = pokers.get(n);// 第二张牌
					int nn = poker2.getNumber().getNiuNum();
					Poker poker3 = pokers.get(z);// 第三张牌
					int zz = poker3.getNumber().getNiuNum();
					if ((mm + nn + zz) % 10 == 0) {
						niuNum = true;
						sanPoker = new ArrayList<>();
						sanPoker.add(poker);
						sanPoker.add(poker2);
						sanPoker.add(poker3);
						int num = 0;
						for (int x = 0; x <= 4; x++) {
							if (x != m && x != n && x != z) {
								num += pokers.get(x).getNumber().getNiuNum();
							}
						}
						if (num % 10 == 0) {
							return 10;
						}
					}
				}
			}

		}
		if (niuNum) {
			int num = 0;
			for (Poker poker : pokers) {
				num += poker.getNumber().getNiuNum();
			}
			return num % 10;
		}
		return 0;
	}

}
