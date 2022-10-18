package firok.demo.mvci.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import firok.spring.mvci.MVCIntrospective;
import lombok.Data;

@Data
@TableName("d_user")
@MVCIntrospective
public class UserBean extends BaseBean
{
	String username;
	String password;
}
