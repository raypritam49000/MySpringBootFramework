package com.rest.api.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.api.model.Employee;
import com.rest.api.services.EmployeeService;

@Path("/rest/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Path("/getAllEmployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {

		try {
			List<Employee> employees = this.employeeService.findAll();

			if (employees.size() > 0 && employees != null) {
				return Response
						.ok(Map.of("message", "List Employees", "body", employees, "status", 200, "success", true))
						.build();
			} else {
				return Response
						.ok(Map.of("message", "Data Not Found", "body", employees, "status", 404, "success", false))
						.build();
			}
		} catch (Exception e) {
			return Response.ok(Map.of("message", e.getMessage(), "status", 502, "success", false)).build();
		}

	}

	@Path("/getEmployee/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@PathParam("id") long id) {

		try {
			Employee employee = this.employeeService.findById(id);

			if (employee != null && !employee.getName().equals("") && !employee.getSalary().equals("")
					&& !employee.getSalary().equals("")) {
				return Response
						.ok(Map.of("message", "List Employees", "body", employee, "status", 200, "success", true))
						.build();
			} else {
				return Response
						.ok(Map.of("message", "Data Not Found", "body", employee, "status", 404, "success", false))
						.build();
			}
		} catch (Exception e) {
			return Response.ok(Map.of("message", e.getMessage(), "status", 502, "success", false)).build();
		}

	}

	@Path("/createEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee employee) {

		try {
			if (employee != null && !employee.getName().equals("") && !employee.getSalary().equals("")
					&& !employee.getSalary().equals("")) {

				int result = this.employeeService.insert(employee);

				if (result > 0) {
					return Response.ok(Map.of("message", "Create Employee", "status", 201, "success", true)).build();
				} else {
					return Response.ok(Map.of("message", "Not Create Employee", "status", 404, "success", false))
							.build();
				}
			} else {
				return Response.ok(Map.of("message", "BAD_REQUEST_GATEWAY", "status", 502, "success", false)).build();
			}

		} catch (Exception e) {
			return Response.ok(Map.of("message", e.getMessage(), "status", 502, "success", false)).build();
		}

	}

	@Path("/deleteEmployee/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") long id) {

		try {
			int result = this.employeeService.deleteById(id);

			if (result > 0) {
				return Response.ok(Map.of("message", "Deleted Employee", "status", 204, "success", true)).build();
			} else {
				return Response.ok(Map.of("message", "Not Delete Employee", "status", 501, "success", false)).build();
			}

		} catch (Exception e) {
			return Response.ok(Map.of("message", e.getMessage(), "status", 502, "success", false)).build();
		}

	}

	@Path("/updateEmployee")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee employee) {
		System.out.println(employee);
		try {

			int result = this.employeeService.update(employee);
			System.out.println(result);

			if (result > 0) {
				return Response.ok(Map.of("message", "Update Employee", "status", 202, "success", true)).build();
			} else {
				return Response.ok(Map.of("message", "Not Update Employee", "status", 501, "success", false)).build();
			}

		} catch (Exception e) {
			return Response.ok(Map.of("message", e.getMessage(), "status", 502, "success", false)).build();
		}

	}

}
