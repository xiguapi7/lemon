package cloud.xiguapi.lemon.admin.service.impl;

import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.security.GrantedAuthorityImpl;
import cloud.xiguapi.lemon.admin.security.JwtUserDetails;
import cloud.xiguapi.lemon.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 大大大西西瓜皮🍉
 * @date 11:40 2020-07-31
 * description:
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final SysUserService sysUserService;

	@Autowired
	public UserDetailsServiceImpl(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserService.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("该用户不存在");
		}
		// 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
		Set<String> permissions = sysUserService.findPermissions(user.getName());
		List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
		return new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), grantedAuthorities);
	}
}
