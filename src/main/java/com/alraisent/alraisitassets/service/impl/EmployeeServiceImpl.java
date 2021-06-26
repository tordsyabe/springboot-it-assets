package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.EmployeeDto;
import com.alraisent.alraisitassets.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Map<String, EmployeeDto>> getEmployees() throws MalformedURLException, XmlRpcException {

        final String url = "http://192.168.10.17:8059",
                db = "Final_AlraisEnterprises",
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

        List partners = asList((Object[])models.execute("execute_kw", asList(
                db, uid, password,
                "hr.employee", "search_read",
                asList(asList(
                        asList("company_id", "=", 3))),
                new HashMap() {{
                    put("fields", asList("name", "job_title"));
                    put("limit", 5);
                }}
        )));
        ObjectMapper oMapper = new ObjectMapper();

        List<Map<String, EmployeeDto>> employeesDto = new ArrayList<>();

        partners.forEach(partner -> {
            Map<String, EmployeeDto> employeeDtoMap = oMapper.convertValue(partner, Map.class);

            employeesDto.add(employeeDtoMap);

        });

        return employeesDto;
    }
}
