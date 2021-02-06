package io.learn.javacore.networking;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressExample {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface " + networkInterface.getName() + ":");
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                if (!inetAddresses.hasMoreElements()) {
                    System.out.println("\t(No addresses for this interface)");
                }
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.print("\tAddress "
                        + ((inetAddress instanceof Inet4Address ? "(v4)"
                         : (inetAddress instanceof Inet6Address ? "(v6)" : "(?)"))));
                    System.out.println("\t" + inetAddress.getHostAddress());
                }
            }
        } catch (SocketException e) {
            System.out.println("Error while obtaining");
        }
        for (String host : args) {
            try {
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }
}
