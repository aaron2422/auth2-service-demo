# auth2-service-demo
基于Spring security实现的权限认证
1. 获取token:

   > localhost:8888/oauth/token?username=tom&password=111&grant_type=password&scope=select&client_id=andorid-app&client_secret=123

2. 测试API：

   > localhost:8888/api/user/me?access_token=9dee906e-4dc7-44b5-8ec0-21f92382ed76 //换成自己的access_token

   > localhost:8888/api/role/2?access_token=9dee906e-4dc7-44b5-8ec0-21f92382ed76 //换成自己的access_token

3. 说明：

   1. 目前只实现了password模式

   2. 数据库脚本在项目里，resources目录下。,需要手动初始化。

   3. 为了方便测试secret以及密码都是明文存储，可修改为加密后存储，只需去掉：

      ```java
      passwordEncoder.encode(user.getPassword()
      ```

   4. 默认token存储在MySQL数据库，可切换到redis或内存

      ```java
          @Override
          public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
      
              // token存储在memory中
              //endpoints.tokenStore(new InMemoryTokenStore()).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
      
              // token存储在redis中
              //endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory)).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
      
              // token存储在DB中
              endpoints.tokenStore(new JdbcTokenStore(dataSource)).authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
          }
      
      ```

      ```
      ### 取消注释可以切换到redis存储
      #    redis:
      #        host: 127.0.0.1
      #        database: 0
      
      logging.level.org.springframework.security: DEBUG
      ```

      

   5. 重写了ClientDetailsService、UserDetailService使用同一个类实现的，也可以分开。

      ```java
      @Slf4j
      @Service("dbUserAndClientDetailsService")
      public class DbUserAndClientDetailsService implements UserDetailsService, ClientDetailsService {
      
          	// 省略...
          
          @Override
          public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      		// 省略...
          }
      
          @Override
          public ClientDetails loadClientByClientId(String s) throws UsernameNotFoundException {
      		// 省略...
          }
      }
      ```
   TODO 
 
