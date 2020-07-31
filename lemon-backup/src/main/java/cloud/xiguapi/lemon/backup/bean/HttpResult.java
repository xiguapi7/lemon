package cloud.xiguapi.lemon.backup.bean;

/**
 * HTTP结果封装
 *
 * @author 大大大西西瓜皮🍉
 * @date 15:20 2020-07-31
 * description:
 */
public class HttpResult {

	private int code = 200;
	private String msg;
	private Object data;

	public static HttpResult error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static HttpResult error(String msg) {
		return error(500, msg);
	}

	public static HttpResult error(int code, String msg) {
		HttpResult r = new HttpResult();
		r.setCode(code);
		r.setMsg(msg);
		return r;
	}

	public static HttpResult ok(String msg) {
		HttpResult r = new HttpResult();
		r.setMsg(msg);
		return r;
	}

	public static HttpResult ok(Object data) {
		HttpResult r = new HttpResult();
		r.setData(data);
		return r;
	}

	public static HttpResult ok() {
		return new HttpResult();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
