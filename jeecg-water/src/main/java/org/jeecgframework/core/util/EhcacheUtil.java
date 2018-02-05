package org.jeecgframework.core.util;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehcache 缓存工具类
 * 
 * cacheName在ehcache.xml中配置
 */
public class EhcacheUtil {

	public static CacheManager manager = CacheManager.create();
	
    @Autowired
    private Cache ehcache;

	public static Object get(String cacheName, Object key) {
		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			Element element = cache.get(key);
			if (element != null) {
				return element.getObjectValue();
			}
		}
		return null;
	}

	public static void put(String cacheName, Object key, Object value) {
		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			cache.put(new Element(key, value));
		}
	}

	public static boolean remove(String cacheName, Object key) {
		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			return cache.remove(key);
		}
		return false;
	}
	
//    public void setValue(String key, String value) {
//        ehcache.put(new Element(key, value));
//    }
//
//    public Object getValue(String key) {
//        Element element = ehcache.get(key);
//        return element != null ? element.getValue() : null;
//    }

	public static void main(String[] args) {
//		String key = "key";
//		String value = "hello";
//		EhcacheUtil.put("mytest", key, value);
//		System.out.println(EhcacheUtil.get("mytest", key));
		
		Cache cache = manager.getCache("myCache");
		cache.put(new Element("wangxufu", "haha"));
		Element element = cache.get("wangxufu");
		System.out.println(element);
	}

}