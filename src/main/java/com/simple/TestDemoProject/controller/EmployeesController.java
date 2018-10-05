package com.simple.TestDemoProject.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simple.TestDemoProject.exception.UserNotFoundException;
import com.simple.TestDemoProject.exception.UserReadyExitException;
import com.simple.TestDemoProject.model.Address;
import com.simple.TestDemoProject.model.EmployeeInfo;
import com.simple.TestDemoProject.model.services.EmployeeService;
import com.simple.TestDemoProject.repo.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/emp")
//@Api(value="emp",description = "Rest API for Employee operations", tags = "Employee API")
public class EmployeesController {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeService employeeService;
	
	/*@ApiOperation(value="Display employee info")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="OK"),
			@ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")
	})*/
	@PostMapping("/save")
	public  String empSave(@RequestBody EmployeeInfo employeeInfo, HttpServletResponse response,HttpSession session)
			throws ParseException, UserReadyExitException {
		JSONObject json = new JSONObject();
		String sessionId=session.getId();
		System.out.println(sessionId);
		try {
			List<EmployeeInfo> empList = employeeService.getEmployee(employeeInfo);
			if (!empList.isEmpty()) {
				//json.put("status", "false");
				//json.put("message", "Email_id already exists.!");
                 throw new UserReadyExitException("Email_id already exists.! ");
                 
			} else {
				Address address=new Address();
				address.setHouseName("Welcome");
				address.setPinCode("123456");
				address.setTempAddress("sopra steria");
				address.setPermanentAddress("patel nagar sector 2");
				List<Address> listAddress=new ArrayList<>();
				listAddress.add(address);
				employeeInfo.setListAddress(listAddress);
				
				employeeRepository.save(employeeInfo);
				List<EmployeeInfo> allList = employeeService.getAllRecords();
				ModelAndView model = new ModelAndView();
				// model.addObject("employeeRecords", allList);
				json.put("employeeRecords", allList);
				json.put("status", "true");
				json.put("message", "Record added successfully!");
				response.setStatus(HttpStatus.SC_OK);
			}

		} catch (JSONException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			throw new UserReadyExitException("Email_id already exists.! ");
			//e.printStackTrace();
		}
		finally {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "*");
			response.setHeader("Access-Control-Allow-Headers", "*");
		}
		return json.toString();
	}

	@PostMapping("/searchEmpInfo")
	public @ResponseBody String searchEmpInfo(@RequestBody EmployeeInfo employeeInfo, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		List<EmployeeInfo> empListSerch = null;
		try {
			empListSerch = employeeService.searchEmpInfo(employeeInfo);
			if (!empListSerch.isEmpty()) {
				jsonArray.put(empListSerch);
				json.put("searchData", jsonArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "*");
			response.setHeader("Access-Control-Allow-Headers", "*");
		}

		return json.toString();
	}

	@GetMapping("/getAllEmployee")
	public @ResponseBody String getAllEmployee() throws UserNotFoundException  {
		JSONObject jsonObject = new JSONObject();
		try {
			List<EmployeeInfo> allList = employeeService.getAllRecords();
			//Collections.sort(allList, EmployeeInfo.firstNameComprator);
			if(allList==null) {
				throw new UserNotFoundException("user not found");
			}
			jsonObject.put("getData", allList);
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException("user not found");
		}catch(JSONException e) {
			
		}
		return jsonObject.toString();
	}

	@GetMapping("/greeting")
	public ModelAndView greeting() {
		List<EmployeeInfo> allList = employeeService.getAllRecords();
		ModelAndView model = new ModelAndView("registration");
		// model.addObject("employeeRecords", allList);
		return model;
	}
	
	@PatchMapping("/update/{emdId}")
	public String update(@PathVariable Integer emdId , @RequestBody EmployeeInfo employeeInfo)
	{
		try {
			//String  allList = employeeService.update(emdId,employeeInfo);
			employeeInfo.setEmdId(emdId);
			employeeInfo.setFirstName("titu");
			employeeRepository.saveAndFlush(employeeInfo);
			/*if(allList!=null) {
				
			}*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "update records in put method ";
	}
@GetMapping("/getEmpId/{empId}")
public EmployeeInfo getEmpInfo(@PathVariable Integer empId) throws UserReadyExitException {
	EmployeeInfo empInfo=employeeService.getEmpInfoId(empId);
	if(empInfo==null)
	{
		throw new UserReadyExitException("Employee doesn't exist !");
	}
	return empInfo;
}
@RequestMapping(value="/login", method=RequestMethod.POST)
public ModelAndView getOpenPage() {
	ModelAndView view=new ModelAndView();
	view.setViewName("registration");
	return view;
}
@GetMapping("/login")
public ModelAndView getOpenPage1() {
	ModelAndView view=new ModelAndView();
	view.setViewName("registration");
	return view;
}
}
