package cloud.xiguapi.lemon.controller;

import cloud.xiguapi.lemon.model.SysUser;
import cloud.xiguapi.lemon.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
