/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;
import jpcap.packet.UDPPacket;

/**
 * @author wenjuangong
 *
 */
public class OtherFeatures_UDP {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
		Packet packet=captor.getPacket();
		if (packet instanceof jpcap.packet.UDPPacket) {

			UDPPacket udp = (UDPPacket) packet;

			System.out.println("UDPPacket");
			System.out.println("源IP地址：" + udp.src_ip);
			System.out.println("目的IP地址：" + udp.dst_ip);
			System.out.println("源端口号：" + udp.src_port );
			System.out.println("目的端口号：" + udp.dst_port);			  
			System.out.println("协议类型：" + udp.protocol + "(TCP)");
		}
		captor.close();
	}
}
