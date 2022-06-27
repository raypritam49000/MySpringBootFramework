package com.rest.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.common.Constants;
import com.rest.api.common.Response;
import com.rest.api.model.PersonVO;
import com.rest.api.servcies.PersonService;

@RestController
@RequestMapping("/rest/v1")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getPerson/{id}")
	public Response findByPersonId(@PathVariable("id") Integer id) {
		try {

			PersonVO personVO = null;
			List<PersonVO> personVOs = new ArrayList<>();
			if (null != id) {
				personVO = personService.findById(id);
				personVOs.add(personVO);
			}

			if (null != personVOs && !personVOs.isEmpty()) {
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, personVOs, "Person list",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, personVOs,
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@PostMapping("/createPerson")
	public Response createPerson(@RequestBody PersonVO personVO) {

		try {
			PersonVO personVOdb = personService.createPerson(personVO);

			if (null != personVOdb && personVOdb.getId() != null) {
				return new Response(HttpStatus.CREATED, Constants.HTTP_STATUS_CODE_CREATED, new ArrayList<>(),
						"Person created", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Person is not create", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@GetMapping("/getAllPersons")
	public Response getAllPersons() {
		try {
			List<PersonVO> personVOList = this.personService.getAllPersons();

			if (null != personVOList && !personVOList.isEmpty()) {
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, personVOList, "Person list",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, personVOList,
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@PutMapping("/updatePerson")
	public Response updatePlanPriority(@RequestBody PersonVO personVO) {

		try {
			Boolean isUpdatePerson = this.personService.updatePerson(personVO);

			if (isUpdatePerson) {

				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
						"Person Priority Updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"Person is not updated", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (Exception exception) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

}
