package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.PokerNumber;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker.Type;

/**
 * 炸金花牌型 比较器
 * 
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class FFCompareUtil {

	/**
	 * 牌型的id 匹配规则列表的id
	 */
	public static final int BAOZI = 1; // 豹子
	public static final int SHUNJIN = 2; // 顺金
	public static final int JINHUA = 3; // 金花
	public static final int SHUNZI = 4; // 顺子
	public static final int DADUI = 5; // 大对子
	public static final int DUIZI = 6; // 对子
	public static final int DAN = 7; // 单牌

	/**
	 * 两个玩家的比较（含有癞子）
	 * 
	 * @param player1
	 *            玩家1的牌型组合
	 * @param player2
	 *            玩家2的牌型组合
	 * @param baozi235
	 *            游戏模式是否豹子235 true 是 false 否
	 * @return true：player1 赢 false：player1--》 输
	 */
	public static boolean twoCompare(ProkerCombo player1, ProkerCombo player2, boolean baozi235) {
		int id = player1.getId();
		int id2 = player2.getId();
		List<Poker> P1pokers = player1.getPokers();
		List<Poker> P2pokers = player2.getPokers();
		if (player1.getLaiziNum() == 1) {
			P1pokers = player1.getLaiziPoker();
		}

		if (player2.getLaiziNum() == 1) {
			P2pokers = player2.getLaiziPoker();
		}

		Poker P1poker = P1pokers.get(0);
		Poker P1poker2 = P1pokers.get(1);
		Poker P1poker3 = P1pokers.get(2);

		Poker P2poker = P2pokers.get(0);
		Poker P2poker2 = P2pokers.get(1);
		Poker P2poker3 = P2pokers.get(2);
		if (player1.getLaiziNum() == 2) {
			// 玩家1 有两个癞子
			if (id < id2) {
				if (baozi235 && player2.getId() == DAN) {
					if (P2poker.getNumber().getId() == 2 && P2poker2.getNumber().getId() == 3
							&& P2poker3.getNumber().getId() == 5) {
						return false;
					}
				}
				return true;
			} else if (id == id2) {
				Poker p = P1pokers.stream().filter(e -> e.getType().getId() != Type.JOKER.getId())
						.collect(Collectors.toList()).get(0);
				if (p.getNumber().getId() >= P2poker3.getNumber().getId())
					return true;
			}
			return false;
		}

		if (player2.getLaiziNum() == 2) {
			// 玩家1 有两个癞子
			if (id2 < id) {
				if (baozi235 && player1.getId() == DAN) {
					if (P1poker.getNumber().getId() == 2 && P1poker2.getNumber().getId() == 3
							&& P1poker3.getNumber().getId() == 5) {
						return true;
					}
				}
				return false;
			} else if (id == id2) {
				Poker p = P2pokers.stream().filter(e -> e.getType().getId() != Type.JOKER.getId())
						.collect(Collectors.toList()).get(0);
				if (p.getNumber().getId() >= P1poker3.getNumber().getId())
					return false;
			}
			return true;
		}

		if (id < id2) { // 牌型id 越小 牌型越大
			if (baozi235 && id == BAOZI && id2 == DAN) {
				if (P2poker.getNumber().getId() == 2 && P2poker2.getNumber().getId() == 3
						&& P2poker3.getNumber().getId() == 5) {
					// 如果玩家2豹子235 玩家1 输
					return false;
				}
			}
			return true;
		} else if (id == id2) {
			// 牌型相同
			if (id == BAOZI) {
				// 按最大的牌值进行比较
				if (P1poker3.getNumber().getId() > P2poker3.getNumber().getId()) {
					return true;
				} else if (P1poker3.getNumber().getId() == P2poker3.getNumber().getId()) {
					if (player1.getLaiziNum() == 1 && player2.getLaiziNum() == 1) {
						Poker poker = player1.getPokers().stream().filter(e -> e.getType() == Type.JOKER)
								.collect(Collectors.toList()).get(0);
						Poker poker2 = player2.getPokers().stream().filter(e -> e.getType() == Type.JOKER)
								.collect(Collectors.toList()).get(0);
						if (poker.getId() > poker2.getId()) {
							return true;
						} else {
							return false;
						}
					}
					if (P1poker3.getType().getId() >= P2poker3.getType().getId()) {
						return true;
					}
				} else {
					return false;
				}
			}
			if (id == JINHUA || id == SHUNJIN || id == SHUNZI || id == DAN) {
				if (id == SHUNJIN || id == SHUNZI) {
					// p1 是123 p2 不是
					if (P1poker3.getNumber().getId() == PokerNumber.A.getId()
							&& P1poker2.getNumber().getId() == PokerNumber.THREE.getId()
							&& P1poker.getNumber().getId() == PokerNumber.TWO.getId()) {
						if (P2poker3.getNumber().getId() != PokerNumber.A.getId()
								|| P2poker2.getNumber().getId() != PokerNumber.THREE.getId()
								|| P2poker.getNumber().getId() != PokerNumber.TWO.getId()) {
							return false;
						}
					}
					if (P2poker3.getNumber().getId() == PokerNumber.A.getId()
							&& P2poker2.getNumber().getId() == PokerNumber.THREE.getId()
							&& P2poker.getNumber().getId() == PokerNumber.TWO.getId()) {
						if (P1poker3.getNumber().getId() != PokerNumber.A.getId()
								|| P1poker2.getNumber().getId() != PokerNumber.THREE.getId()
								|| P1poker.getNumber().getId() != PokerNumber.TWO.getId()) {
							return true;
						}
					}
				}
				// 金花 先比较最大牌的牌值 在比较第二大的牌值 在比较第三大的牌值 最后比较最大牌值的花色
				if (P1poker3.getNumber().getId() > P2poker3.getNumber().getId()) {
					return true;
				} else if (P1poker3.getNumber().getId() == P2poker3.getNumber().getId()) {
					if (P1poker2.getNumber().getId() > P2poker2.getNumber().getId()) {
						return true;
					} else if (P1poker2.getNumber().getId() == P2poker2.getNumber().getId()) {
						if (P1poker.getNumber().getId() > P2poker.getNumber().getId()) {
							return true;
						} else if (P1poker.getNumber().getId() == P2poker.getNumber().getId()) {
							if (P1poker3.getId() > P2poker3.getId()) {
								return true;
							} else if (P1poker3.getId() == P2poker3.getId()) {
								if (player1.getLaiziNum() == 1 && player2.getLaiziNum() == 1) {
									Poker poker = player1.getPokers().stream().filter(e -> e.getType() == Type.JOKER)
											.collect(Collectors.toList()).get(0);
									Poker poker2 = player2.getPokers().stream().filter(e -> e.getType() == Type.JOKER)
											.collect(Collectors.toList()).get(0);
									if (poker.getId() > poker2.getId()) {
										return true;
									} else {
										return false;
									}
								} else if (player1.getLaiziNum() == 1) {
									return true;
								}
							} else {
								return false;
							}
						}
					}
				}
			}
			if (id == DUIZI || id == DADUI) {
				// 对子 先比较对子的大小 在比单牌 在比较最大牌的花色
				// 先将牌按牌值进行分类
				Map<PokerNumber, List<Poker>> P1collect = P1pokers.stream()
						.collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));
				Map<PokerNumber, List<Poker>> P2collect2 = P2pokers.stream()
						.collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));
				Collection<List<Poker>> P1values = P1collect.values();
				Collection<List<Poker>> P2values2 = P2collect2.values();
				Poker p1Duizi = null; // p1的单牌
				Poker P2Dui = null; // p2的单牌
				for (List<Poker> list : P1values) {
					if (list.size() == 2) {
						for (List<Poker> list2 : P2values2) {
							if (list2.size() == 2) {
								if (list.get(0).getNumber().getId() > list2.get(0).getNumber().getId()) {
									return true;
								} else if (list.get(0).getNumber().getId() < list2.get(0).getNumber().getId()) {
									return false;
								}
							} else if (list2.size() == 1) {
								P2Dui = list2.get(0);
							}
						}
					} else if (list.size() == 1) {
						p1Duizi = list.get(0);
					}
				}
				if (p1Duizi != null && P2Dui != null) {
					if (p1Duizi.getNumber().getId() > P2Dui.getNumber().getId()) {
						return true;
					} else if (p1Duizi.getNumber().getId() < P2Dui.getNumber().getId()) {
						return false;
					} else {
						// 在进行最大牌的比较
						if (P1poker3.getId() > P2poker3.getId()) {
							return true;
						} else if (P1poker3.getId() < P2poker3.getId()) {
							return false;
						}
					}
				}
				if (player1.getLaiziNum() == 1 && player2.getLaiziNum() == 1) {
					Poker poker = player1.getPokers().stream().filter(e -> e.getType() == Type.JOKER)
							.collect(Collectors.toList()).get(0);
					Poker poker2 = player2.getPokers().stream().filter(e -> e.getType() == Type.JOKER)
							.collect(Collectors.toList()).get(0);
					if (poker.getId() > poker2.getId()) {
						return true;
					} else {
						return false;
					}
				} else if (player1.getLaiziNum() == 1) {
					return true;
				}
				if (P1poker3.getNumber().getId() > P2poker3.getNumber().getId()) {
					return true;
				} else {
					if (P1poker3.getType().getId() > P2poker3.getType().getId()) {
						return true;
					}
				}
			}
		} else if (id > id2) {
			if (baozi235 && id2 == BAOZI && id == DAN) {
				if (P1poker.getNumber().getId() == 2 && P1poker2.getNumber().getId() == 3
						&& P1poker3.getNumber().getId() == 5) {
					// 如果玩家1 豹子235 玩家1 赢
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 比较235牌型大小
	 * 
	 * @param combos
	 *            多个牌型list
	 * @param baozi235
	 *            是否235 吃豹子
	 * @return
	 */
	public static List<ProkerCombo> allCompare235(List<ProkerCombo> combos, boolean baozi235) {
		combos.sort(new Comparator<ProkerCombo>() {
			@Override
			public int compare(ProkerCombo o1, ProkerCombo o2) {
				if (null == o1 || null == o2)
					return 0;
				if (twoCompare(o1, o2, baozi235))
					return -1;
				else if (!twoCompare(o1, o2, baozi235))
					return 1;
				return 0;
			}
		});
		return combos;
	}

	/**
	 * 多个牌型进行比较（有癞子）
	 * 
	 * @param combos
	 *            多个牌型list
	 * @param baozi235
	 *            是否235 吃豹子
	 * @return
	 */
	public static List<ProkerCombo> allCompare(List<ProkerCombo> combos, boolean baozi235) {
		combos.sort(new Comparator<ProkerCombo>() {
			@Override
			public int compare(ProkerCombo o1, ProkerCombo o2) {
				if (null == o1 || null == o2)
					return 0;
				if (twoCompare(o1, o2, baozi235))
					return -1;
				else if (!twoCompare(o1, o2, baozi235))
					return 1;
				return 0;
			}
		});

		// 检测是否有豹子 和单牌 235

		if (baozi235) {
			boolean isbaozi = false;
			boolean isbaozi235 = false;
			for (ProkerCombo prokerCombo : combos) {
				if (prokerCombo.getId() == FFCompareUtil.BAOZI) {
					isbaozi = true;
				}
				if (prokerCombo.getId() == FFCompareUtil.DAN) {
					List<Poker> pokers = prokerCombo.getPokers();
					if (pokers.get(0).getNumber() == PokerNumber.TWO && pokers.get(1).getNumber() == PokerNumber.THREE
							&& pokers.get(2).getNumber() == PokerNumber.FIVE) {
						isbaozi235 = true;
					}
				}
			}
			if (isbaozi && isbaozi235) {
				List<ProkerCombo> newlist = new ArrayList<>();
				List<ProkerCombo> newlist2 = new ArrayList<>();

				for (ProkerCombo prokerCombo : combos) {
					if (prokerCombo.getId() == FFCompareUtil.DAN) {
						List<Poker> pokers = prokerCombo.getPokers();
						if (pokers.get(0).getNumber() == PokerNumber.TWO
								&& pokers.get(1).getNumber() == PokerNumber.THREE
								&& pokers.get(2).getNumber() == PokerNumber.FIVE) {
							newlist.add(prokerCombo);
						}
					} else {
						newlist2.add(prokerCombo);
					}
				}

				List<ProkerCombo> allCompare235 = allCompare235(newlist, false);
				for (ProkerCombo prokerCombo : newlist2) {
					allCompare235.add(prokerCombo);
				}
				return allCompare235;
			}
		}
		return combos;
	}

	/**
	 * 两种牌型的比较 （有癞子）
	 * 
	 * @param player1
	 *            玩家1的牌型
	 * @param player2
	 *            玩家2的牌型
	 * @param baozi235
	 *            是否是235吃豹子模式
	 * @return false：玩家1 输 true：玩家1 赢
	 */
	public static boolean twoCompareLaizi(ProkerCombo player1, ProkerCombo player2, boolean baozi235) {
		int laiziNum = player1.getLaiziNum(); // 玩家1的癞子个数
		int laiziNum2 = player2.getLaiziNum(); // 玩家2的癞子个数
		if (laiziNum == 0 && laiziNum2 == 0)
			return twoCompare(player1, player2, baozi235);
		int id = player1.getId(); // 玩家1的牌型id
		int id2 = player2.getId(); // 玩家2的牌型id
		List<Poker> P1pokers = player1.getPokers(); // 玩家1的扑克牌
		List<Poker> P2pokers = player2.getPokers(); // 玩家2的扑克牌
		Poker P1poker = P1pokers.get(0); // 玩家1 最小的牌
		Poker P1poker2 = P1pokers.get(1); // 玩家1中间的牌
		Poker P1poker3 = P1pokers.get(2); // 玩家1最大的牌
		Poker P2poker = P2pokers.get(0); // 玩家2最小的牌
		Poker P2poker2 = P2pokers.get(1); // 玩家2中间的牌
		Poker P2poker3 = P2pokers.get(2); // 玩家2最大的牌
		if (laiziNum == 1 && laiziNum2 == 0) {

			return oneLai(id, id2, P2pokers, P1poker2, P1poker3, P2poker, P2poker2, P2poker3);
		}
		if (laiziNum == 0 && laiziNum2 == 1) {
			return oneLai(id2, id, P1pokers, P2poker2, P2poker3, P2poker, P1poker2, P1poker3);
		}
		if (laiziNum == 2) {
			if (id == BAOZI && id2 == BAOZI) {
				if (P1poker.getNumber().getId() < P2poker3.getNumber().getId())
					return false;
			}
			return true;
		}
		if (laiziNum2 == 2) {
			if (id == BAOZI && id2 == BAOZI) {
				if (P2poker.getNumber().getId() < P1poker3.getNumber().getId())
					return true;
			}
			return false;
		}

		if (laiziNum == 1 && laiziNum2 == 1) {
			if (id < id2)
				return true;
			if (id == id2) {
				Poker laizi = P1pokers.stream().filter(e -> e.getType() == Type.JOKER).collect(Collectors.toList())
						.get(0);
				Poker laizi2 = P2pokers.stream().filter(e -> e.getType() == Type.JOKER).collect(Collectors.toList())
						.get(0);
				List<Poker> collect = P1pokers.stream().filter(e -> e.getType() != Type.JOKER)
						.collect(Collectors.toList());
				List<Poker> collect2 = P2pokers.stream().filter(e -> e.getType() != Type.JOKER)
						.collect(Collectors.toList());
				collect.sort(new Comparator<Poker>() {
					@Override
					public int compare(Poker o1, Poker o2) {
						if (o1 == null || o2 == null)
							return 0;
						if (o1.getNumber().getId() > o2.getNumber().getId())
							return 1;
						else if (o1.getNumber().getId() < o2.getNumber().getId())
							return -1;
						else if (o1.getType().getId() > o2.getType().getId())
							return 1;
						else if (o1.getType().getId() < o2.getType().getId())
							return -1;
						return 0;
					}
				});
				collect2.sort(new Comparator<Poker>() {
					@Override
					public int compare(Poker o1, Poker o2) {
						if (o1 == null || o2 == null)
							return 0;
						if (o1.getNumber().getId() > o2.getNumber().getId())
							return 1;
						else if (o1.getNumber().getId() < o2.getNumber().getId())
							return -1;
						else if (o1.getType().getId() > o2.getType().getId())
							return 1;
						else if (o1.getType().getId() < o2.getType().getId())
							return -1;
						return 0;
					}
				});
				if (id == BAOZI || id == DUIZI) {
					// 都是豹子 看弃掉癞子 比较最大牌值的大小 如果牌值相同 比大小王
					Poker poker = collect.get(collect.size() - 1);
					Poker poker2 = collect2.get(collect2.size() - 1);
					if (poker.getNumber().getId() > poker2.getNumber().getId())
						return true;
					else if (poker.getNumber().getId() == poker2.getNumber().getId()) {
						if (laizi.getNumber().getId() > laizi2.getNumber().getId())
							return true;
					}
				}
				if (id == JINHUA) {
					// 金花比较 先比最大牌牌值 在比花色
					// 比大小王
					if (laizi.getNumber().getId() > laizi2.getNumber().getId())
						return true;
				}
				if (id == SHUNJIN || id == SHUNZI) {
					// 顺金 或是 顺子
					boolean shun1 = Poker.checkShunZi2(collect);
					boolean shun2 = Poker.checkShunZi2(collect2);
					if (shun1 && shun2) { // 都是顺子 比较顺子的最大牌值 在比较大小王
						// 取最大的值进行 比较
						Poker poker = collect.get(1);
						Poker poker2 = collect2.get(1);
						if (poker.getNumber().getId() > poker2.getNumber().getId()) {
							return true;
						} else if (poker.getNumber().getId() == poker2.getNumber().getId()) {
							if (laizi.getNumber().getId() > laizi2.getNumber().getId())
								return true;
						}
					}
					if (!shun1 && !shun2) { // 都不是顺子 先比较 最大牌值的大小 在比较大小王
						// 取最大的值进行 比较
						Poker poker = collect.get(1);
						Poker poker2 = collect2.get(1);
						if (poker.getNumber().getId() > poker2.getNumber().getId()) {
							return true;
						} else if (poker.getNumber().getId() == poker2.getNumber().getId()) {
							if (laizi.getNumber().getId() > laizi2.getNumber().getId())
								return true;
						}
					}
					if (shun1 && !shun2) {
						Poker poker = collect.get(1); // 顺子
						Poker poker2 = collect2.get(1); // 非顺子
						int num = poker.getNumber().getId() - poker2.getNumber().getId();
						if (num >= 0) {
							return true;
						}
						if (-num == 1 && laizi.getNumber().getId() > laizi2.getNumber().getId())
							return true;
					}
					if (!shun1 && shun2) {
						Poker poker = collect.get(1); // 非顺子
						Poker poker2 = collect2.get(1); // 顺子
						int num = poker.getNumber().getId() - poker2.getNumber().getId();
						if (num > 1)
							return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 *            玩家1牌型
	 * @param id2
	 *            玩家2牌型
	 * @param P2pokers
	 *            玩家2的扑克牌
	 * @param P1poker2
	 *            玩家1中间的牌
	 * @param P1poker3
	 *            玩家1最大的牌
	 * @param P2poker
	 *            玩家2最小的牌
	 * @param P2poker2
	 *            玩家2中间的牌
	 * @param P2poker3
	 *            玩家2最大的牌
	 * @return true 玩家1赢 false 玩家1输
	 */
	private static boolean oneLai(int id, int id2, List<Poker> P2pokers, Poker P1poker2, Poker P1poker3, Poker P2poker,
			Poker P2poker2, Poker P2poker3) {
		if (id < id2) {
			return true;
		} else if (id == id2) {
			if (id == BAOZI) {
				if (P1poker3.getType() == Type.JOKER) {
					if (P1poker2.getNumber().getId() >= P2poker.getNumber().getId())
						return true;
				} else {
					if (P1poker3.getNumber().getId() >= P2poker3.getNumber().getId())
						return true;
				}
			}
			if (id == SHUNZI || id == SHUNJIN) {
				if (P1poker3.getType() != Type.JOKER) {
					if (P1poker3.getNumber().getId() > P2poker3.getNumber().getId())
						return true;

					if (P1poker3.getType().getId() > P2poker3.getType().getId())
						return true;
				} else {
					if (P1poker2.getNumber().getId() == PokerNumber.THREE.getId())
						return true;
					if (P1poker2.getNumber().getId() >= P2poker2.getNumber().getId())
						return true;
				}
			}
			if (id == DUIZI) {
				// 对第二个进行分类排序
				Map<PokerNumber, List<Poker>> collect = P2pokers.stream()
						.collect(Collectors.groupingBy(Poker::getNumber, Collectors.toList()));
				Collection<List<Poker>> values = collect.values();
				Poker poker = null;
				for (List<Poker> list : values) {
					if (list.size() == 2) {
						poker = list.get(0);
					}
				}
				if (P1poker3.getType() == Type.JOKER) {
					if (poker != null) {
						if (P1poker2.getNumber().getId() < poker.getNumber().getId())
							return false;
					}
				} else {
					if (poker != null) {
						if (P1poker3.getNumber().getId() < poker.getNumber().getId())
							return false;
					}
				}
				return true;
			}
			if (id == DAN || id == JINHUA) {
				return true;
			}
		}
		return false;
	}

}
