package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.service.SysUserService;
import cloud.xiguapi.lemon.core.http.HttpResult;
import cloud.xiguapi.lemon.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author 大大大西西瓜皮🍉
 * @date 01:01 2020-07-26
 * description:
 */
@RestController
@RequestMapping("user")
public class SysUserController {

	private final SysUserService service;

	@Autowired
	public SysUserController(SysUserService service) {
		this.service = service;
	}

	@GetMapping("/findAll")
	public List<SysUser> findAll() {
		return service.findAll();
	}

	@PostMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(service.findPage(pageRequest));
	}
}
