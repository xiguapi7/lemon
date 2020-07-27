package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysConfig;
import cloud.xiguapi.lemon.admin.service.SysConfigService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import cloud.xiguapi.lemon.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 配置服务控制器
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:59 2020-07-27
 * description:
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

	private final SysConfigService service;

	@Autowired
	public SysConfigController(SysConfigService service) {
		this.service = service;
	}

	@PostMapping(value = "/save")
	public HttpResult save(@RequestBody SysConfig record) {
		return HttpResult.ok(service.save(record));
	}

	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<SysConfig> records) {
		return HttpResult.ok(service.delete(records));
	}

	@PostMapping(value = "/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(service.findPage(pageRequest));
	}

	@GetMapping(value = "/findByLabel")
	public HttpResult findByLabel(@RequestParam String lable) {
		return HttpResult.ok(service.findByLable(lable));
	}
}
