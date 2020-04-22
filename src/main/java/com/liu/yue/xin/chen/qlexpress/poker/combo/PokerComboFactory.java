package com.liu.yue.xin.chen.qlexpress.poker.combo;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.operator.PokerRule;
import com.ql.util.express.DefaultContext;

/**
 * 生成一副PokerCombo的接口
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public interface PokerComboFactory {
	/**
	 * 生成一副PokerCombo
	 *
	 * @return
	 */
	ProkerCombo create(DefaultContext<String, Object> context, PokerRule rule);
}
