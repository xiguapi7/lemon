package cloud.xiguapi.lemon.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 *
 * @author 大大大西西瓜皮🍉
 * @date 11:31 2020-07-31
 * description:
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String authority;

	public GrantedAuthorityImpl(String authority) {
		this.authority = authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
}
