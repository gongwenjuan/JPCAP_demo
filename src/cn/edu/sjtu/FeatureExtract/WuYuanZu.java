/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

/**
 * @author wenjuangong
 *
 */
public class WuYuanZu {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
		
		while(true){
			  
			  Packet packet=captor.getPacket();
		
			  if(packet==null || packet==Packet.EOF) break;
	
			  else  if (packet instanceof jpcap.packet.TCPPacket) {
				  
			  TCPPacket tcp = (TCPPacket) packet;
			  
		      System.out.println("TCPPacket");
		      System.out.println("Source IP address of this packet£º" + tcp.src_ip);
			  System.out.println("Destination IP address of this packet£º" + tcp.dst_ip);
			  System.out.println("Source port number of this packet£º" + tcp.src_port);
			  System.out.println("Destination port number of this packet£º" + tcp.dst_port );
			  System.out.println("Protocol type of this packet£º" + tcp.protocol + "(TCP)");
		      
			  }
				
			  else  if (packet instanceof jpcap.packet.UDPPacket) {
				  
			  UDPPacket udp = (UDPPacket) packet;
			  
			  System.out.println("UDPPacket");
		      System.out.println("Source IP address of this packet£º" + udp.src_ip);
			  System.out.println("Destination IP address of this packet£º" + udp.dst_ip);
			  System.out.println("Source port number of this packet£º" + udp.src_port );
			  System.out.println("Destination port number of this packet£º" + udp.dst_port);			  
			  System.out.println("Protocol type of this packet£º" + udp.protocol + "(TCP)");
		      
			  }
			}
		
     	captor.close();
	}

}
