package com.liu.yue.xin.chen.qlexpress.poker.function.sangong;

import java.util.List;

import com.liu.yue.xin.chen.qlexpress.poker.module.Poker;
import com.ql.util.express.Operator;

/**
 *  点数牌</br>
 *  三张牌点数相加个位数
 *  A 14 
 *  王 99
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public class DianShu  extends Operator{
	
	private static final long serialVersionUID = 1L;

	@Override
	public Object executeInner(Object[] list) throws Exception {
		List<Poker> pokers=	(List<Poker>) list[0];
		int num=0;
		for (Poker poker : pokers) {
			int id = poker.getNumber().getId();
			if( id == 14 ) {
				num+=1; 
			}else if( id == 99) {
				num+=10;
			}else if(id == 11 ||id == 12 || id == 13){
				num+=10;
			}else {
				num+=id;
			}
		}
		return num%10;
	}

}
