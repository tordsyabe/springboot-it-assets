package com.alraisent.alraisitassets.service;

import com.alraisent.alraisitassets.dto.EmployeeDto;
import org.apache.xmlrpc.XmlRpcException;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Map<String, EmployeeDto>> getEmployees() throws MalformedURLException, XmlRpcException;


}
