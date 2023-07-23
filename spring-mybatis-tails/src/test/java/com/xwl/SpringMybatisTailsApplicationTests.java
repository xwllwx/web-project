//package com.xwl;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
////@SpringBootTest
//class SpringMybatisTailsApplicationTests {
//
//    @Test
//    public void contextLoads() {
//        for (int i = 0; i < 1000; i++) {
//            String s = UUID.randomUUID().toString();
//            System.out.println(s);
//        }
//    }
//
//    @Test
//    public void testJwt(){
//        Map<String,Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("name","tom");
//
//        String jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "xwllwx")
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
//                .compact();
//        System.out.println(jwt);
//    }
//
//    @Test
//    public void testParseJwt(){
//        Claims parseJwt = Jwts.parser()
//                .setSigningKey("xwllwx")
//                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4OTE1MzgyM30.k3xa5XHyMAKCG9kTNITdzW1dCrc_DFRjrN02ZrCoBJo")
//                .getBody();
//        System.out.println(parseJwt);
//    }
//
//}
