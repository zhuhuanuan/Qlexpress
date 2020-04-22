package com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.operator.PokerRule;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.task.BaseScanTask;
import com.liu.yue.xin.chen.qlexpress.xmlUtil.XmlExpress;

/**
 * 三公任务组
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class SanGongTask extends BaseScanTask {
	@Override
	protected List<PokerRule> getRules() {
		return XmlExpress.getRulesByType("三公");
	}
}
