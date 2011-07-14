/**
 * 
 */
package cn.edu.sjtu.PacketCount;

/**
 * @author wenjuangong
 *
 */

import java.io.*;
//import java.io.IOException;
import jpcap.JpcapCaptor; 
import jpcap.packet.*;
//import jpcap.*;	


public class Advanced {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ReceivePacket a=new ReceivePacket();
		JpcapCaptor captor=JpcapCaptor.openFile("/users/wenjuangong/testtrace.pcap");
		while(true){
			  //read a packet from the opened filereceivePacket
			  Packet packet=captor.getPacket();
			  //if some error occurred or EOF has reached, break the loop
			  if(packet==null || packet==Packet.EOF) break;
			  //otherwise, count
              a.receivePacket(packet);
			}
	}

}
