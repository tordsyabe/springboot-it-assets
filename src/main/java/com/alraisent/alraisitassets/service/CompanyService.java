package com.alraisent.alraisitassets.service;

import com.alraisent.alraisitassets.dto.CompanyDto;
import org.apache.xmlrpc.XmlRpcException;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public interface CompanyService {

    List<Map<String, CompanyDto>> getCompanies() throws MalformedURLException, XmlRpcException;
}
