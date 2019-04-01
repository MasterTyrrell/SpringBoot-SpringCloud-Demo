/**
 * 
 */ 
package com.alan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
* @author 作者 yyh: 
* @version 创建时间：2019年2月19日 下午10:54:43 
* 类说明 
*/
/**
 * @author yyh
 *
 */
@SpringBootApplication
@MapperScan("com.alan.mapper")//@Mapper用户扫描MyBatis的Mapper接口
public class App {
	
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
 