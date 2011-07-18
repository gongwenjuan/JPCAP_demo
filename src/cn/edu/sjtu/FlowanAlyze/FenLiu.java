/**
 * 
 */
package cn.edu.sjtu.FlowanAlyze;

import java.io.IOException;

import jpcap.JpcapWriter;
import jpcap.packet.Packet;
import jpcap.JpcapCaptor;

/**
 * @author wenjuangong
 *
 */
public class FenLiu {
	// 分流，即：将拥有相同无远足的数据包存在一个文件中组成一条流

	public void fenLiu(Packet p) throws IOException {
		
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
		int i=0;
		while(true){
			  Packet packet=captor.getPacket();

			if(packet==null || packet==Packet.EOF) break;
			  else if()
			  Writer wr=new Writer();
			  
			  
			  
			  
			}
		
	
			}
		
		

		captor.close();
	} 
}