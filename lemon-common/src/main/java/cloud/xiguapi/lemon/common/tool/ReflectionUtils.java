package cloud.xiguapi.lemon.common.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 封装反射工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 16:49 2020-07-26
 * description:
 */
public class ReflectionUtils {


	/**
	 * 反射调用方法
	 *
	 * @param object     目标对象
	 * @param methodName 方法名
	 * @param args       参数
	 * @return 调用后返回的结果对象
	 */
	public static Object invoke(Object object, String methodName, Object[] args) {

		Object result = null;
		Class<?> clazz = object.getClass();
		Method method = getMethod(clazz, methodName, args);

		if (method != null) {
			try {
				result = method.invoke(object, args);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new NoSuchMethodException(clazz.getName() + " 类中没有找到 " + method + " 方法。");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 根据方法名和参数查找Method对象
	 *
	 * @param clazz      Class对象
	 * @param methodName 方法名
	 * @param args       参数
	 * @return Method对象
	 */
	private static Method getMethod(Class<?> clazz, String methodName, Object[] args) {

		Method method = null;

		Method[] methods = clazz.getMethods();

		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				Class<?>[] parameterTypes = m.getParameterTypes();

				if (parameterTypes.length == args.length) {
					boolean isSameMethod = true;
					for (int i = 0; i < parameterTypes.length; i++) {
						Object arg = args[i];
						if (arg == null) {
							arg = "";
						}
						if (!parameterTypes[i].equals(args[i].getClass())) {
							isSameMethod = false;
						}
					}
					if (isSameMethod) {
						method = m;
						break;
					}
				}
			}
		}
		return method;
	}
}
