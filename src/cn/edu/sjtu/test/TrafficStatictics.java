/**
 * 
 */
package cn.edu.sjtu.test;

/**
 * @author wenjuangong
 *
 */

import java.io.IOException;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface; 

public class TrafficStatictics {

	/**
	 * @param args
	 */
	
	private static TrafficStatictics ts;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // 启动统计线程
		  TrafficStatictics.ins();
	}
	 public synchronized static TrafficStatictics ins() {
		  if (null == ts) {
		   TrafficStatictics ts = new TrafficStatictics();
		   ts.init();
		  }
		  return ts;
		 }

		 
		 public void init() {

		  // 获取本机上的网络接口对象
		  final NetworkInterface[] devices = JpcapCaptor.getDeviceList();

		  for (int i = 0; i < devices.length; i++) {
		   NetworkInterface ni = devices[i];

		   // 大于零时为有效地址；不抓本机地址
		   if (ni.addresses.length > 0) {

		    // 一个网卡可能有多个地址，只获取第一个
		    String addr = ni.addresses[0].address.toString();

		    try {
		     // 创建卡口上的抓取对象
		     JpcapCaptor jpcap = JpcapCaptor.openDevice(ni, 2000, true,
		       20);

		     // 创建对应的抓取线程并启动
		     LoopPacketThread lpt = new LoopPacketThread(jpcap, addr);
		     lpt.start();
		     System.out.println(addr + "上的采集线程已启动！！！");

		    } catch (IOException e) {
		     e.printStackTrace();
		     System.out.println("抓取数据包时出现异常!!!");
		    }

		   }
		  }

		 }

		}

