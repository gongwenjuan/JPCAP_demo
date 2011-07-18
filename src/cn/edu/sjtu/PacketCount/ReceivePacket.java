/**
 * 
 */
package cn.edu.sjtu.PacketCount;

/**
 * @author wenjuangong
 *
 */



//import jpcap.PacketReceiver;
//import jpcap.packet.ARPPacket;
//import jpcap.packet.ICMPPacket;
//import jpcap.packet.Packet;
//import jpcap.packet.TCPPacket;
//import jpcap.packet.UDPPacket; 
import jpcap.packet.*;

public class ReceivePacket  {
//	类ReceivePacket声明自己使用接口PacketReceiver
	
	  int packetCount = 0;
	  int tcpPacketCount = 0;
	  int udpPacketCount = 0;
	  int icmpPacketCount=0;
	  int arpPacketCount=0;
	  int tcpPacketLength = 0;
	  int udpPacketLength = 0;
	  int icmpPacketLength = 0;
	  int arpPacketLength = 0;
	
	 public void receivePacket(Packet p) {
	  packetCount++;

	  // 如果截获的包为TCP包
	  if (p instanceof jpcap.packet.TCPPacket) {
	   tcpPacketCount++;

	   TCPPacket tcp = (TCPPacket) p;
//	   定义一个新的TCPPacket名字叫tcp，赋值为抓到的包p (??具体什么是这样的语句不是很清楚)

	  tcpPacketLength += tcp.len;
//	   a+=n即为a=a+b

	   System.out
	     .println("================================================================================");
	   System.out.println("TCPPacket");
	   System.out.println("Source IP address of this packet：" + tcp.src_ip);
	   System.out.println("Destination IP address of this packet：" + tcp.dst_ip);
	   System.out.println("Protocol type of this packet：" + tcp.protocol + "(TCP)");
	   System.out.println("Length of this packet：" + tcp.len);

	  } else if (p instanceof jpcap.packet.UDPPacket) {
		  // 如果截获的包为UDP包
	   udpPacketCount++;

	   UDPPacket udp = (UDPPacket) p;

	   udpPacketLength += udp.len;

	   System.out
	     .println("================================================================================");
	   System.out.println("UDPPacket");
	   System.out.println("Source IP address of this packet：" + udp.src_ip);
	   System.out.println("Destination IP address of this packet：" + udp.dst_ip);
	   System.out.println("Protocol type of this packet：" + udp.protocol + "(UDP)");
	   System.out.println("Length of this packet：" + udp.len);

	  } 
	  
	  else if (p instanceof jpcap.packet.ARPPacket) {
		  // 如果截获的包为ARP包
	   arpPacketCount++;

	   ARPPacket arp = (ARPPacket) p;

	   arpPacketLength += arp.len;

	   System.out
	     .println("================================================================================");
	   System.out.println("ARPPacket");
	   System.out.println("Sender hardware address of this packet：" + arp.sender_hardaddr   );
	   System.out.println("Target hardware address of this packet：" + arp.target_hardaddr  );
	   System.out.println("Protocol type of this packet：" + arp.prototype + "(ARP)");
	   System.out.println("Length of this packet：" + arp.len);
	  }
	  
	  else if (p instanceof jpcap.packet.ICMPPacket) {
		  // 如果截获的包为ICMP包
	   icmpPacketCount++;

	   ICMPPacket icmp = (ICMPPacket) p;

	   icmpPacketLength += icmp.len;

	   System.out
	     .println("================================================================================");
	   System.out.println("ICMPPacket");
	   System.out.println("Source IP address of this packet：" + icmp.src_ip);
	   System.out.println("Destination IP address of this packet：" + icmp.dst_ip);
	   System.out.println("Protocol type of this packet：" + icmp.protocol + "(UDP)");
	   System.out.println("Length of this packet：" + icmp.len);
	  }
	  
	  System.out.println();
	  System.out.println("Up to now：");
	  System.out.println("The total number of captured packets is：" + packetCount);
	  System.out.println("The total number of captured TCP packets is：" + tcpPacketCount
	    + ",The total length of captured TCP packets is: " + tcpPacketLength);
	  System.out.println("The total number of captured UDP packets is：" + udpPacketCount
	    + ",The total length of captured UDP packets is: " + udpPacketLength);
	  System.out.println("The total number of captured ARP packets is：" + arpPacketCount
			    + ",The total length of captured ARP packets is: " + arpPacketLength);
	  System.out.println("The total number of captured ICMP packets is：" + icmpPacketCount
			    + ",The total length of captured ICMP packets is: " + icmpPacketLength);
	 }
	}



	