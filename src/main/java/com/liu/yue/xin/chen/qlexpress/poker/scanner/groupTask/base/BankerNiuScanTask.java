package com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.operator.PokerRule;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.task.BaseScanTask;
import com.liu.yue.xin.chen.qlexpress.xmlUtil.PokerXmlExpress;

/**
 * 庄家牛 扫描任务组
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class BankerNiuScanTask extends BaseScanTask {

	@Override
	protected List<PokerRule> getRules() {
		return PokerXmlExpress.getRulesByType("庄家牛");
	}

}
