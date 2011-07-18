/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;

/**
 * @author wenjuangong
 *
 */
public class OtherFeartures_TCP {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
		Packet packet=captor.getPacket();
		
		if (packet instanceof jpcap.packet.TCPPacket) {

			TCPPacket tcp = (TCPPacket) packet;
			System.out.println("TCPPacket");
            System.out.println("源IP地址：" + tcp.src_ip);
	        System.out.println("目的IP地址：" + tcp.dst_ip);
	        System.out.println("源端口号：" + tcp.src_port);
	        System.out.println("目的端口号：" + tcp.dst_port );
	        System.out.println("协议类型：" + tcp.protocol + "(TCP)");
	        }
		captor.close();
	}
}
