package com.liu.yue.xin.chen.qlexpress.poker.combo;

import java.util.ArrayList;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.operator.NameMapping;
import com.liu.yue.xin.chen.qlexpress.poker.operator.PokerRule;
import com.ql.util.express.DefaultContext;

/**
 * 牌型组合工具
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class ComboUtil {
	@SuppressWarnings("unchecked")
	public static ProkerCombo parseScanResultToCombos(PokerRule rule, DefaultContext<String, Object> context,
			long playerId, Poker laizi, Poker laiziChange, int laiziNum, Object... pokerComboFactory) {
		List<Poker> pokers;
		ProkerCombo prokerCombo = null;
		switch (rule.getType()) {
		case "炸金花":
			pokers = (List<Poker>) context.get("牌序组合");
			if (pokers != null) {
				if (laiziNum == 1) {
					int indexOf = pokers.indexOf(laiziChange);
					List<Poker> pos = new ArrayList<Poker>();
					for (Poker poker : pokers) {
						pos.add(poker);
					}
					pokers.set(indexOf, laizi); // 替换回癞子
					prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, pos,
							rule.getRate());
				} else {
					prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId,
							rule.getRate());
				}
			}
			break;
		case "三公":
			pokers = (List<Poker>) context.get("牌序组合");
			if (pokers != null) {
				prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, rule.getRate());
			}
			break;
		case "百家乐":
			pokers = (List<Poker>) context.get("牌序组合");
			List<Poker> comPokers = (List<Poker>) context.get(NameMapping.BAI_JIA_POKERS.getName());
			if (pokers != null) {
				prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, rule.getRate(),
						comPokers);
			}
			break;
		case "牛牛":
			pokers = (List<Poker>) context.get("牌序组合");
			if (pokers != null) {
				prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, rule.getRate());
			}
			break;
		case "庄家牛":
			pokers = (List<Poker>) context.get("庄家牛牌序组合");
			if (pokers != null) {
				prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, rule.getRate());
			}
			break;
		case "牛牛1":
			pokers = (List<Poker>) context.get("牌序组合");
			if (pokers != null) {
				List<Poker> sanPoker = null; // 可以组合成牛的 三张牌
				List<Poker> twoPoker = null; //
				if (rule.getId() <= 10) {
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
									sanPoker = new ArrayList<>();
									sanPoker.add(poker);
									sanPoker.add(poker2);
									sanPoker.add(poker3);
								}
							}
						}
					}
					if (sanPoker != null) {
						twoPoker = new ArrayList<>();
						for (Poker poker : pokers) {
							if (sanPoker.contains(poker))
								continue;
							twoPoker.add(poker);
						}
					}
				}
				prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, rule.getRate(),
						sanPoker, twoPoker);
			}
			break;
		case "牛牛2":
			pokers = (List<Poker>) context.get("牌序组合");
			if (pokers != null) {
				List<Poker> sanPoker = null; // 可以组合成牛的 三张牌
				List<Poker> twoPoker = null; //
				if (rule.getId() <= 10) {
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
									sanPoker = new ArrayList<>();
									sanPoker.add(poker);
									sanPoker.add(poker2);
									sanPoker.add(poker3);
								}
							}
						}
					}
					if (sanPoker != null) {
						twoPoker = new ArrayList<>();
						for (Poker poker : pokers) {
							if (sanPoker.contains(poker))
								continue;
							twoPoker.add(poker);
						}
					}
				}
				prokerCombo = new ProkerCombo(pokers, rule.getId(), rule.getName(), laiziNum, playerId, rule.getRate(),
						sanPoker, twoPoker);
			}
			break;
		default:
			PokerComboFactory factory = (PokerComboFactory) pokerComboFactory[0];
			prokerCombo = factory.create(context, rule);
			break;
		}
		return prokerCombo;
	}
}
