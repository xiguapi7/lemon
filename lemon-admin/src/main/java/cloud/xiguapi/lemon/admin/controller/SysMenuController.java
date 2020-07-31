package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.service.SysMenuService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单服务控制器
 *
 * @author 大大大西西瓜皮🍉
 * @date 15:35 2020-07-27
 * description:
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

	private final SysMenuService service;

	@Autowired
	public SysMenuController(SysMenuService service) {
		this.service = service;
	}

	@PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
	@PostMapping(value = "/save")
	public HttpResult save(@RequestBody SysMenu record) {
		return HttpResult.ok(service.save(record));
	}

	@PreAuthorize("hasAuthority('sys:menu:delete')")
	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<SysMenu> records) {
		return HttpResult.ok(service.delete(records));
	}

	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value = "/findNavTree")
	public HttpResult findNavTree(@RequestParam String userName) {
		return HttpResult.ok(service.findTree(userName, 1));
	}

	@PreAuthorize("hasAuthority('sys:menu:view')")
	@GetMapping(value = "/findMenuTree")
	public HttpResult findMenuTree() {
		return HttpResult.ok(service.findTree(null, 0));
	}
}
