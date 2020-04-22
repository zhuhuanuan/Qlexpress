package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.Type;
import com.ql.util.express.Operator;



/**
 * 计算炸金花 组合
 * 
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class FiredFlower extends Operator{
	private static final long serialVersionUID = 1L;
	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Integer>pokerIds=(List<Integer>) list[0];
		List<Poker> pokers=new ArrayList<>(pokerIds.size());
		for (Integer id : pokerIds) {
			Poker poker = Poker.parseFromId(id);
			pokers.add(poker);
		}
		// 进行一下 排序
		pokers.sort(new Comparator<Poker>() {
			@Override
			public int compare(Poker o1, Poker o2) {
				if(o1.getNumber().getId()>o2.getNumber().getId())return 1;
				else if(o1.getNumber().getId()<o2.getNumber().getId())return -1;
				else if(o1.getType().getId()>o2.getType().getId())return 1;
				else if(o1.getType().getId()<o2.getType().getId())return -1;
				return 0;
			}
		});
		
		
		
		
		
		
		
		// 豹子 检查
		/**
		 * 根据牌型进行分类
		 */
		 Map<Type, List<Poker>> pokerByType= pokers.stream().collect(Collectors.groupingBy(Poker::getType, Collectors.toList()));
		 /**
		  * 根据牌的数值进行分类
		  */
		 Map<PokerNumber, List<Poker>> pokerByNum= pokers.stream().collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));
		return pokerByNum;
	}
	/**
	 * 检查是否是顺子
	 * @param pokers
	 * @return
	 */
	private static  boolean checkShunZi(List<Poker> pokers) {
		Poker poker = pokers.get(0);
		Poker poker1 = pokers.get(1);
		Poker poker2 = pokers.get(2);
		if(((poker1.getNumber().getId()-1)==(poker.getNumber().getId())) &&((poker1.getNumber().getId()+1)==(poker2.getNumber().getId()))) {
			return true;
		}
		 return false;
	}
	public static void main(String[] args) {
		List<Poker> pokers=new ArrayList<>();
		pokers.add(Poker.BLOCK_3);
		pokers.add(Poker.HEART_4);
		pokers.add(Poker.CLUB_5);
		boolean checkShunZi = checkShunZi(pokers);
		System.out.println(checkShunZi);
	}
}
