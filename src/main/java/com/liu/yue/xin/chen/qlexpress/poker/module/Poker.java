package com.liu.yue.xin.chen.qlexpress.poker.module;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * 共13*4=52张牌
 * BLOCK(1, "方块"),
 * CLUB(2, "梅花"),
 * HEART(3, "红心"),
 * SPADE(4, "黑桃"),
 * JOKER(9, "王");
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
public enum Poker {
    BLOCK_2(21, Type.BLOCK, PokerNumber.TWO),
    CLUB_2(22, Type.CLUB, PokerNumber.TWO),
    HEART_2(23, Type.HEART, PokerNumber.TWO),
    SPADE_2(24, Type.SPADE, PokerNumber.TWO),

    BLOCK_3(31, Type.BLOCK, PokerNumber.THREE),
    CLUB_3(32, Type.CLUB, PokerNumber.THREE),
    HEART_3(33, Type.HEART, PokerNumber.THREE),
    SPADE_3(34, Type.SPADE, PokerNumber.THREE),

    BLOCK_4(41, Type.BLOCK, PokerNumber.FOUR),
    CLUB_4(42, Type.CLUB, PokerNumber.FOUR),
    HEART_4(43, Type.HEART, PokerNumber.FOUR),
    SPADE_4(44, Type.SPADE, PokerNumber.FOUR),

    BLOCK_5(51, Type.BLOCK, PokerNumber.FIVE),
    CLUB_5(52, Type.CLUB, PokerNumber.FIVE),
    HEART_5(53, Type.HEART, PokerNumber.FIVE),
    SPADE_5(54, Type.SPADE, PokerNumber.FIVE),

    BLOCK_6(61, Type.BLOCK, PokerNumber.SIX),
    CLUB_6(62, Type.CLUB, PokerNumber.SIX),
    HEART_6(63, Type.HEART, PokerNumber.SIX),
    SPADE_6(64, Type.SPADE, PokerNumber.SIX),

    BLOCK_7(71, Type.BLOCK, PokerNumber.SEVEN),
    CLUB_7(72, Type.CLUB, PokerNumber.SEVEN),
    HEART_7(73, Type.HEART, PokerNumber.SEVEN),
    SPADE_7(74, Type.SPADE, PokerNumber.SEVEN),

    BLOCK_8(81, Type.BLOCK, PokerNumber.EIGHT),
    CLUB_8(82, Type.CLUB, PokerNumber.EIGHT),
    HEART_8(83, Type.HEART, PokerNumber.EIGHT),
    SPADE_8(84, Type.SPADE, PokerNumber.EIGHT),

    BLOCK_9(91, Type.BLOCK, PokerNumber.NINE),
    CLUB_9(92, Type.CLUB, PokerNumber.NINE),
    HEART_9(93, Type.HEART, PokerNumber.NINE),
    SPADE_9(94, Type.SPADE, PokerNumber.NINE),

    BLOCK_10(101, Type.BLOCK, PokerNumber.TEN),
    CLUB_10(102, Type.CLUB, PokerNumber.TEN),
    HEART_10(103, Type.HEART, PokerNumber.TEN),
    SPADE_10(104, Type.SPADE, PokerNumber.TEN),

    BLOCK_J(111, Type.BLOCK, PokerNumber.J),
    CLUB_J(112, Type.CLUB, PokerNumber.J),
    HEART_J(113, Type.HEART, PokerNumber.J),
    SPADE_J(114, Type.SPADE, PokerNumber.J),

    BLOCK_Q(121, Type.BLOCK, PokerNumber.Q),
    CLUB_Q(122, Type.CLUB, PokerNumber.Q),
    HEART_Q(123, Type.HEART, PokerNumber.Q),
    SPADE_Q(124, Type.SPADE, PokerNumber.Q),

    BLOCK_K(131, Type.BLOCK, PokerNumber.K),
    CLUB_K(132, Type.CLUB, PokerNumber.K),
    HEART_K(133, Type.HEART, PokerNumber.K),
    SPADE_K(134, Type.SPADE, PokerNumber.K),

    BLOCK_A(141, Type.BLOCK, PokerNumber.A),
    CLUB_A(142, Type.CLUB, PokerNumber.A),
    HEART_A(143, Type.HEART, PokerNumber.A),
    SPADE_A(144, Type.SPADE, PokerNumber.A),

    SMALL_JOKER(998, Type.JOKER, PokerNumber.JOKER),
    BIG_JOKER(999, Type.JOKER, PokerNumber.JOKER),
        ;

    private int id;

    private Type type;

    private PokerNumber number;

    Poker(int id, Type type, PokerNumber number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }
    
    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public PokerNumber getNumber() {
        return number;
    }
    public int getPokerNum() {
    	return getNumber().getNum();
    }
    public int getPoNum() {
    	return getNumber().getPotNum();
    }
    /**
     * 根据扑克id获取扑克枚举对象
     */
    public static Poker parseFromId(int pokerId) {
        Poker[] pokers = Poker.values();
        for (Poker poker : pokers) {
            if (poker.getId() == pokerId) {
                return poker;
            }
        }
        throw new IllegalArgumentException(String.format("找不到pokerId为%d的纸牌", pokerId));
    }

    /**
     * 根据扑克id列表获取扑克枚举对象列表
     */
    public static List<Poker> parseFromIds(List<Integer> ids) {
        List<Poker> pokers = new ArrayList<>(ids.size());
        ids.forEach(id -> pokers.add(parseFromId(id)));
        return pokers;
    }

    public static List<Integer> parseToIds(List<Poker> pokers) {
        return pokers.stream().map(p -> p.getId()).collect(Collectors.toList());
    }

    /**
     * 52只纸牌
     */
    private static List<Poker> allPokers = new CopyOnWriteArrayList<Poker>();
    /**
     * 54只纸牌 含大小王
     */
    private static List<Poker> laiziPokers = new CopyOnWriteArrayList<>();
    public   static void init() {
	  	allPokers.clear();
        for (Poker poker : Poker.values()) {
            if(poker.getType()==Type.JOKER)continue;
             allPokers.add(poker);
        }
        laiziPokers.clear();
        for (Poker poker : Poker.values()) {
            laiziPokers.add(poker);
         }
        System.out.println("初始化扑克牌完成！================================");
        System.out.println("52张扑克牌数量为： "+allPokers.size());
        System.out.println("52张扑克牌为： "+allPokers);
        System.out.println("初始化扑克牌完成！================================");
        System.out.println("54张扑克牌数量为： "+laiziPokers.size());
        System.out.println("54张扑克牌为： "+laiziPokers);
        System.out.println("初始化扑克牌完成！================================");
  }

    /**
     * 获取52张纸牌 不含大小王
     * @return
     */
    public static List<Poker> getAllPokers() {
        return new ArrayList<>(allPokers);
    }
    /**
     * 获取54张纸牌  含有大小王
     * @return
     */
    public static List<Poker> getLaiziPokers(){
    	return new ArrayList<>(laiziPokers);
    }
    
    /**
     * 根据pokerId转为NumberId
     *
     * @param pokerId
     * @return
     */
    public static Integer getPokerNumberById(Integer pokerId) {
        Integer count = 0;
        for (Poker poker : laiziPokers) {
            if (poker.getId() == pokerId)
                count = poker.getNumber().getId();
        }
        return count;
    }
    
    /**
     * 根据扑克的id 获取对应的扑克牌
     * @param pokerId 扑克牌的id
     * @return 扑克
     */
    public static Poker getPokerById(int pokerId) {
        for (Poker poker : laiziPokers) {
            if (poker.getId() == pokerId)return poker;
        }
        return null;
    }
    
    /**
     * 转化为Number
     *
     * @param pokers
     * @return
     */
    public static List<Integer> parseToNumbers(List<Poker> pokers) {
        return pokers.stream().map(p -> p.getNumber().getId()).collect(Collectors.toList());
    }


    public enum Type {
        BLOCK(1, "方块"),
        CLUB(2, "梅花"),
        HEART(3, "红心"),
        SPADE(4, "黑桃"),
        JOKER(9, "王");

        private int id;

        private String name;

        Type(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public enum PokerNumber {
        TWO(2, "2", 2d,2,2,2,false),
        THREE(3, "3", 3d,3,3,3,true),
        FOUR(4, "4", 4d,4,4,4,false),
        FIVE(5, "5", 5d,5,5,5,true),
        SIX(6, "6", 6d,6,6,6,false),
        SEVEN(7, "7", 7d,7,7,7,true),
        EIGHT(8, "8", 8d,8,8,8,false),
        NINE(9, "9", 9d,9,9,9,true),
        TEN(10, "10", 10d,10,0,10,false),
        J(11, "J", 11d,11,0,10,true),
        Q(12, "Q", 12d,12,0,10,false),
        K(13, "K", 13d,13,0,10,true),
        A(14, "A", 14D,1,1,1,true),
        JOKER(99, "JOKER", 99d,99,99,99,false);
        private int id;

        private String name;

        // 面值，用于牌面比较大小。可以在启动系统时，重新设置面值
        private double faceValue;
        
        private int num;
        
        // 该值用来计算点数
        private int potNum;
        
        // 该值用来计算切面值
        private int cutNum;

        /** 是否属于单牌 */
        private boolean odd;

        PokerNumber(int id, String name, double faceValue,int num,int pot,int cut,boolean odd) {
            this.id = id;
            this.name = name;
            this.faceValue = faceValue;
            this.num=num;
            this.potNum=pot;
            this.cutNum=cut;
            this.odd=odd;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getFaceValue() {
            return faceValue;
        }

        public void setFaceValue(double faceValue) {
            this.faceValue = faceValue;
        }

		public int getNum() {
			return num;
		}
		
		public int getPotNum() {
			return potNum;
		}

		public int getCutNum() {
			return cutNum;
		}

        public boolean isOdd() {
            return odd;
        }

        /**
		 * 获取牌值 如果牌值大于10 则返回 10 
		 */
		public int getNiuNum() {
			if(num >10)return 10;
			return num;
		}

        
    }
    
	/**
	 * 检查是否是顺子 (三张牌)
	 * @param pokers
	 * @return
	 */
	public static  boolean checkShunZi(List<Poker> pokers) {
		Poker poker = pokers.get(0);
		Poker poker1 = pokers.get(1);
		Poker poker2 = pokers.get(2);
		//对特殊的牌型过滤   列如 A23   
		if(poker2.getNumber().getId()==14 && poker.getNumber().getId()==2 && poker1.getNumber().getId()==3)return true;
		if(((poker1.getNumber().getId()-1)==(poker.getNumber().getId())) &&((poker1.getNumber().getId()+1)==(poker2.getNumber().getId()))) {
			return true;
		}
		 return false;
	}
    
	/**
	 * 检查是否是顺子 (两张牌)
	 * @param pokers
	 * @return
	 */
	public static  boolean checkShunZi2(List<Poker> pokers) {
		Poker poker = pokers.get(0);
		Poker poker1 = pokers.get(1);
		//对特殊的牌型过滤   列如 A23   
		if(poker1.getNumber().getId()==14 && poker.getNumber().getId()==2)return true;
		if(((poker1.getNumber().getId()-1)==(poker.getNumber().getId()))) {
			return true;
		}
		return false;
	}
	
    
    
}
