package io.github.xfdzcoder.noj.cloud.manage.user;

import cn.hutool.crypto.digest.BCrypt;
import org.junit.jupiter.api.Test;

/**
 * @author xfdzcoder
 */
public class PasswordTest {

    @Test
    public void test() {
        System.out.println(BCrypt.hashpw("123456"));
    }

}
