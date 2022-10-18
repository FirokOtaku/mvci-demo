package firok.demo.mvci.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import firok.spring.mvci.MVCIntrospective;
import lombok.Data;

@Data
@TableName("d_info")
@MVCIntrospective
public class InfoBean extends BaseBean
{
	@TableField("info_key")
	String key;
	@TableField("info_value")
	String value;
}
