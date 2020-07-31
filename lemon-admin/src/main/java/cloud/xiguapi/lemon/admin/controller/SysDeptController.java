package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysDept;
import cloud.xiguapi.lemon.admin.service.SysDeptService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 机构服务控制器
 *
 * @author 大大大西西瓜皮🍉
 * @date 18:01 2020-07-27
 * description:
 */
@RestController
@RequestMapping("dept")
public class SysDeptController {

	private final SysDeptService service;

	@Autowired
	public SysDeptController(SysDeptService service) {
		this.service = service;
	}

	@PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
	@PostMapping(value = "/save")
	public HttpResult save(@RequestBody SysDept record) {
		return HttpResult.ok(service.save(record));
	}

	@PreAuthorize("hasAuthority('sys:dept:delete')")
	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<SysDept> records) {
		return HttpResult.ok(service.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:dept:view')")
	@GetMapping(value = "/findTree")
	public HttpResult findTree() {
		return HttpResult.ok(service.findTree());
	}
}
