package com.fatehole.destinychip.mvc.config;

import com.fatehole.destinychip.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * 考虑到User对象中只能保存用户名和密码，为了获得原始的Admin对象，对User对象进行扩展
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/10/29/10:01
 */
public class SecurityAdmin extends User {

    private static final long serialVersionUID = 8329428346629384L;

    private final Admin originalAdmin;

    /**
     * @param originalAdmin 原始的Admin对象
     * @param authorities 包含角色、权限信息的集合
     */
    public SecurityAdmin(Admin originalAdmin, List<GrantedAuthority> authorities) {
        // 不知是否应该再此加密？？？？？？？(柑橘非常「amazing」)
        super(originalAdmin.getUsername(), originalAdmin.getPassword(), authorities);

        this.originalAdmin = originalAdmin;
    }

    public Admin getOriginalAdmin() {
        return originalAdmin;
    }
}
