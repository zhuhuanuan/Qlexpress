package com.liu.yue.xin.chen.qlexpress.poker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;

/**
 * 扑克牌组合Combo
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class ProkerCombo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 该牌型组合的玩家id
	 */
	private long playerId;

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	/**
	 * 扑克牌 已经排好序在装进来
	 */
	private List<Poker> pokers;
	/**
	 * 未进行排序的扑克牌
	 */
	private List<Poker> comPokers;

	/**
	 * 癞子变成的牌
	 */
	private List<Poker> laiziPoker;
	/**
	 * 最大的扑克牌
	 */
	private Poker maxPoker;

	public ProkerCombo() {
	}

	/**
	 * 牌型的名称
	 */
	private String name;
	/**
	 * 牌型的id
	 */
	private int id;
	/**
	 * 牌型倍数
	 */
	private int rate;
	/**
	 * 癞子的数量
	 */
	private int laiziNum;
	private List<Poker> threes = new ArrayList<>();
	private List<Poker> twos = new ArrayList<>();

	public ProkerCombo(List<Poker> pokers, int id, String name, int laiziNum, long playerId, int rate,
			List<Poker> three, List<Poker> two) {
		this.pokers = pokers;
		this.id = id;
		this.name = name;
		this.laiziNum = laiziNum;
		this.maxPoker = pokers.get(pokers.size() - 1);
		this.playerId = playerId;
		this.rate = rate;
		this.threes = three;
		this.twos = two;
		List<Poker> tem = new ArrayList<>();
		tem.addAll(pokers);
		Collections.shuffle(tem);
		this.comPokers = tem;
	}

	public ProkerCombo(List<Poker> pokers, int id, String name, int laiziNum, long playerId, int rate) {
		this.pokers = pokers;
		this.id = id;
		this.name = name;
		this.laiziNum = laiziNum;
		this.maxPoker = pokers.get(pokers.size() - 1);
		this.playerId = playerId;
		this.rate = rate;
		List<Poker> tem = new ArrayList<>();
		tem.addAll(pokers);
		Collections.shuffle(tem);
		this.comPokers = tem;
	}

	public ProkerCombo(List<Poker> pokers, int id, String name, int laiziNum, long playerId, int rate,
			List<Poker> comPokers) {
		this.pokers = pokers;
		this.id = id;
		this.name = name;
		this.laiziNum = laiziNum;
		this.maxPoker = pokers.get(pokers.size() - 1);
		this.playerId = playerId;
		this.rate = rate;
		this.comPokers = comPokers;
	}

	public ProkerCombo(List<Poker> pokers, int id, String name, int laiziNum, long playerId, List<Poker> pos,
			int rate) {
		this.pokers = pokers;
		this.id = id;
		this.name = name;
		this.laiziNum = laiziNum;
		this.maxPoker = pokers.get(pokers.size() - 1);
		this.playerId = playerId;
		this.laiziPoker = pos;
		this.rate = rate;
		List<Poker> tem = new ArrayList<>();
		tem.addAll(pokers);
		Collections.shuffle(tem);
		this.comPokers = tem;
	}

	public List<Poker> getPokers() {
		return pokers;
	}

	public void setPokers(List<Poker> pokers) {
		this.pokers = pokers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLaiziNum() {
		return laiziNum;
	}

	public void setLaiziNum(int laiziNum) {
		this.laiziNum = laiziNum;
	}

	public List<Poker> getLaiziPoker() {
		return laiziPoker;
	}

	public void setLaiziPoker(List<Poker> laiziPoker) {
		this.laiziPoker = laiziPoker;
	}

	public Poker getMaxPoker() {
		return maxPoker;
	}

	public void setMaxPoker(Poker maxPoker) {
		this.maxPoker = maxPoker;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public List<Poker> getThrees() {
		return threes;
	}

	public void setThrees(List<Poker> threes) {
		this.threes = threes;
	}

	public List<Poker> getTwos() {
		return twos;
	}

	public void setTwos(List<Poker> twos) {
		this.twos = twos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Combo{" + " playerId=" + playerId + ", name=" + name + ", id=" + id + ", rate=" + rate + ", laiziNum="
				+ laiziNum + ", pokers=" + pokers + ", threes=" + threes + ", twos=" + twos + ", laiziPoker="
				+ laiziPoker + '}';
	}

	/** 获取三张牌 */
	public Poker getThree() {
		Map<Integer, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getPokerNum, Collectors.toList()));
		Set<Integer> keySet = collect.keySet();
		if (keySet.size() != 2)
			return null;
		for (Integer integer : keySet) {
			if (null == integer)
				continue;
			List<Poker> list = collect.get(integer);
			if (!list.isEmpty()) {
				if (list.size() == 3)
					return list.get(0);
			}
		}
		return null;
	}

	/** 获取4张牌 */
	public Poker getFour() {
		Map<Integer, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getPokerNum, Collectors.toList()));
		Set<Integer> keySet = collect.keySet();
		if (keySet.size() != 2)
			return null;
		for (Integer integer : keySet) {
			if (null == integer)
				continue;
			List<Poker> list = collect.get(integer);
			if (!list.isEmpty()) {
				if (list.size() == 4)
					return list.get(0);
			}
		}
		return null;
	}

	public List<Poker> getComPokers() {
		return comPokers;
	}

	/**
	 * 获取poker列表Str
	 * 
	 * @return
	 */
	public String getPokerStr() {
		return pokers.stream().map(e -> e.getId()).collect(Collectors.toList()).toString();
	}

	public boolean isDuiZi() {
		Map<PokerNumber, List<Poker>> collect = pokers.stream()
				.collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));
		Set<PokerNumber> keySet = collect.keySet();
		if (keySet.size() == 1)
			return true;
		return false;
	}

	/***
	 * 百家乐 是否进行了补牌操作
	 */
	public boolean isBuPoker() {
		if (pokers.size() >= 3)
			return true;
		return false;
	}

	/**
	 * 获取百家乐点数字符串
	 */
	public String baijiePotStr() {
		String str = "";
		int tem = comPokers.size();
		int temSun = 0;
		for (Poker poker : comPokers) {
			int poNum = poker.getPoNum();
			temSun = temSun + poNum;
			str = str + temSun;
			if (tem > 1) {
				str = str + ",";
			}
			tem = tem - 1;
		}
		return str;
	}

	/**
	 * 获取百家乐 扑克牌id字符串
	 */
	public String baijiaPokerId() {
		String str = "";
		int tem = comPokers.size();
		for (Poker poker : comPokers) {
			if (poker == null)
				continue;
			str = str + poker.getId();
			if (tem > 1) {
				str = str + ",";
			}
			tem = tem - 1;
		}
		return str;
	}

}
