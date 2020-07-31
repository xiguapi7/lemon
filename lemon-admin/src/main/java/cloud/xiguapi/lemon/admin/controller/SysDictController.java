package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysDict;
import cloud.xiguapi.lemon.admin.service.SysDictService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import cloud.xiguapi.lemon.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:edit')")
	@PostMapping("/save")
	public HttpResult save(@RequestBody SysDict record) {
		return HttpResult.ok(service.save(record));
	}

	@PreAuthorize("hasAuthority('sys:dict:delete')")
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<SysDict> records) {
		return HttpResult.ok(service.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:dict:view')")
	@PostMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest request) {
		return HttpResult.ok(service.findPage(request));
	}

	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping("/findByLabel")
	public HttpResult findByLabel(@RequestParam String label) {
		return HttpResult.ok(service.findByLabel(label));
	}
}
