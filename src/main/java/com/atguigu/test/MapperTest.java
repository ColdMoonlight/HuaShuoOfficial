package com.atguigu.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
//	@Autowired
//	DepartmentMapper departmentMapper;
//	
//	@Autowired
//	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
	/*	//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		
		//1、插入几个部门数据
//		departmentMapper.insertSelective(new Department(null, "文案部"));
//		departmentMapper.insertSelective(new Department(null, "UI部"));
		
		//2、生成员工数据，测试员工插入
//		employeeMapper.insertSelective(new Employee(null, "Jerry12", "M", "Jerry3@atguigu.com", 1));
		
		
		//sysUserMapper.insertSelective(new SysUser(null,"admin2","admin123456"));
		
//		SysUser sysUser = new SysUser();
//		sysUser.setUserName("admin");
//		sysUser.setUserPwd("admin123456");
//		
//		List<SysUser>  SysUserList = sysUserMapper.selectSysUser(sysUser);
//		System.out.println(SysUserList);
		
		//3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession�?
		
//		for(){
//			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@atguigu.com", 1));
//		}
//		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//		for(int i = 0;i<1000;i++){
//			String uid = UUID.randomUUID().toString().substring(0,5)+i;
//			mapper.insertSelective(new Employee(null,uid, "M", uid+"@atguigu.com", 1));
//		}
		System.out.println("批量完成");
		
	}

}
