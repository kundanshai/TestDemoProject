package com.simple.TestDemoProject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesControllerTest {
	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmpSave() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("firstName", "Sohan");
		obj.put("lastName", "singh");
		obj.put("emailId", "Sohan@gmail.com");
		try {
			mockMvc.perform(post("http://localhost:8080/emp/save").contentType(MediaType.APPLICATION_JSON)
					.content(obj.toString())).andExpect(status().isOk()).andDo(print());
			System.out.println("MVC result ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected = "{message:Record added successfully!,status:true}";
		// fail("Not yet implemented");
	}

	/*
	 * @Test public void testSearchEmpInfo() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetAllEmployee() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGreeting() { fail("Not yet implemented"); }
	 */
}
