package com.kiwiboot.kiwisso.utils;

import com.kiwiboot.kiwisso.model.User;
import com.kiwiframework.core.enums.ResultCode;
import com.kiwiframework.core.exception.AppException;
import com.kiwiframework.core.utils.CodeGenerateor;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt 无状态校验utils
 * @author xiongzhao by 2018-11-04
 */
public class JwtUtils {

    /**
     * 加密key
     */
    private static String SECRET_KEY = "F435TREFASDW45fdfg4refs";

    /**
     * 生成jwt token
     * @param user
     * @return
     * @throws Exception
     */
    public static String createJWT(User user){
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        Date now = new Date();
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String,Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("telephone", user.getTelephone());
        claims.put("email", user.getEmail());
        claims.put("nickName", user.getNickName());
        claims.put("sex", user.getSex());
        claims.put("avatarUrl", user.getAvatarUrl());
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重复攻击。
                .setId(CodeGenerateor.uuid())
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为用户的唯一标志。
                .setSubject("{'fsd': '234'}")
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, SECRET_KEY)
                // 设置过期时间
                .setExpiration(new Date(now.getTime() + 24 * 3600 * 1000));
        return builder.compact();
    }

    /**
     * 解密jwt
     * @param token
     * @return
     * @throws Exception
     */
    public static User parseJWT(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token).getBody();
            return User.builder()
                    .id(Long.valueOf(claims.get("id").toString()))
                    .telephone(claims.get("telephone") + "")
                    .email(claims.get("email") + "")
                    .nickName(claims.get("nickName") + "")
                    .sex(claims.get("sex") == null ? null : (Integer)claims.get("sex"))
                    .avatarUrl(claims.get("avatarUrl") + "")
                    .build();
        } catch (SignatureException se) {
            throw new AppException(ResultCode.FAIL, "签名错误");
        } catch (ExpiredJwtException ee) {
            throw new AppException(ResultCode.TOKEN_EXPRIED, "token过期");
        }
    }

    public static void main(String[] args) {
        User login = User.builder()
        .id(8987L)
        .nickName("小火枪")
        .sex(1)
        .telephone("18976543233").build();
        String token = createJWT(login);
        System.out.println(token);
        User user = parseJWT(token);
        System.out.println(user);

    }
}
