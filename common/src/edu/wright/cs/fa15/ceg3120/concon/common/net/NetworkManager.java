/*
 * Copyright (C) 2015
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.fa15.ceg3120.concon.common.net;

import edu.wright.cs.fa15.ceg3120.concon.common.net.message.NetworkMessage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class NetworkManager
{
	private static final HashMap<Method, Class<?>> NETWORK_BUS = new HashMap<Method, Class<?>>();

    private static ConConServer server;
    private static ConConClient client;

    public static void registerNetworkClass(Class<?> c)
    {
        Method[] methods = c.getMethods();
        for (Method m : methods)
        {
            if (m.isAnnotationPresent(NetworkHandler.class))
            {
                Class<?>[] argClasses = m.getParameterTypes();
                if (argClasses.length != 1 || !NetworkMessage.class.isAssignableFrom(argClasses[0]))
                    System.out.println("Invalid parameters on NetworkHandler method: " + m.getName());
                else
                    NETWORK_BUS.put(m, argClasses[0]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void post(NetworkMessage message)
    {
        for (Map.Entry<Method, Class<?>> listener : NETWORK_BUS.entrySet())
        {
            if (listener.getValue().isAssignableFrom(message.getClass()))
            {
                try
                {
                	System.out.println("Recieved message: " + message);
                    //if (message instanceof NetworkMessageSomethingSomething)
                    //   listener.getKey().invoke(null, (NetworkMessageSomethingSomething)message);
                    // etc
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized boolean startServer(int port)
    {
        if (server != null || client != null)
            return false;
        server = new ConConServer(port);
        server.start();
        return true;
    }

    public static void stopServer()
    {
        server.quit();
        server = null;
    }

    public static synchronized boolean startClient(String host, int port)
    {
        if (server != null || client != null)
            return false;
        client = new ConConClient(host, port);
        return true;
    }

    public static void stopClient()
    {
        client = null;
    }

    public static boolean sendMessage(NetworkMessage message)
    {
        if (client == null)
            return false;
        try {
			client.sendMessage(encodeToXML(message));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    protected static NetworkMessage decodeFromXML(String xml) throws UnsupportedEncodingException
    {
        //some reflection wizardry or switching or something
    	XMLDecoder xmlWizard = new XMLDecoder(new ByteArrayInputStream(xml.getBytes("UTF-8")));
    	NetworkMessage result = (NetworkMessage) xmlWizard.readObject();
		xmlWizard.close();
        return result;
    }

    protected static String encodeToXML(NetworkMessage message) throws UnsupportedEncodingException
    {
        //some reflection wizardry or switching or something
		ByteArrayOutputStream out = new ByteArrayOutputStream();
    	XMLEncoder xmlWizard = new XMLEncoder(out, "UTF-8", false, 0);
    	xmlWizard.writeObject(message);
    	xmlWizard.close();
        return out.toString("UTF-8");
    }
}