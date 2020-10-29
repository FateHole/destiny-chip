package com.fatehole.destinychip.mvc.config;

import com.fatehole.destinychip.entity.Admin;
import com.fatehole.destinychip.entity.Role;
import com.fatehole.destinychip.service.api.AdminService;
import com.fatehole.destinychip.service.api.AuthService;
import com.fatehole.destinychip.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FateCat
 * @version 1.0.0
 * @date Create in 2020/10/29/10:12
 */
@Component
public class DestinyChipUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根据账号名查询Admin对象
        Admin admin = adminService.getAdminByLoginAccount(username);

        // 获取用户的id
        Integer adminId = admin.getId();

        // 根据管理员id查询角色信息
        List<Role> assignedRoleList = roleService.getAssignedRole(adminId);

        // 再根据管理员id查询权限信息
        List<String> authNameList = authService.getAssignedAuthNameByAdminId(adminId);

        // 创建集合的对象来储存GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();

        // 遍历assignedRoleList存入角色信息
        for (Role role : assignedRoleList) {
            // 加上前缀
            String roleName = "ROLE_" + role.getName();

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);

            authorities.add(simpleGrantedAuthority);
        }

        // 遍历权限的信息
        for (String authName : authNameList) {

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);

            authorities.add(simpleGrantedAuthority);
        }

        // 封装为SecurityAdmin对象并返回
        return new SecurityAdmin(admin, authorities);
    }
}
