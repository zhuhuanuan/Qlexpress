package com.liu.yue.xin.chen.qlexpress.poker.function.firedFlower;

import com.liu.yue.xin.chen.qlexpress.poker.ProkerCombo;
import com.ql.util.express.Operator;

public class FiredFlowerType extends Operator{
	
	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		ProkerCombo combo = (ProkerCombo) list[0];
		if(combo==null)return -1;
		return combo;
	}

}
