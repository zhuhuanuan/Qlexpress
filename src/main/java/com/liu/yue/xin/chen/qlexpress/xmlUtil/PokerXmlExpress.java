package com.liu.yue.xin.chen.qlexpress.xmlUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import com.liu.yue.xin.chen.qlexpress.poker.operator.PokerRule;

import lombok.extern.slf4j.Slf4j;

/**
 * 规则配置加载
 * 
 * @bk https://home.cnblogs.com/u/huanuan/
 * @简书 https://www.jianshu.com/u/d29cc7d7ca49
 * @Author 六月星辰 2020年4月22日
 */
@Slf4j
public class PokerXmlExpress {
	private static final String EXPRESS_FILE_PATH = "pokerExpress.xml";

	private static Map<String, List<PokerRule>> rulesByType = new ConcurrentHashMap<>();

	private static Map<String, List<PokerRule>> rulesByName = new ConcurrentHashMap<>();

	/**
	 * 初始化 加载规则配置
	 */
	public static void init() {
		try {
			String path2 = ClassLoader.getSystemResource(EXPRESS_FILE_PATH).getPath();
			XMLConfiguration config = new Configurations().xml(path2);
			PokerRule.ALWAYS_SCAN_HU = config.getBoolean("properties[@alwaysScanHu]", false);
			int ruleCount = config.getList("rule").size();
			List<PokerRule> list = new ArrayList<>(ruleCount);
			for (int i = 0; i < ruleCount; i++) {
				PokerRule rule = new PokerRule();
				rule.setName(config.getString("rule(" + i + ")" + "[@name]"));
				rule.setType(config.getString("rule(" + i + ")" + "[@type]"));
				rule.setId(config.getInt("rule(" + i + ")" + "[@id]"));
				rule.setRate(config.getInt("rule(" + i + ")" + "[@rate]"));
				rule.setExpress(config.getString("rule(" + i + ")"));
				log.info("加载规则：" + rule.getExpress());
				list.add(rule);
			}
			log.info("加载到 " + list.size() + " 条表达式！");
			Map<String, List<PokerRule>> rules = list.stream()
					.collect(Collectors.groupingBy(PokerRule::getType, Collectors.toList()));
			rulesByType.clear();
			rulesByType.putAll(rules);
			Map<String, List<PokerRule>> rulesName = list.stream()
					.collect(Collectors.groupingBy(PokerRule::getName, Collectors.toList()));
			rulesByName.clear();
			rulesByName.putAll(rulesName);
		} catch (ConfigurationException e) {
			log.info("加载规则配置失败！" + e.getMessage());
			e.getStackTrace();
		}
	}

	/**
	 * 获取指定类型的规则表达
	 * 
	 * @param ruleType
	 *            规则的表达类型
	 * @return
	 */
	public static List<PokerRule> getRulesByType(String ruleType) {
		return rulesByType.getOrDefault(ruleType, Collections.emptyList());
	}

	public static List<PokerRule> getRulesByName(String ruleName) {
		return rulesByName.getOrDefault(ruleName, Collections.emptyList());
	}

	/**
	 * 获取对应id的牌型倍数
	 * 
	 * @param ruleType
	 *            类型规则
	 * @param id
	 *            规则id
	 * @return 规则配置倍数
	 */
	public static int getRuleRate(String ruleType, int id) {
		return rulesByType.getOrDefault(ruleType, Collections.emptyList()).stream().filter(e -> e.getId() == id)
				.findFirst().get().getRate();
	}
}
