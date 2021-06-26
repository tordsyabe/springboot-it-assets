package com.alraisent.alraisitassets.service.impl;

import com.alraisent.alraisitassets.dto.CompanyDto;
import com.alraisent.alraisitassets.dto.EmployeeDto;
import com.alraisent.alraisitassets.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<Map<String, CompanyDto>> getCompanies() throws MalformedURLException, XmlRpcException {

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

        List companies = asList((Object[])models.execute("execute_kw", asList(
                db, uid, password,
                "res.company", "search_read", emptyList(),
                new HashMap() {{
                    put("fields", asList("name"));
                }}
        )));

        ObjectMapper oMapper = new ObjectMapper();

        List<Map<String, CompanyDto>> companiesDto = new ArrayList<>();

        companies.forEach(company -> {
            Map<String, CompanyDto> companyDtoMap = oMapper.convertValue(company, Map.class);

            companiesDto.add(companyDtoMap);

        });

        return companiesDto;
    }
}
