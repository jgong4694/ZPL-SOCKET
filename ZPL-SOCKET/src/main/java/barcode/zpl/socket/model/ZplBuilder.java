package barcode.zpl.socket.model;

public class ZplBuilder {
	
	
	ZplBuilder (){}; 
	
    public String formatZplField0(int x, int y, int fontHeight, int fontWidth, String content) {
        return String.format("^FT%d,%d^A0N,%d,%d^FH^CI28^FD%s^FS^CI27",
                             x, y, fontHeight, fontWidth, content);
    }
    
    public String formatZplField1(int x, int y, int fontHeight, int fontWidth, String content) {
        return String.format("^FT%d,%d^A1N,%d,%d^FH^CI28^FD%s^FS^CI27",
                             x, y, fontHeight, fontWidth, content);
    }
    
    public String formatZplField0Bold(int x, int y, int fontHeight, int fontWidth, String content) {
        StringBuilder sb = new StringBuilder();
        
        // 원래 위치에 출력
        sb.append(formatZplField0(x, y, fontHeight, fontWidth, content));
        // 오른쪽으로 1픽셀 이동하여 중복 출력
        sb.append(formatZplField0(x + 1, y, fontHeight, fontWidth, content));
        
        return sb.toString();
    }
    
    public String formatZplField1Bold(int x, int y, int fontHeight, int fontWidth, String content) {
        StringBuilder sb = new StringBuilder();
        
        // 원래 위치에 출력
        sb.append(formatZplField1(x, y, fontHeight, fontWidth, content));
        // 오른쪽으로 1픽셀 이동하여 중복 출력
        sb.append(formatZplField1(x + 1, y, fontHeight, fontWidth, content));
        
        return sb.toString();
    }
    
    
    public String formatZplField1ExtraBold(int x, int y, int fontHeight, int fontWidth, String content) {
        StringBuilder sb = new StringBuilder();
        
        // 원래 위치에 출력
        sb.append(formatZplField1(x, y, fontHeight, fontWidth, content));
        // 오른쪽으로 1픽셀 이동하여 중복 출력
        sb.append(formatZplField1(x + 1, y, fontHeight, fontWidth, content));
        
        sb.append(formatZplField1(x + 2, y, fontHeight, fontWidth, content));
        
        sb.append(formatZplField1(x + 3, y+1, fontHeight, fontWidth, content));
        
        return sb.toString();
    }
    
    
    public String formatZplImage(int x, int y, String imageName) {
        return String.format("^FO%d,%d^IM%s^FS",
                             x, y, imageName);
    }
    
    public String format1DBarcode(int x, int y, int module, int height, String barcode, String content) {
    	if(barcode == null) barcode = "BCN";
    	StringBuilder sb = new StringBuilder();
    	sb.append("^BY").append(module).append(",3,").append(height).append("\r\n");
        sb.append("^BY").append(module).append(",3,").append(height).append("\r\n")
        .append("^FT").append(x).append(",").append(y).append("^BCN,").append(height).append(",Y,N,N\r\n")
        .append("^FD").append(content).append("^FS");
    	return sb.toString();
    }
    
    
    public String formatQRBarcode(int x, int y, int msg, String content) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("^LS0\r\n");
    	sb.append("^FT" + x + "," + y + "^BQN" + ",2," + msg + "\r\n");
    	sb.append("^FH\\^FDLA," + content + "^FS");
    	return sb.toString();
    }
    
}
