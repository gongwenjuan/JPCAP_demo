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

public class test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JpcapCaptor captor=JpcapCaptor.openFile("/users/wenjuangong/testtrace.pcap");
		System.out.println(captor.received_packets);
	}

}
