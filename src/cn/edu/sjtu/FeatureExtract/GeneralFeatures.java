/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import javax.print.attribute.standard.MediaName;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;

/**
 * @author wenjuangong
 *
 */
public class GeneralFeatures {


	
	public static void main(String[] args) throws IOException {
		JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");
	
		int packetcount = 0;
		int PacketLength=0;
		int s=2147483647;
//		int类型的最大值
		int l=0;
		double average=0;

		while(true){
			  Packet packet=captor.getPacket();
			  if(packet==null || packet==Packet.EOF) break;
			  if(packet instanceof jpcap.packet.TCPPacket||packet instanceof jpcap.packet.UDPPacket){
			  packetcount++;
			  PacketLength += packet.len;
//	 最小IP包长	
			  int i=packet.len;
			  if(i<s)
				  s=i;
//   最大IP包长
			  if(i>l)
				 l=i;
			  }
		}
//		 IP包长的平均值
		  average=(double)PacketLength/packetcount;
//       IP包长的中位数
		  Median m=new Median();

		  
		System.out.println("最小IP包长为: "+s);
		System.out.println("最大IP包长为: "+l);
		System.out.println("IP包长的平均值为: "+average);
		System.out.println("IP包长的中位数为: "+m.median());
		
		captor.close();
	}
}