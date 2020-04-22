package com.liu.yue.xin.chen.qlexpress.poker.operator;

import com.liu.yue.xin.chen.qlexpress.poker.function.Add;
import com.liu.yue.xin.chen.qlexpress.poker.function.baijiale.BcPaiXu;
import com.liu.yue.xin.chen.qlexpress.poker.function.baijiale.BcSum;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.BaoZi;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.BigDuizi;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.Dan;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.JinHua;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.PaiXu;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.ShunJin;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.ShunZi;
import com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower.duizi;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.BankerBombCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.BankerCalvesNumber;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.BankerCalvesPaixu;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.BankerStreakyCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.BombCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.CalvesNumber;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.CalvesPaixu;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.FiveCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.GourdCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.OrderCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.SameFlowerCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.niuniu.StreakyCalves;
import com.liu.yue.xin.chen.qlexpress.poker.function.sangong.BaoSan;
import com.liu.yue.xin.chen.qlexpress.poker.function.sangong.DianShu;
import com.liu.yue.xin.chen.qlexpress.poker.function.sangong.SanGong;
import com.liu.yue.xin.chen.qlexpress.poker.function.sangong.SanTao;

public enum NameMapping {

	// Operator

	// Macro
	HAND_POKERS("手牌",null),
	LAIZI("癞子",null),
	BAI_JIA_POKERS("基本手牌",null),
	
	//function
	 ADD("加上", Add.class), 
	 
	//炸金花
	PAI_XU("排序",PaiXu.class),
	DAN("单牌",Dan.class),
	BAO_ZI("豹子",BaoZi.class),
	SHUN_JIN("顺金",ShunJin.class),
	JIN_HUA("金花",JinHua.class),
	SHUN_ZI("顺子",ShunZi.class),
	DA_DUI_ZI("大对子",BigDuizi.class),
	DUI_ZI("对子",duizi.class),
	//三公
	BAO_SAN("爆三",BaoSan.class),
	SAN_TIAO("三条",SanTao.class),
	SAN_GONG("三公",SanGong.class),
	DIAN_SHU("点数",DianShu.class), 
	
	//牛牛
	CALVES_PAIXU("牛牛排序",CalvesPaixu.class), 
	FIVE_CALVES("五小牛",FiveCalves.class), 
	BOMB_CATTLE("炸弹牛",BombCalves.class), 
	GOURD_CATTLE("葫芦牛",GourdCalves.class), 
	SAME_FLOWER_CATTLE("同花牛",SameFlowerCalves.class), 
	STREAKY_CATTLE("五花牛",StreakyCalves.class), 
	ORDER_CATTLE("顺子牛",OrderCalves.class),
	CATTLE_NUMBER("牛点数",CalvesNumber.class),
	
	//百家乐
	BC_PAIXU("百家乐排序",BcPaiXu.class),
	BC_SUM("百家乐点数和",BcSum.class),
	
	//庄家牛
	BANKER_BOMB_PAIXU("庄家牛排序",BankerCalvesPaixu.class), 
	BANKER_BOMB_CATTLE("庄家炸弹牛",BankerBombCalves.class), 
	BANKER_CATTLE_NUMBER("庄家牛点数",BankerCalvesNumber.class),
	BANKER_STREAKY_CATTLE("庄家五花牛",BankerStreakyCalves.class)
	;

	private String name;

	private Class clazz;

	NameMapping(String name, Class clazz) {
		this.name = name;
		this.clazz = clazz;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
}
