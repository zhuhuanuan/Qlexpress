package com.liu.yue.xin.chen.qlexpress.poker.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;
import com.ql.util.express.instruction.op.OperatorBase;

/**
 * 规则执行器
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class QLExpressUtil {
	private static final ExpressRunner runner = new ExpressRunner();
	static {
		try {
			// 自定义Operator
			runner.addOperator(NameMapping.ADD.getName(), (Operator) NameMapping.ADD.getClazz().newInstance());

			// 自定义Macro
			runner.addMacro(NameMapping.HAND_POKERS.getName(), NameMapping.HAND_POKERS.toString());
			runner.addMacro(NameMapping.LAIZI.getName(), NameMapping.LAIZI.toString());
			runner.addMacro(NameMapping.BAI_JIA_POKERS.getName(), NameMapping.BAI_JIA_POKERS.toString());

			// 自定义Function

			runner.addFunction(NameMapping.PAI_XU.getName(),
					(OperatorBase) NameMapping.PAI_XU.getClazz().newInstance());// 炸金花 排序
			runner.addFunction(NameMapping.BAO_ZI.getName(),
					(OperatorBase) NameMapping.BAO_ZI.getClazz().newInstance());// 豹子
			runner.addFunction(NameMapping.SHUN_JIN.getName(),
					(OperatorBase) NameMapping.SHUN_JIN.getClazz().newInstance());// 顺金
			runner.addFunction(NameMapping.JIN_HUA.getName(),
					(OperatorBase) NameMapping.JIN_HUA.getClazz().newInstance());// 金花
			runner.addFunction(NameMapping.SHUN_ZI.getName(),
					(OperatorBase) NameMapping.SHUN_ZI.getClazz().newInstance());// 顺子
			runner.addFunction(NameMapping.DA_DUI_ZI.getName(),
					(OperatorBase) NameMapping.DA_DUI_ZI.getClazz().newInstance()); // 大对子
			runner.addFunction(NameMapping.DUI_ZI.getName(),
					(OperatorBase) NameMapping.DUI_ZI.getClazz().newInstance()); // 对子
			runner.addFunction(NameMapping.DAN.getName(), (OperatorBase) NameMapping.DAN.getClazz().newInstance()); // 单牌
			runner.addFunction(NameMapping.BAO_SAN.getName(),
					(OperatorBase) NameMapping.BAO_SAN.getClazz().newInstance()); // 爆三
			runner.addFunction(NameMapping.SAN_TIAO.getName(),
					(OperatorBase) NameMapping.SAN_TIAO.getClazz().newInstance()); // 三条
			runner.addFunction(NameMapping.SAN_GONG.getName(),
					(OperatorBase) NameMapping.SAN_GONG.getClazz().newInstance()); // 三公
			runner.addFunction(NameMapping.DIAN_SHU.getName(),
					(OperatorBase) NameMapping.DIAN_SHU.getClazz().newInstance()); // 点数

			runner.addFunction(NameMapping.CALVES_PAIXU.getName(),
					(OperatorBase) NameMapping.CALVES_PAIXU.getClazz().newInstance()); // 牛牛排序
			runner.addFunction(NameMapping.FIVE_CALVES.getName(),
					(OperatorBase) NameMapping.FIVE_CALVES.getClazz().newInstance()); // 五小牛
			runner.addFunction(NameMapping.BOMB_CATTLE.getName(),
					(OperatorBase) NameMapping.BOMB_CATTLE.getClazz().newInstance()); // 炸弹牛
			runner.addFunction(NameMapping.GOURD_CATTLE.getName(),
					(OperatorBase) NameMapping.GOURD_CATTLE.getClazz().newInstance()); // 葫芦牛
			runner.addFunction(NameMapping.SAME_FLOWER_CATTLE.getName(),
					(OperatorBase) NameMapping.SAME_FLOWER_CATTLE.getClazz().newInstance()); // 同花牛
			runner.addFunction(NameMapping.STREAKY_CATTLE.getName(),
					(OperatorBase) NameMapping.STREAKY_CATTLE.getClazz().newInstance()); // 五花牛
			runner.addFunction(NameMapping.ORDER_CATTLE.getName(),
					(OperatorBase) NameMapping.ORDER_CATTLE.getClazz().newInstance()); // 顺子牛
			runner.addFunction(NameMapping.CATTLE_NUMBER.getName(),
					(OperatorBase) NameMapping.CATTLE_NUMBER.getClazz().newInstance()); // 牛点数

			// 百家乐
			runner.addFunction(NameMapping.BC_PAIXU.getName(),
					(OperatorBase) NameMapping.BC_PAIXU.getClazz().newInstance()); // 百家乐牌型排序
			runner.addFunction(NameMapping.BC_SUM.getName(),
					(OperatorBase) NameMapping.BC_SUM.getClazz().newInstance()); // 百家乐求和

			// 庄家牛牛
			runner.addFunction(NameMapping.BANKER_BOMB_PAIXU.getName(),
					(OperatorBase) NameMapping.BANKER_BOMB_PAIXU.getClazz().newInstance());
			// 庄家炸弹牛
			runner.addFunction(NameMapping.BANKER_BOMB_CATTLE.getName(),
					(OperatorBase) NameMapping.BANKER_BOMB_CATTLE.getClazz().newInstance());
			// 庄家炸弹牛
			runner.addFunction(NameMapping.BANKER_CATTLE_NUMBER.getName(),
					(OperatorBase) NameMapping.BANKER_CATTLE_NUMBER.getClazz().newInstance());
			// 庄家牛点数
			runner.addFunction(NameMapping.BANKER_STREAKY_CATTLE.getName(),
					(OperatorBase) NameMapping.BANKER_STREAKY_CATTLE.getClazz().newInstance());
			// //庄家五花牛

			// qlExpress自带
			runner.addOperatorWithAlias("如果", "if", null);
			runner.addOperatorWithAlias("则", "then", null);
			runner.addOperatorWithAlias("否则", "else", null);

			runner.addOperatorWithAlias("属于", "in", "用户$1不在允许的范围");
			runner.addOperatorWithAlias("小于", "<", "$1 < $2 不符合");
			runner.addOperatorWithAlias("大于", ">", "$1 > $2 不符合");
			runner.addOperatorWithAlias("等于", "==", "$1 == $2 不符合");
			runner.addOperatorWithAlias("不等于", "!=", "$1 == $2 不符合");

			runner.addOperatorWithAlias("大于等于", ">=", "$1 == $2 不符合");
			runner.addOperatorWithAlias("并且", "and", "用户$1不在允许的范围");
			runner.addOperatorWithAlias("或者", "or", "用户$1不在允许的范围");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean execute(String express, DefaultContext<String, Object> context) {
		boolean result;
		try {
			result = (boolean) runner.execute(express, context, null, true, false);
			// Log.info("执行规则 -->"+express+" 结果 ： "+result);
		} catch (Exception e) {
			result = false;
			System.out.println("计算表达式错误！ 表达式-》" + express);
			e.getStackTrace();
		}
		return result;
	}

	public static void addOperator(String name, Operator op) {
		try {
			runner.addOperator(name, op);
		} catch (Exception e) {
			System.out.println("QLExpressUtil.addOperator 方法 出现异常！" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void addMacro(String macroName, String express) {
		try {
			runner.addMacro(macroName, express);
		} catch (Exception e) {
		}
	}

	public static void addFunction(String name, OperatorBase op) {
		try {
			runner.addFunction(name, op);
		} catch (Exception e) {
			System.out.println("QLExpressUtil.addFuncrion  方法出现异常！" + e.getMessage());
			e.printStackTrace();
		}
	}

}
