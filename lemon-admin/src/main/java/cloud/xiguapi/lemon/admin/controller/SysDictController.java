package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysDict;
import cloud.xiguapi.lemon.admin.service.SysDictService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import cloud.xiguapi.lemon.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典服务控制器
 *
 * @author 大大大西西瓜皮🍉
 * @date 19:05 2020-07-26
 * description:
 */
@RestController
@RequestMapping("dict")
public class SysDictController {

	private final SysDictService service;

	@Autowired
	public SysDictController(SysDictService service) {
		this.service = service;
	}

	@PostMapping("/save")
	public HttpResult save(@RequestBody SysDict record) {
		return HttpResult.ok(service.save(record));
	}

	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<SysDict> records) {
		return HttpResult.ok(service.delete(records));
	}

	@PostMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest request) {
		return HttpResult.ok(service.findPage(request));
	}

	@GetMapping("/findByLabel")
	public HttpResult findByLabel(@RequestParam String label) {
		return HttpResult.ok(service.findByLabel(label));
	}
}
