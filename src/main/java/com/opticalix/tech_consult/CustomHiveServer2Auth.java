package com.opticalix.tech_consult;

import com.opticalix.utils.MD5Utils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hive.service.auth.PasswdAuthenticationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.sasl.AuthenticationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 根据用户名密码文件，遍历看是否能匹配上一个用户。如果不能则抛出异常
 * TODO 项目要怎么建，这个auth可能要单打一个jar包
 * <p>
 * ref:
 * https://www.cnblogs.com/1130136248wlxk/articles/5519285.html
 * https://blog.csdn.net/lr131425/article/details/72460489
 * https://www.cnblogs.com/zlslch/p/6024551.html
 */
public class CustomHiveServer2Auth implements PasswdAuthenticationProvider {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomHiveServer2Auth.class);

    @Override
    public void Authenticate(String username, String password) throws AuthenticationException {
        boolean ok = false;
        String passMd5 = new MD5Utils().md5(password);
        HiveConf hiveConf = new HiveConf();
        Configuration conf = new Configuration(hiveConf);
        String filePath = conf.get("hive.server2.custom.authentication.file");
        System.out.println("hive.server2.custom.authentication.file [" + filePath + "] ..");
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String[] datas = tempString.split(",", -1);
                if (datas.length != 2) continue;
                //ok
                if (datas[0].equals(username) && datas[1].equals(passMd5)) {
                    ok = true;
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("read auth config file error, [" + filePath + "] ..", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        if (ok) {
            System.out.println("user [" + username + "] auth check ok .. ");
        } else {
            System.out.println("user [" + username + "] auth check fail .. ");
            throw new AuthenticationException("user [" + username + "] auth check fail .. ");
        }
    }
}
