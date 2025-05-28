package barcode.zpl.socket.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Component  
public class ZplConnect {
	private String zpl;
	private String IP;
	private Integer port;
	private Integer timeOut;
	
	
}
