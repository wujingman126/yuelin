package co.yixiang.utils;

import org.springframework.beans.BeanUtils;

/**
 * Bean copy
 * 
 * @author wuyun
 */
public final class BeanUtil {

	private BeanUtil() {

	}

	/**
	 * 
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T copyProperties(Object source, Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (source == null) {
			return null;
		}
		BeanUtils.copyProperties(source, t);
		return t;
	}

}
