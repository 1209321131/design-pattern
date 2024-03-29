package com.kcaco.design.结构型.装饰器模式.费用计算.mockbean;

import cn.hutool.core.util.RandomUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public UserInfo getUserInfo(Long userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setPlusNo(RandomUtil.randomString(4));
        userInfo.setPlus(true);
        return userInfo;
    }

    public Integer hasEnjoyFreeTimes(Long userId) {
        return 1;
    }

    public Integer hasEnjoyFreeTime(Long userId) {
        return 1;
    }

    @Data
    public static class UserInfo {
        private String plusNo;
        private boolean isPlus;
        private Long userId;
    }
}
