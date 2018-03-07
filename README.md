# dynamic-dataSource
Dynamic switching dataSource


本项目是用的mybatis 作为ORM框架

在application.properties 中配置主数据源的连接信息

src/main/resources/sql目录下放置的是数据库脚本

src/main/resources/spring/spring-mybatis.xml
配置主库的数据源等信息

spring-mybatis-dynamic.xml
配置的是动态数据源的连接信息

`	<bean id="sqlSessionFactory_dynamic" class="com.ztkj.core.handler.MySqlSessionFactoryBean">
 		<property name="dataSource" ref="dynamicDataSource" />
 		<!-- 指定扫描哪些路径下的配置文件 -->
 		<property name="mapperLocations" value="classpath:mapper2/*.xml"/>
 	</bean>
`

修改mapperLocations 修改动态数据源的查询语句配置

com.ztkj.core.aspect.DataSourceAspect 是负责切换数据源的拦截器
根据传入的token参数查询相应的数据源，并切换