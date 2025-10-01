package barcode.zpl.socket.model;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component  
public class ZplConnect {
	private String zpl;
	private String IP;
	private Integer port;
	private Integer timeOut;
}
