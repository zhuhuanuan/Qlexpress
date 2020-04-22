package com.liu.yue.xin.chen.qlexpress.poker.function.sangong;

import java.util.Comparator;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;


/**
 * 三公牌型比较器
 */
public class SanGongCompareUtil {
	
	
	/**
	 * 两个牌型比较
	 * @param player1 玩家1的牌型
	 * @param player2 玩家2的牌型
	 * @return true 玩家1赢了  false 玩家2赢4了
	 */
	public static boolean compareTwo(ProkerCombo player1, ProkerCombo player2) {
		int comboId1 = player1.getId(); 		   //玩家1的牌型id
		int comboId2 = player2.getId();			   //玩家2的牌型id
		List<Poker> pokers = player1.getPokers();  //玩家1的扑克牌
		List<Poker> pokers2 = player2.getPokers(); //玩家2的扑克牌
		// 进行一下 排序
		pokers.sort(new Comparator<Poker>() {
			@Override
			public int compare(Poker o1, Poker o2) {
				if(o1.getNumber().getNum()>o2.getNumber().getNum())return 1;
				else if(o1.getNumber().getNum()<o2.getNumber().getNum())return -1;
				else if(o1.getType().getId()>o2.getType().getId())return 1;
				else if(o1.getType().getId()<o2.getType().getId())return -1;
				return 0;
			}
		});
		pokers2.sort(new Comparator<Poker>() {
			@Override
			public int compare(Poker o1, Poker o2) {
				if(o1.getNumber().getNum()>o2.getNumber().getNum())return 1;
				else if(o1.getNumber().getNum()<o2.getNumber().getNum())return -1;
				else if(o1.getType().getId()>o2.getType().getId())return 1;
				else if(o1.getType().getId()<o2.getType().getId())return -1;
				return 0;
			}
		});
		if(comboId1<comboId2) {
			return true;
		}else if(comboId1>comboId2) {
			return false;
		}else {
			//牌型相同 比较最大牌的牌值
			Poker p1MaxPoker = pokers.get(pokers.size()-1);//玩家1最大的牌
			Poker p2MaxPoker = pokers2.get(pokers2.size()-1);//玩家2最大的牌
			if(p1MaxPoker.getNumber().getNum()>p2MaxPoker.getNumber().getNum()) {
				return true;
			}else if(p1MaxPoker.getNumber().getNum()<p2MaxPoker.getNumber().getNum()) {
				return false;
			}else {
				//玩家的牌值一样 比较玩家的花色
				if(p1MaxPoker.getType().getId()>p2MaxPoker.getType().getId()) {
					return true;
				}else if(p1MaxPoker.getType().getId()>p2MaxPoker.getType().getId()) {
					return false;
				}
			}
		}
		return false;
	}
	
	
	
	/**
	 * 两个牌型比较 （只是用于玩家选牌型时候）
	 * @param player1 玩家1的牌型
	 * @param player2 玩家2的牌型
	 * @return true 玩家1赢了  false 玩家2赢4了
	 */
	public static boolean compareTwoOfChooce(ProkerCombo player1, ProkerCombo player2) {
		int comboId1 = player1.getId(); 		   //玩家1的牌型id
		int comboId2 = player2.getId();			   //玩家2的牌型id
		List<Poker> pokers = player1.getPokers();  //玩家1的扑克牌
		List<Poker> pokers2 = player2.getPokers(); //玩家2的扑克牌
		// 进行一下 排序
		pokers.sort(new Comparator<Poker>() {
			@Override
			public int compare(Poker o1, Poker o2) {
				if(o1.getNumber().getNum()>o2.getNumber().getNum())return 1;
				else if(o1.getNumber().getNum()<o2.getNumber().getNum())return -1;
				else if(o1.getType().getId()>o2.getType().getId())return 1;
				else if(o1.getType().getId()<o2.getType().getId())return -1;
				return 0;
			}
		});
		pokers2.sort(new Comparator<Poker>() {
			@Override
			public int compare(Poker o1, Poker o2) {
				if(o1.getNumber().getNum()>o2.getNumber().getNum())return 1;
				else if(o1.getNumber().getNum()<o2.getNumber().getNum())return -1;
				else if(o1.getType().getId()>o2.getType().getId())return 1;
				else if(o1.getType().getId()<o2.getType().getId())return -1;
				return 0;
			}
		});
		if(comboId1<comboId2) {
			return true;
		}else if(comboId1>comboId2) {
			return false;
		}else {
			//牌型相同 比较最大牌的牌值
			Poker p1MaxPoker = pokers.get(pokers.size()-1);//玩家1最大的牌
			Poker p2MaxPoker = pokers2.get(pokers2.size()-1);//玩家2最大的牌
			if(p1MaxPoker.getId() > p2MaxPoker.getId()) {
				return true;
			}else if(p1MaxPoker.getId() < p2MaxPoker.getId()) {
				return false;
			}else {
				Poker poker = pokers.get(1);//玩家1第二大的牌
				Poker poker2 = pokers2.get(1);//玩家2第二大的牌
				if(poker.getId() > poker2.getId()) {
					return true;
				}else if(poker.getId()< poker2.getId()){
					return false;
				}else {
					Poker poker1 = pokers.get(0);//玩家1第二大的牌
					Poker poker21 = pokers2.get(0);//玩家2第二大的牌
					if(poker1.getId()>poker21.getId()) {
						return true;
					}else {
						return false;
					}
				}
			}
		}
	}
	
}
