package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.mapper.SysUserMapper;
import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Autowired
	public SysUserServiceImpl(SysUserMapper mapper) {
		this.mapper = mapper;
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
}
