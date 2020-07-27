package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysLoginLog;
import cloud.xiguapi.lemon.admin.service.SysLoginLogService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import cloud.xiguapi.lemon.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录操作日志服务控制器
 *
 * @author 大大大西西瓜皮🍉
 * @date 18:04 2020-07-27
 * description:
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

	private final SysLoginLogService service;

	@Autowired
	public SysLoginLogController(SysLoginLogService service) {
		this.service = service;
	}

	@PostMapping(value = "/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(service.findPage(pageRequest));
	}

	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<SysLoginLog> records) {
		return HttpResult.ok(service.delete(records));
	}
}
