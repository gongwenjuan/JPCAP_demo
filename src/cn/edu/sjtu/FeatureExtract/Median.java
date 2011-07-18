/**
 * 
 */
package cn.edu.sjtu.FeatureExtract;

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.packet.Packet;

/**
 * @author wenjuangong
 *
 */
public class Median {

public static String median() throws IOException{

	int m=0,n=0,i=0;
	int baochang[]=new int[3858];
	 
	JpcapCaptor captor=JpcapCaptor.openFile("./data/tcpudptest.pcap");

	while(true){
		  Packet packet=captor.getPacket();
		  if(packet==null || packet==Packet.EOF) break;
		  if(packet instanceof jpcap.packet.TCPPacket||packet instanceof jpcap.packet.UDPPacket){
			 
	baochang[i]=packet.len;
	i++;
	}
}
	boolean exchage=true;
	int j,k,l;
	for(j=0;j<3858;j++){
		 exchage=false;
		 //两两比较，找出每趟最小数据元素
		 for(k=3857;k>j;k--){
		  //将最小数据元素前移
		  if(baochang[k-1]>baochang[k]){
		   l=baochang[k-1];
		   baochang[k-1]=baochang[k];
		   baochang[k]=l;
		   exchage=true;
		  }
		 }
	}
	if(!exchage){
	m=baochang[1928];
	n=baochang[1929];
		  }
	String median=m+"/"+n;
	return median;
}
}




 
 
