package com.alraisent.alraisitassets;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.assertj.core.util.Lists.emptyList;

public class OdooXmlRpc {

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        final String url = "http://localhost:8069",
                db = "alraiF",
                username = "donato",
                password = "...donato09@";

        final XmlRpcClient client = new XmlRpcClient();

        final XmlRpcClientConfigImpl common_config = new XmlRpcClientConfigImpl();
        common_config.setServerURL(
                new URL(String.format("%s/xmlrpc/2/common", url)));
        client.execute(common_config, "version", emptyList());

        int uid = (int)client.execute(
                common_config, "authenticate", asList(
                        db, username, password, emptyMap()));

        final XmlRpcClient models = new XmlRpcClient() {{
            setConfig(new XmlRpcClientConfigImpl() {{
                setServerURL(new URL(String.format("%s/xmlrpc/2/object", url)));
            }});
        }};


        Object partners = asList((Object[])models.execute("execute_kw", asList(
                db, uid, password,
                "hr.employee", "search_read",
                emptyList(),
                new HashMap() {{
                    put("fields", emptyList());
                    put("limit", 5);
                }}
        )));

        System.out.println(partners);
    }
}
