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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class NetworkManager {
        private static final HashMap<Method, Class<?>> NETWORK_BUS = new HashMap<>();

        private static ConConServer server;
        private static ConConClient client;

        public static void registerNetworkClass(Class<?> c) {
                Method[] methods = c.getMethods();
                for (Method m : methods) {
                        if (m.isAnnotationPresent(NetworkHandler.class)) {
                                Class<?>[] argClasses = m.getParameterTypes();
                                if (argClasses.length != 1 || !NetworkMessage.class
                                                .isAssignableFrom(argClasses[0])) {
                                        System.out.println("Invalid parameters on "
                                                + "NetworkHandler method: " + m.getName());
                                } else {
                                        NETWORK_BUS.put(m, argClasses[0]);
                                }
                        }
                }
        }

        public static void post(NetworkMessage message) {
                for (Map.Entry<Method, Class<?>> listener : NETWORK_BUS.entrySet()) {
                        if (listener.getValue().isAssignableFrom(message.getClass())) {
                                try {
                                        // if (message instanceof NetworkMessageSomethingSomething)
                                        // listener.getKey().invoke(null,
                                        // (NetworkMessageSomethingSomething)message);
                                        // etc
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }

        public static boolean startServer(int port) {
                if (server != null || client != null) {
                        return false;
                }
                server = new ConConServer(port);
                server.start();
                return true;
        }

        public static void stopServer() {
                server.quit();
                server = null;
        }

        public static boolean startClient(String host, int port) {
                if (server != null || client != null) {
                        return false;
                }
                client = new ConConClient(host, port);
                return true;
        }

        public static void stopClient() {
                client = null;
        }

        public static boolean sendMessage(NetworkMessage message) {
                if (client == null) {
                        return false;
                }
                client.sendMessage(encodeToXML(message));
                return true;
        }

        protected static NetworkMessage decodeFromXML(String xml) {
                // some reflection wizardry or switching or something
                return null;
        }

        protected static String encodeToXML(NetworkMessage message) {
                // some reflection wizardry or switching or something
                return null;
        }
}