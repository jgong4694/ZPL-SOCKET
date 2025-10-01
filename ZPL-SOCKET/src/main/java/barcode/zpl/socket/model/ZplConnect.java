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
	
	public ZplConnect() {
		String defaultHeight = "30";
		String defaultWidth = "32";
		String defaultValue = defaultHeight + "," + defaultWidth;
		String sizeValue = "33,32";
		String lotValue = "32,34";
		String MFGValue = "30,34";
		String NETValue = "31,32";
		String[] color = {"RED","BLUE","ORANGE","YELLOW","GREEN","APRICOT"};
		
		
		this.zpl = "^XA\r\n"
				+ "^FO0,0^IME:" + color[5] + ".PNG^FS\r\n"
				+ "^CW1,Z:FIXED.TTF\r\n" 
				+"^FT16,44^A1N," + defaultValue + "^FH^CI28^FDP/N : 112114149^FS^CI27"
				+"^FT17,44^A1N," + defaultValue + "^FH^CI28^FDP/N : 112114149^FS^CI27"
				+"^FT18,44^A1N," + defaultValue + "^FH^CI28^FDP/N : 112114149^FS^CI27"
				
				+"^FT16,78^A1N," + defaultValue + "^FH^CI28^FDLAS : SN96.5/AG3.0/CUO.5^FS^CI27"
				+"^FT17,78^A1N," + defaultValue + "^FH^CI28^FDLAS : SN96.5/AG3.0/CUO.5^FS^CI27"
				+"^FT18,78^A1N," + defaultValue + "^FH^CI28^FDLAS : SN96.5/AG3.0/CUO.5^FS^CI27"
				
				+"^FT16,112^A0N," + sizeValue + "^FH^CI28^FDSIZE : 0.085MM +/ - 0.0030MM^FS^CI27"
				+"^FT17,112^A0N," + sizeValue + "^FH^CI28^FDSIZE : 0.085MM +/ - 0.0030MM^FS^CI27"
				+"^FT18,112^A0N," + sizeValue + "^FH^CI28^FDSIZE : 0.085MM +/ - 0.0030MM^FS^CI27"
				
				+"^FT16,146^A1N," + lotValue + "^FH^CI28^FDLOT NO : A24004P085-D0001-03^FS^CI27"
				+"^FT17,146^A1N," + lotValue + "^FH^CI28^FDLOT NO : A24004P085-D0001-03^FS^CI27"
				+"^FT18,146^A1N," + lotValue + "^FH^CI28^FDLOT NO : A24004P085-D0001-03^FS^CI27"
				
				+"^FT16,180^A1N," + NETValue + "^FH^CI28^FDNET : 30,000,000^FS^CI27"
				+"^FT17,180^A1N," + NETValue + "^FH^CI28^FDNET : 30,000,000^FS^CI27"
				+"^FT18,180^A1N," + NETValue + "^FH^CI28^FDNET : 30,000,000^FS^CI27"
				
				+"^FT16,214^A1N," + MFGValue + "^FH^CI28^FDMFG DATE : 2024.06.14^FS^CI27"
				+"^FT17,214^A1N," + MFGValue + "^FH^CI28^FDMFG DATE : 2024.06.14^FS^CI27"
				+"^FT18,214^A1N," + MFGValue + "^FH^CI28^FDMFG DATE : 2024.06.14^FS^CI27"
				
				+"^FT16,248^A1N," + defaultValue + "^FH^CI28^FDEXP DATE : 2025.06.13^FS^CI27"
				+"^FT17,248^A1N," + defaultValue + "^FH^CI28^FDEXP DATE : 2025.06.13^FS^CI27"
				+"^FT18,248^A1N," + defaultValue + "^FH^CI28^FDEXP DATE : 2025.06.13^FS^CI27"
				
				+"^FT16,300^A1N," + defaultValue + "^FH^CI28^FDHANGOOK-BARCODE CO.,LTD.^FS^CI27"
				+"^FT17,300^A1N," + defaultValue + "^FH^CI28^FDHANGOOK-BARCODE CO.,LTD.^FS^CI27"
				+"^FT18,300^A1N," + defaultValue + "^FH^CI28^FDHANGOOK-BARCODE CO.,LTD.^FS^CI27"
				
				
				+"^FT838,171^BQN,2,7"
				+"^FH^FDLA,03^FS"
				+"^FT900,201^A1N,30,37^FH^CI28^FD03^FS^CI27"
				+"^FT901,201^A1N,30,37^FH^CI28^FD03^FS^CI27"
				
				+"^FO648,13^GE151,149,6^FS"
				+"^FT685,102^A1N,32,36^FH^CI28^FDROHS^FS^CI27"
				+"^FT686,102^A1N,32,36^FH^CI28^FDROHS^FS^CI27"
				+"^FT687,102^A1N,32,36^FH^CI28^FDROHS^FS^CI27"
				+ "^XZ";
		IP = "192.168.123.176";
		port = 9100;
		timeOut = 5000;
	}
	
	public void setSapmple9() {
		StringBuilder sb = new StringBuilder();
		ZplBuilder zb = new ZplBuilder();
		Integer Text1Height = 65;
		Integer Text2Height = Text1Height + 32;
		Integer Text3Height = Text2Height + 32;
		Integer Text4Height = Text3Height + 32;
		Integer Text5Height = Text4Height + 32;
		Integer Text6Height = Text5Height + 32;
		Integer Text7Height = Text6Height + 50;
		Integer startTextX = 26;
		
		sb.append("^XA");
		sb.append(zb.formatZplImage(805, 2, "RED.PNG"));
        sb.append(zb.formatZplField1Bold(startTextX, Text1Height, 26, 32, "Comp"));             
        sb.append(zb.formatZplField1Bold(startTextX, Text2Height, 26, 28, "Size"));    
        sb.append(zb.formatZplField1Bold(startTextX, Text3Height, 26, 32, "Q'ty"));            
        sb.append(zb.formatZplField1Bold(startTextX, Text4Height, 29, 29, "Lot no"));     
        sb.append(zb.formatZplField1Bold(startTextX, Text5Height, 29, 28, "Val"));
        sb.append(zb.formatZplField1Bold(startTextX, Text6Height, 30, 30, "Caution"));
        sb.append(zb.formatZplField1Bold(startTextX, Text7Height, 32, 30, "HANGOOK-BARCODE CO.,LTD."));
        
        sb.append("^FO420,162^GE151,149,6^FS");  
        sb.append(zb.formatZplField1Bold(438, 270, 78, 56, "0.07"));            
        sb.append(zb.formatZplField1Bold(100, Text1Height, 31, 30, ": SM96.5/AG3.0/CUO.5"));         
        sb.append(zb.formatZplField1Bold(95, Text2Height, 31, 30, ": 0.070MM +/- 0.003MM"));          
        sb.append(zb.formatZplField1Bold(100, Text3Height, 31, 30, ": 50,000,000EA"));       
        sb.append(zb.formatZplField1Bold(124, Text4Height, 31, 30, ": ET25079P070-003"));      
        sb.append(zb.formatZplField1Bold(82, Text5Height, 31, 30, ": 2026.03.10"));        
        sb.append(zb.formatZplField1Bold(144, Text6Height, 31, 30, ": MSDS(ROHS,H/F)"));      
        sb.append("^LL240\r\n"
        		+ "^LS0\r\n"
        		+ "^FT630,205^BQN,2,5\r\n"
        		+ "^FH\\^FDLA,https://kbarcode.com^FS");
        sb.append(zb.formatZplField1Bold(672, 250, 31, 30, "WEB"));
           
        
        sb.append("^PQ1,0,1,Y");
        sb.append("^XZ");
		
        this.zpl = sb.toString();
	}
	
	public void setSapmple10() {
		StringBuilder sb = new StringBuilder();
		ZplBuilder zb = new ZplBuilder();
		Integer Text1Height = 55;
		Integer Text2Height = Text1Height + 35;
		Integer Text3Height = Text2Height + 35;
		Integer Text4Height = Text3Height + 35;
		Integer Text5Height = Text4Height + 35;
		Integer Text6Height = Text5Height + 35;
		Integer Text7Height = 335;
		
		sb.append("^XA");
		sb.append(zb.formatZplImage(805, 23, "AURORA.PNG"));
        sb.append(zb.formatZplField1Bold(22, Text1Height, 28, 40, "Comp"));             
        sb.append(zb.formatZplField1ExtraBold(22, Text2Height, 29, 29, "Size"));    
        sb.append(zb.formatZplField1ExtraBold(22, Text3Height, 27, 29, "Q'ty"));            
        sb.append(zb.formatZplField1ExtraBold(22, Text4Height, 28, 30, "Lot no"));       
        sb.append(zb.formatZplField1ExtraBold(22, Text5Height, 31, 30, "Val"));
        sb.append(zb.formatZplField1ExtraBold(22, Text6Height, 29, 32, "Caution"));
        sb.append(zb.formatZplField1Bold(22, Text7Height, 28, 31, "HANGOOK-BARCODE CO.,LTD."));
        
		sb.append(zb.formatZplImage(400, 160, "S_ROUND.PNG"));
        sb.append(zb.formatZplField1(415, 265 , 68, 50, "0.063"));  
        sb.append(zb.formatZplField1Bold(110, Text1Height, 32, 34, ": SN99.3/CU0.7"));            
        sb.append(zb.formatZplField1Bold(91, Text2Height, 30, 39, ": 0.063MM +/- 0.0025MM"));         
        sb.append(zb.formatZplField1Bold(91, Text3Height, 32, 32, ": 50,000,000EA"));          
        sb.append(zb.formatZplField1Bold(123, Text4Height, 33, 40, ": DOD031"));       
        sb.append(zb.formatZplField1Bold(83, Text5Height, 33, 32, ": 2026.03.26"));       
        sb.append(zb.formatZplField1Bold(150, Text6Height, 32, 42, ": MDSD"));   
        sb.append(zb.formatZplField1Bold(666, Text7Height - 42, 28, 44, "003"));   
        sb.append(zb.formatQRBarcode(645, 252, 4, "https://kbarcode.com"));
        
        sb.append("^PQ1,0,1,Y");
        sb.append("^XZ");
		
        this.zpl = sb.toString();
	}
	
	
	public void setSapmple11() {
		StringBuilder sb = new StringBuilder();
		ZplBuilder zb = new ZplBuilder();
		Integer Text1Height = 80;
		Integer Text2Height = 120;
		Integer Text3Height = 160;
		Integer Text4Height = 200;
		Integer Text5Height = 240;
		
		sb.append("^XA");
		sb.append(zb.formatZplImage(805, 20, "ROHS.PNG"));
        sb.append(zb.formatZplField1Bold(22, Text1Height, 31, 27, "P/N :"));             
        sb.append(zb.formatZplField1Bold(22, Text2Height, 31, 27, "Net weight : "));    
        sb.append(zb.formatZplField1Bold(22, Text3Height, 31, 27, "LOT :"));            
        sb.append(zb.formatZplField1Bold(22, Text4Height, 31, 27, "EXP :"));            
        sb.append(zb.formatZplField1Bold(22, Text5Height, 32, 30, "HANGOOK-BARCODE CO.,LTD."));
        
        sb.append("^FO400,182^GE151,149,6^FS");  
        sb.append(zb.formatZplField1Bold(414, 288, 68, 48, "0.085"));            
        sb.append(zb.formatZplField1Bold(97, Text1Height, 31, 30, "C53320007"));         
        sb.append(zb.formatZplField1Bold(198, Text2Height, 31, 30, "0.0070g"));          
        sb.append(zb.formatZplField1Bold(101, Text3Height, 31, 30, "ET25042T085"));       
        sb.append(zb.formatZplField1Bold(101, Text4Height, 31, 30, "2026/03/18"));        
        
        sb.append("^PQ1,0,1,Y");
        sb.append("^XZ");
		
        this.zpl = sb.toString();
	}
	
	public void setSapmple12() {
		StringBuilder sb = new StringBuilder();
		ZplBuilder zb = new ZplBuilder();
		Integer defaultInterval = 38;
		Integer Text1Height = 50;
		Integer Text2Height = Text1Height + defaultInterval;
		Integer Text3Height = Text2Height + defaultInterval;
		Integer Text4Height = Text3Height + defaultInterval;
		Integer Text5Height = Text4Height + defaultInterval;
		Integer Text6Height = Text5Height + defaultInterval;
		Integer Text7Height = Text6Height + 98;
		Integer startTextX = 27;
		
		sb.append("^XA");
		sb.append(zb.formatZplImage(460, 140, "Y_ROUND.PNG"));
        sb.append(zb.formatZplField1Bold(startTextX, Text1Height, 30, 34, "Comp"));             
        sb.append(zb.formatZplField1Bold(startTextX, Text2Height, 30, 30, "Size"));    
        sb.append(zb.formatZplField1Bold(startTextX, Text3Height, 30, 34, "Q'ty"));            
        sb.append(zb.formatZplField1Bold(startTextX, Text4Height, 32, 31, "Lot no"));     
        sb.append(zb.formatZplField1Bold(startTextX, Text5Height, 32, 30, "Val"));
        sb.append(zb.formatZplField1Bold(startTextX, Text6Height, 33, 32, "Caution"));
        sb.append(zb.formatZplField1Bold(startTextX, Text7Height, 35, 32, "HANGOOK-BARCODE CO.,LTD."));
        
        sb.append(zb.formatZplField1ExtraBold(498, 270, 84, 110, "70"));            
        sb.append(zb.formatZplField1Bold(100, Text1Height, 32, 34, ": SN/0.7CU ULA"));         
        sb.append(zb.formatZplField1Bold(95, Text2Height, 31, 35, ": 0.070MM +/- 0.003MM"));          
        sb.append(zb.formatZplField1Bold(100, Text3Height, 31, 32, ": 30,000,000EA"));       
        sb.append(zb.formatZplField1Bold(124, Text4Height, 31, 35, ": OC122-002"));      
        sb.append(zb.formatZplField1Bold(82, Text5Height, 33, 32, ": 2026.03.08"));        
        sb.append(zb.formatZplField0Bold(144, Text6Height, 33, 32, ": MSDS"));      
        sb.append(zb.formatQRBarcode(735, 275, 7, "https://kbarcode.com"));
        
        sb.append("^PQ1,0,1,Y");
        sb.append("^XZ");
		
        this.zpl = sb.toString();
	}
}
