package com.liu.yue.xin.chen.qlexpress.poker.scanner.task;

import java.util.ArrayList;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.combo.ComboUtil;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.operator.NameMapping;
import com.liu.yue.xin.chen.qlexpress.poker.operator.PokerRule;
import com.liu.yue.xin.chen.qlexpress.poker.operator.QLExpressUtil;
import com.ql.util.express.DefaultContext;

/**
 * 基础扫描基类
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public abstract class BaseScanTask {

	/**
	 * 执行扫描的规则
	 * 
	 * @return
	 * @bk https://home.cnblogs.com/u/huanuan/
	 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
	 * @Author 六月星辰 2020年4月22日
	 */
	protected abstract List<PokerRule> getRules();

	/**
	 * 参与扫描的扑克牌
	 */
	protected List<Poker> pokers;
	/**
	 * 要进行的扫描的规则id
	 */
	private List<Integer> ids = new ArrayList<>();
	/**
	 * 玩家id
	 */
	private long playerId;
	/**
	 * 癞子
	 */
	private Poker laizi;
	/**
	 * 癞子变成的牌
	 */
	private Poker laiziChange;
	private int laiziNum;

	public ProkerCombo scan(Object... pokerComboFactory) {
		DefaultContext<String, Object> context = new DefaultContext<>();
		initContext(pokers, context);
		ProkerCombo combo = null;
		for (PokerRule rule : getRules()) {
			if (ids.size() > 0) {
				if (!ids.contains(rule.getId()))
					continue;
			}
			boolean execute = QLExpressUtil.execute(rule.getExpress(), context);
			if (execute) {
				// 解析 并封装
				combo = ComboUtil.parseScanResultToCombos(rule, context, playerId, laizi, laiziChange, laiziNum,
						pokerComboFactory);
				// 返回扑克牌的组合
				break;
			}
		}
		return combo;
	}

	/**
	 * 初始化扫描需要用到的数据
	 */
	private void initContext(List<Poker> pokers, DefaultContext context) {
		List<Integer> pokersId = new ArrayList<>();
		for (Poker po : pokers) {
			pokersId.add(po.getId());
		}
		context.put(NameMapping.HAND_POKERS.toString(), pokersId);
		context.put(NameMapping.BAI_JIA_POKERS.getName().toString(), pokers);
	}

	public List<Poker> getPokers() {
		return pokers;
	}

	public void setPokers(List<Poker> pokers) {
		this.pokers = pokers;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Poker getLaizi() {
		return laizi;
	}

	public void setLaizi(Poker laizi) {
		this.laizi = laizi;
	}

	public Poker getLaiziChange() {
		return laiziChange;
	}

	public void setLaiziChange(Poker laiziChange) {
		this.laiziChange = laiziChange;
	}

	public int getLaiziNum() {
		return laiziNum;
	}

	public void setLaiziNum(int laiziNum) {
		this.laiziNum = laiziNum;
	}

}
