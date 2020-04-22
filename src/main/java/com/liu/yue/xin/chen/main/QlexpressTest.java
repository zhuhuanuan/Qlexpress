package com.liu.yue.xin.chen.main;

import java.util.ArrayList;
import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.ExpressScanner;
import com.liu.yue.xin.chen.qlexpress.poker.scanner.groupTask.ProkerTaskGroud;
import com.liu.yue.xin.chen.qlexpress.xmlUtil.XmlExpress;

/**
 * 规则测试
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class QlexpressTest {

	public static void main(String[] args) {
		XmlExpress.init();
		System.err.println("规则加载");
		Poker.init();

		List<Poker> pokers = new ArrayList<>();

		pokers.add(Poker.BLOCK_K);
		pokers.add(Poker.HEART_K);
		pokers.add(Poker.SPADE_J);
		pokers.add(Poker.SPADE_Q);
		List<Integer> ids = new ArrayList<>();
		ids.add(105);
		ids.add(101);
		ids.add(102);
		ids.add(103);
		ids.add(104);
		ProkerCombo combo = ExpressScanner.scan(pokers, ProkerTaskGroud.BANKER_NIUNIU, ids, null, null, 0, 100001);
		System.out.println("组合牌型 ----》" + combo.toString());

	}

}
