package org.ucb.model;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IP {

	public static String getIP() {
		String ip = "localhost";
		boolean flag = false;
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface
					.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface iface = interfaces.nextElement();
				// filters out 127.0.0.1 and inactive interfaces
				if (iface.isLoopback() || !iface.isUp())
					continue;

				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress addr = addresses.nextElement();
					ip = addr.getHostAddress();
					if (iface.getDisplayName().equals(
							"AGN Virtual Network Adapter")) {
						flag = true;
						break;
					}
					// System.out.println(iface.getDisplayName() + " " + ip);
				}
				if (flag)
					break;
			}
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}

		return ip;
	}

}
