package som.make.complete.manage.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import som.make.complete.manage.system.bean.SysUserBean;

public interface SysUserDao extends JpaRepository<SysUserBean, String> {

    SysUserBean findByLoginName(String loginName);

}
