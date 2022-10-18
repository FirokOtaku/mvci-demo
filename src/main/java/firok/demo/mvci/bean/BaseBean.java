package firok.demo.mvci.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BaseBean
{
	@TableId
	String id;
}

