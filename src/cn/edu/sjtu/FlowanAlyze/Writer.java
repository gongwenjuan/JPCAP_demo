/**
 * 
 */
package cn.edu.sjtu.FlowanAlyze;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.JpcapWriter;
import jpcap.packet.Packet;

/**
 * @author wenjuangong
 *
 */
public class Writer {
	public static void Write(JpcapCaptor captor,int i) throws IOException{
	
	 String filename="flow_"+i;

	 JpcapWriter writer=JpcapWriter.openDumpFile(captor,filename);

     Packet packet=captor.getPacket();
		  
     writer.writePacket(packet);
     
     writer.close();
}

}
