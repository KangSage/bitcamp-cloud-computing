package bitcamp.pms.test;

import bitcamp.pms.dao.MemberDao;
import org.springframework.context.annotation.Bean;

public class MySpringConfig {
    @Bean()
    public MemberDao getMemberDao() {
        return new MemberDao();
    }
 }
