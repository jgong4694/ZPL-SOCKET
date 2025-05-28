package barcode.zpl.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import barcode.zpl.socket.model.ZplConnect;

@SpringBootTest
public class ZPLSocketConnect {
	
	
	@Test
    public void sendZpl() {
		ZplConnect connect = new ZplConnect();
		System.out.println(connect.toString());
		
        // try-with-resources 로 소켓과 스트림을 자동으로 닫도록 보장
        try (Socket socket = new Socket()) {
            // 1) 소켓 연결: IP와 포트, 연결 타임아웃 설정
            socket.connect(
                new InetSocketAddress(connect.getIP(), connect.getPort()),
                connect.getTimeOut()
            );
            // 2) 출력 스트림 획득 (UTF-8 인코딩 권장)
            OutputStream out = socket.getOutputStream();
            // 3) ZPL 문자열 전송
            byte[] bytes = connect.getZpl().getBytes(StandardCharsets.UTF_8);
            out.write(bytes);
            out.flush();  // 전송 후 버퍼 비우기

            // 4) try-with-resources 가 소켓/스트림 자동 종료
        } catch (IOException e) {
            // 예외 처리: 로깅 후 필요에 따라 재시도 로직 추가 가능
            throw new RuntimeException("프린터로 ZPL 전송 중 오류 발생", e);
        }
    }
}
