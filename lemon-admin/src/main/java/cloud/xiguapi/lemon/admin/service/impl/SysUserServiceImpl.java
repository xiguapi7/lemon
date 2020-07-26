package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysRoleMapper;
import cloud.xiguapi.lemon.admin.mapper.SysUserMapper;
import cloud.xiguapi.lemon.admin.mapper.SysUserRoleMapper;
import cloud.xiguapi.lemon.admin.model.SysMenu;
import cloud.xiguapi.lemon.admin.model.SysRole;
import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.model.SysUserRole;
import cloud.xiguapi.lemon.admin.service.SysMenuService;
import cloud.xiguapi.lemon.admin.service.SysUserService;
import cloud.xiguapi.lemon.common.tool.PoiUtils;
import cloud.xiguapi.lemon.core.page.MyBatisPageHelper;
import cloud.xiguapi.lemon.core.page.PageRequest;
import cloud.xiguapi.lemon.core.page.PageResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户接口实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 00:59 2020-07-26
 * description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	private final SysUserMapper mapper;

	private final SysMenuService menuService;

	private final SysUserRoleMapper userRoleMapper;

	private final SysRoleMapper roleMapper;

	@Autowired
	public SysUserServiceImpl(SysUserMapper mapper, SysMenuService menuService, SysUserRoleMapper userRoleMapper, SysRoleMapper roleMapper) {
		this.mapper = mapper;
		this.menuService = menuService;
		this.userRoleMapper = userRoleMapper;
		this.roleMapper = roleMapper;
	}


	/**
	 * 无条件查询所有用户
	 * 仅用作测试
	 *
	 * @return 查询结果
	 */
	@Override
	public List<SysUser> findAll() {
		return mapper.findAll();
	}

	@Transactional
	@Override
	public int save(SysUser record) {

		Long id = null;
		if (record.getId() == null || record.getId() == 0) {
			// 新增用户
			mapper.insertSelective(record);
			id = record.getId();
		} else {
			// 更新用户信息
			mapper.updateByPrimaryKeySelective(record);
		}
		// 更新用户角色
		if (id != null && id == 0) {
			return 1;
		}
		if (id != null) {
			for (SysUserRole sysUserRole : record.getUserRoles()) {
				sysUserRole.setUserId(id);
			}
		} else {
			mapper.deleteByUserId(record.getId());
		}
		for (SysUserRole sysUserRole : record.getUserRoles()) {
			userRoleMapper.insertSelective(sysUserRole);
		}
		return 1;
	}

	@Override
	public int delete(SysUser record) {
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysUser> list) {
		list.forEach(this::delete);
		return 1;
	}

	@Override
	public SysUser findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {

		PageResult result;

		Object name = pageRequest.getParam("name");
		Object email = pageRequest.getParam("email");

		if (name != null) {
			if (email != null) {
				result = MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByNameAndEmail", name, email);
			} else {
				result = MyBatisPageHelper.findPage(pageRequest, mapper, "findPageByName", name);
			}
		} else {
			result = MyBatisPageHelper.findPage(pageRequest, mapper);
		}

		findUserRoles(result);

		return result;
	}

	private void findUserRoles(PageResult result) {
		List<?> content = result.getContent();
		content.forEach(c -> {
			SysUser user = (SysUser) c;
			List<SysUserRole> userRoles = findUserRoles(user.getId());
			user.setUserRoles(userRoles);
			user.setRoleNames(getRoleNames(userRoles));
		});
	}

	private String getRoleNames(List<SysUserRole> userRoles) {
		StringBuilder sb = new StringBuilder();

		userRoles.forEach(userRole -> {
			SysRole ur = roleMapper.selectByPrimaryKey(userRole.getRoleId());
			if (ur != null) {
				sb.append(ur.getRemark()).append(", ");
			}
		});

		return sb.toString();
	}

	@Override
	public SysUser findByName(String name) {
		return mapper.findByName(name);
	}

	@Override
	public Set<String> findPermissions(String name) {

		Set<String> result = new HashSet<>();
		List<SysMenu> menuList = menuService.findByUser(name);
		menuList.forEach(menu -> {
			if (!StringUtils.isEmpty(menu.getPerms())) {
				result.add(menu.getPerms());
			}
		});
		return result;
	}

	@Override
	public List<SysUserRole> findUserRoles(Long userId) {

		return userRoleMapper.findUserRoles(userId);
	}


	@Override
	public File createUserExcelFile(PageRequest request) {
		PageResult result = findPage(request);
		return createUserExcelFile(result.getContent());
	}

	public static File createUserExcelFile(List<?> records) {
		if (records == null) {
			records = new ArrayList<>();
		}

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row0 = sheet.createRow(0);

		int columnIndex = 0;

		row0.createCell(columnIndex).setCellValue("No");
		row0.createCell(++columnIndex).setCellValue("ID");
		row0.createCell(++columnIndex).setCellValue("用户名");
		row0.createCell(++columnIndex).setCellValue("昵称");
		row0.createCell(++columnIndex).setCellValue("机构");
		row0.createCell(++columnIndex).setCellValue("角色");
		row0.createCell(++columnIndex).setCellValue("邮箱");
		row0.createCell(++columnIndex).setCellValue("手机号");
		row0.createCell(++columnIndex).setCellValue("状态");
		row0.createCell(++columnIndex).setCellValue("头像");
		row0.createCell(++columnIndex).setCellValue("创建人");
		row0.createCell(++columnIndex).setCellValue("创建时间");
		row0.createCell(++columnIndex).setCellValue("最后更新人");
		row0.createCell(++columnIndex).setCellValue("最后更新时间");

		for (int i = 0; i < records.size(); i++) {
			SysUser user = (SysUser) records.get(i);
			Row row = sheet.createRow(i + 1);

			for (int j = 0; j < columnIndex + 1; j++) {
				row.createCell(j);
			}

			columnIndex = 0;

			row.createCell(columnIndex).setCellValue(i + 1);
			row.createCell(++columnIndex).setCellValue(user.getId());
			row.createCell(++columnIndex).setCellValue(user.getName());
			row.createCell(++columnIndex).setCellValue(user.getNickName());
			row.createCell(++columnIndex).setCellValue(user.getDeptName());
			row.createCell(++columnIndex).setCellValue(user.getRoleNames());
			row.createCell(++columnIndex).setCellValue(user.getEmail());
			row.createCell(++columnIndex).setCellValue(user.getMobile());
			row.createCell(++columnIndex).setCellValue(user.getStatus());
			row.createCell(++columnIndex).setCellValue(user.getAvatar());
			row.createCell(++columnIndex).setCellValue(user.getCreateBy());
			row.createCell(++columnIndex).setCellValue(user.getCreateTime());
			row.createCell(++columnIndex).setCellValue(user.getLastUpdateBy());
			row.createCell(++columnIndex).setCellValue(user.getLastUpdateTime());
		}

		return PoiUtils.createExcelFile(workbook, "download_user");
	}
}
