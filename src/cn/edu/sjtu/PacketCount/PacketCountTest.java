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


public class PacketCountTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		JpcapCaptor captor=JpcapCaptor.openFile("/users/wenjuangong/testtrace.pcap");
		
		
//		int count=0;
//		while(true){
			  //read a packet from the opened file
//			  Packet packet=captor.getPacket();
			  //if some error occurred or EOF has reached, break the loop
//			  if(packet==null || packet==Packet.EOF) break;
			  //otherwise, count
//			  count++;

//			  System.out.println(packet);
			
//	 int a=captor.received_packets;
//		System.out.println(count);
	 
	    System.out.println(captor.received_packets);
	
//    	captor.close();
	}			
}


