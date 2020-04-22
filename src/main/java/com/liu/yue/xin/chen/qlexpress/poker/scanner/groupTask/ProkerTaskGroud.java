package com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask;

import java.util.Arrays;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.BaiJiaLeScanTask;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.BaiNiuTask_1;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.BaiNiuTask_2;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.BankerNiuScanTask;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.FriedFlowerPokerTask;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.NiuNiuScanTask;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.base.SanGongTask;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.task.BaseScanTask;

/**
 * 扑克牌 扫描任务分组
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class ProkerTaskGroud {
	/**
	 * 牛牛 规则任务
	 */
	public static final List<Class<? extends BaseScanTask>> NIUNIU = Arrays.asList(NiuNiuScanTask.class);
	/**
	 * 炸金花 规则任务
	 */
	public static final List<Class<? extends BaseScanTask>> FIRED_FLOWER = Arrays.asList(FriedFlowerPokerTask.class);
	/**
	 * 三公 规则任务
	 */
	public static final List<Class<? extends BaseScanTask>> SAN_GONG = Arrays.asList(SanGongTask.class);

	/**
	 * 百人牛牛低倍场规则任务组
	 */
	public static final List<Class<? extends BaseScanTask>> BAINIU_GROUP_LOW = Arrays.asList(BaiNiuTask_1.class);

	/**
	 * 百人牛牛高倍场规则任务组
	 */
	public static final List<Class<? extends BaseScanTask>> BAINIU_GROUP_HIGH = Arrays.asList(BaiNiuTask_2.class);

	/**
	 * 庄家牛 规则任务 (抢庄牛牛用于判断机器人是否要进行抢庄)
	 */
	public static final List<Class<? extends BaseScanTask>> BANKER_NIUNIU = Arrays.asList(BankerNiuScanTask.class);

	/**
	 * 百家乐 规则任务 (
	 */
	public static final List<Class<? extends BaseScanTask>> BAI_JIA_LE = Arrays.asList(BaiJiaLeScanTask.class);
}
