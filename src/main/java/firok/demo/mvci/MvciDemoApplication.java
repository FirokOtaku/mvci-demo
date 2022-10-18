package firok.demo.mvci;

//import firok.spring.mvci.runtime.CurrentMappers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import firok.demo.mvci.bean.InfoBean;
import firok.demo.mvci.bean.UserBean;
import firok.spring.mvci.runtime.CurrentMappers;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.util.UUID;

@SpringBootApplication
@MapperScan("firok.demo.mvci.mapper")
@ComponentScans({
		@ComponentScan("firok.demo.mvci.service"),
		@ComponentScan("firok.demo.mvci.service_impl"),
		@ComponentScan("firok.demo.mvci.mapper"),
		@ComponentScan("firok.spring.mvci.runtime"),
})
public class MvciDemoApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MvciDemoApplication.class, args);
	}

	@Autowired
	IService<UserBean> serviceUser;

	@Autowired
	IService<InfoBean> serviceInfo;

	@Autowired
	CurrentMappers mappers;

	@Bean
	public CommandLineRunner afterStarted()
	{
		return (args) -> {
			System.out.printf("%d users in database.\n", serviceUser.count());
			serviceUser.remove(new QueryWrapper<>());

			var user1 = new UserBean();
			var user1id = UUID.randomUUID().toString();
			user1.setId(user1id);
			user1.setUsername("user1");
			user1.setPassword("password1");
			serviceUser.save(user1);
			System.out.printf("%d users in database.\n", serviceUser.count());

			var user1db = serviceUser.getById(user1id);
			System.out.printf("read user1 from db: %s, %s\n", user1db.getUsername(), user1db.getPassword());
			serviceUser.removeById(user1id);
			System.out.printf("%d users in database.\n", serviceUser.count());

			System.out.printf("%d infos in database.\n", serviceInfo.count());
			serviceInfo.remove(new QueryWrapper<>());
			var info1 = new InfoBean();
			var info1id = UUID.randomUUID().toString();
			info1.setId(info1id);
			info1.setKey("key1");
			info1.setValue("value1");
			serviceInfo.save(info1);
			System.out.printf("%d infos in database.\n", serviceInfo.count());
			serviceInfo.remove(new QueryWrapper<>());

			System.out.println("all mappers:");
			for(var mapper : mappers.getAllInstances())
			{
				System.out.println(mapper);
			}
		};
	}

}
