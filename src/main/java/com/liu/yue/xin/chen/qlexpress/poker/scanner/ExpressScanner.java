package com.liu.yue.xin.chen.qlexpress.poker.scanner;

import java.util.ArrayList;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.module.PlayerPokers;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.task.BaseScanTask;

import lombok.extern.slf4j.Slf4j;

/**
 * 扑克牌规则扫描器
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@Slf4j
public class ExpressScanner {

	/**
	 * 进行扑克牌的扫描
	 * 
	 * @param pokers
	 *            扑克牌
	 * @param scanTasks
	 *            扫描任务组
	 * @param ids
	 * @param poker
	 *            癞子牌变成的扑克牌
	 * @param laizi
	 *            癞子牌
	 * @param laiziNum
	 *            癞子的数量
	 * @return 扫描之后的扑克牌组合
	 */
	public static ProkerCombo scan(List<Poker> pokers, List<Class<? extends BaseScanTask>> scanTasks, List<Integer> ids,
			Poker poker, Poker laizi, int laiziNum, long playerId, Object... pokerComboFactory) {
		// 校验扑克牌是否符合
		if (!checkPoker(pokers)) {
			log.info("不是正确的扑克牌   请输入正确的扑克牌！ 在进行扫描！");
			return null;
		}
		try {
			for (Class<? extends BaseScanTask> scanTask : scanTasks) {
				BaseScanTask task = scanTask.newInstance();
				task.setPokers(pokers);
				task.setIds(ids);
				task.setLaiziChange(poker);
				task.setLaizi(laizi);
				task.setLaiziNum(laiziNum);
				task.setPlayerId(playerId);
				return task.scan(pokerComboFactory);
			}
		} catch (Exception e) {
			log.info("扫描规则 出现错误！");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 进行扑克牌的扫描
	 * 
	 * @param pokers
	 *            扑克牌
	 * @param scanTasks
	 *            扫描任务组
	 * @param ids
	 * @param poker
	 *            癞子牌变成的扑克牌
	 * @param laizi
	 *            癞子牌
	 * @param laiziNum
	 *            癞子的数量
	 * @return 扫描之后的扑克牌组合
	 */
	public static ProkerCombo scanBaiJiaLe(List<Poker> pokers, List<Class<? extends BaseScanTask>> scanTasks,
			List<Integer> ids, Poker poker, Poker laizi, int laiziNum, long playerId, Object... pokerComboFactory) {
		try {
			for (Class<? extends BaseScanTask> scanTask : scanTasks) {
				BaseScanTask task = scanTask.newInstance();
				task.setPokers(pokers);
				task.setIds(ids);
				task.setLaiziChange(poker);
				task.setLaizi(laizi);
				task.setLaiziNum(laiziNum);
				task.setPlayerId(playerId);
				return task.scan(pokerComboFactory);
			}
		} catch (Exception e) {
			log.info("扫描规则 出现错误！");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 多个玩家扑克牌 进行比较 并返回比较之后的牌组合 （已经进行排名的牌组合列表）
	 * 
	 * @param scanTasks
	 * @return
	 */
	public static List<ProkerCombo> scan2(List<PlayerPokers> players, List<Class<? extends BaseScanTask>> scanTasks) {
		List<ProkerCombo> combos = new ArrayList<>();
		for (PlayerPokers player : players) {
			List<Poker> pokers = player.getPokers();
			if (!checkPoker(pokers)) {
				System.out.println("不是正确的扑克牌   请输入正确的扑克牌！ 在进行扫描！");
				return null;
			}
			try {
				for (Class<? extends BaseScanTask> scanTask : scanTasks) {
					BaseScanTask task = scanTask.newInstance();
					task.setPokers(pokers);
					task.setPlayerId(player.getPlayerId());
					ProkerCombo combo = task.scan();
					if (combo != null) {
						combos.add(combo);
					}
				}

			} catch (Exception e) {
				System.out.println("扫描规则 出现错误！");
				e.printStackTrace();
			}
		}
		// 进行排序
		// combos.sort(new Comparator<ProkerCombo>() {
		// @Override
		// public int compare(ProkerCombo o1, ProkerCombo o2) {
		// if(o1==null || o2==null)return 0;
		// if(o1.getNum()>o2.getNum())return -1;
		// if(o1.getNum()<o2.getNum())return 1;
		// return 0;
		// }
		// });
		return combos;
	}

	/**
	 * 检验输入的扑克牌是否合法
	 * 
	 * @param pokers
	 * @return true 合法 false 不合法
	 */
	private static boolean checkPoker(List<Poker> pokers) {
		int pokerId = 0;
		for (Poker poker : pokers) {
			if (poker.getId() == pokerId) {
				return false;
			}
			pokerId = poker.getId();
		}
		return true;
	}

	/**
	 * 进行扑克牌的扫描
	 * 
	 * @param pokers
	 *            扑克牌
	 * @param scanTasks
	 *            扫描任务组
	 * @return 扫描之后的扑克牌组合
	 */
	public static ProkerCombo scan(List<Poker> pokers, List<Class<? extends BaseScanTask>> scanTasks, long playerId,
			Object... pokerComboFactory) {
		// 校验扑克牌是否符合
		if (!checkPoker(pokers)) {
			log.info("不是正确的扑克牌   请输入正确的扑克牌！ 在进行扫描！");
			return null;
		}
		try {
			for (Class<? extends BaseScanTask> scanTask : scanTasks) {
				BaseScanTask task = scanTask.newInstance();
				task.setPokers(pokers);
				task.setPlayerId(playerId);
				return task.scan(pokerComboFactory);
			}
		} catch (Exception e) {
			log.info("扫描规则 出现错误！");
			e.printStackTrace();
		}

		return null;
	}

}
