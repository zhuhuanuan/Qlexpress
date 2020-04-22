package com.liu.yue.xin.chen.qlexpress.poker.function.niuniu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 * 牛牌组合 排序 将牌进行排序 从大到小进行排序
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@SuppressWarnings("unchecked")
public class CalvesPaixu extends Operator {

	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Integer> pokerIds = (List<Integer>) list[0];
		List<Poker> pokers = new ArrayList<>(pokerIds.size());
		for (Integer id : pokerIds) {
			Poker poker = Poker.parseFromId(id);
			pokers.add(poker);
		}
		// 进行一下 排序
		pokers.sort(new Comparator<Poker>() {
			@Override
			public int compare(Poker o1, Poker o2) {
				if (o1.getNumber().getNum() > o2.getNumber().getNum())
					return 1;
				else if (o1.getNumber().getNum() < o2.getNumber().getNum())
					return -1;
				else if (o1.getType().getId() > o2.getType().getId())
					return 1;
				else if (o1.getType().getId() < o2.getType().getId())
					return -1;
				return 0;
			}
		});
		return pokers;
	}

}
