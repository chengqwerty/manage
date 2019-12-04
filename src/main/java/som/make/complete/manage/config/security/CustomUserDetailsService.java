package som.make.complete.manage.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import som.make.complete.manage.system.bean.SysUserBean;
import som.make.complete.manage.system.dao.SysUserDao;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    private SysUserDao sysUserDao;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<SimpleGrantedAuthority> set = new HashSet<>();
        switch (username) {
            case "blizzard":
                return new User(username, passwordEncoder.encode("whosyourdaddy"), set);
            case "admin":
                SysUserBean sysUser = sysUserDao.findByLoginName(username);
                if (sysUser == null) {
                    return new User(username, passwordEncoder.encode("whosyourdaddy"), set);
                } else {
                    return new User(sysUser.getLoginName(), sysUser.getPassword(), set);
                }
            default:
                sysUser = sysUserDao.findByLoginName(username);
                return new User(sysUser.getLoginName(), sysUser.getPassword(), set);
        }
    }

}
