package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.constants.SysConstants;
import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.service.SysUserService;
import cloud.xiguapi.lemon.common.tool.FileUtils;
import cloud.xiguapi.lemon.common.tool.PasswordUtils;
import cloud.xiguapi.lemon.core.http.HttpResult;
import cloud.xiguapi.lemon.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
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

	@PostMapping("/save")
	public HttpResult save(@RequestBody SysUser record) {
		SysUser user = service.findById(record.getId());

		if (user != null) {
			if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
				return HttpResult.error("超级管理员不允许修改");
			}
		}

		if (record.getPassword() != null) {
			String salt = PasswordUtils.getSalt();

			if (user == null) {
				// 新增用户
				if (service.findByName(record.getName()) != null) {
					return HttpResult.error("用户名已存在");
				}

				String password = PasswordUtils.encode(record.getPassword(), salt);
				record.setSalt(salt);
				record.setPassword(password);
			} else {
				// 修改用户
				if (!record.getPassword().equals(user.getPassword())) {
					String password = PasswordUtils.encode(record.getPassword(), salt);
					record.setSalt(salt);
					record.setPassword(password);
				}
			}
		}
		return HttpResult.ok(service.save(record));
	}

	@PostMapping(value = "/delete")
	public HttpResult delete(@RequestBody List<SysUser> records) {
		for (SysUser record : records) {
			SysUser sysUser = service.findById(record.getId());
			if (sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
				return HttpResult.error("超级管理员不允许删除!");
			}
		}
		return HttpResult.ok(service.delete(records));
	}

	@GetMapping("/findAll")
	public List<SysUser> findAll() {
		return service.findAll();
	}

	@PostMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(service.findPage(pageRequest));
	}

	@GetMapping(value = "/findByName")
	public HttpResult findByName(@RequestParam String name) {
		return HttpResult.ok(service.findByName(name));
	}

	@GetMapping(value = "/findPermissions")
	public HttpResult findPermissions(@RequestParam String name) {
		return HttpResult.ok(service.findPermissions(name));
	}

	@GetMapping(value = "/findUserRoles")
	public HttpResult findUserRoles(@RequestParam Long userId) {
		return HttpResult.ok(service.findUserRoles(userId));
	}


	@PostMapping("/exportExcelUser")
	public void exportExportExcelUser(@RequestBody PageRequest request, HttpServletResponse resp) {
		File file = service.createUserExcelFile(request);
		FileUtils.downloadFile(resp, file, file.getName());
	}
}
