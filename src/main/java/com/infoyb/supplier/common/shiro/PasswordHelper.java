package com.infoyb.supplier.common.shiro;

import com.infoyb.supplier.system.model.ByUsers;
import com.infoyb.supplier.system.model.UserSupplier;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * <dl>
 * <dt>ProjectName : infoyb-data-platform </dt>
 * <dt>PakageName : com.infoyb.shiro </dt>
 * <dt>ClassName: CustomizedSessionManager </dt>
 * <dd>CreateDate: 2017-08-11 16:38 </dd>
 * <dd>Copyright: Copyright (C) 2015 </dd>
 * <dd>Company: 陕西优百信息技术有限公司 </dd>
 * <dd>Description: shiro密码生成类</dd>
 * </dl>
 *
 * @author wangjun
 */
@Service
public class PasswordHelper {

    /**
     * Shiro 提供了PasswordService及CredentialsMatcher用于提供加密密码及验证密码服务
     **/
    //用于生成公盐
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";//加密方式
    private int hashIterations = 2;//生成Hash值的迭代次数

    //输入明文密码得到密文密码
    public void encryptPassword(ByUsers user) {
        //生成随机数
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        //加密后的密码文本
        String newPassword = new SimpleHash(
                algorithmName,
                user.getUserPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
        user.setUserPassword(newPassword);
    }
    //根据salt获取加密文本
    public String createPwdEncrypt(String psw,String salt){
        //加密后的密码文本
        String newPassword = new SimpleHash(
                algorithmName,
                psw,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
        return newPassword;
    }
}
