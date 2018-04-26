package com.rw.slamschedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rw.slamschedule.controller.CommandMapperController;
import com.rw.slamschedule.domain.*;
import com.rw.slamschedule.repository.CommandMapperRepository;
import com.rw.slamschedule.repository.SubmessageRepository;
import com.rw.slamschedule.repository.TerminalRepository;
import com.rw.slamschedule.service.CommandMapperService;
import com.rw.slamschedule.service.SubmessageService;
import com.rw.slamschedule.service.TerminalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlamscheduleApplicationTests {

	@Autowired
	private ObjectMapper mapper;


	private MockMvc mvc;

	@Autowired
	private CommandMapperService service;

	@Autowired
	private TerminalService terminalService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testCommandMapperController() throws Exception{
		// 测试UserController
		RequestBuilder request = null;

		// 1、get查一下mapper列表，应该为空
//		request = get("/cmdmappers");
//		mvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("[]")));

		// 2、post提交一个mapper
		List<Point> points = new ArrayList<>();
		Point point = new Point();
		point.setX("1.1");
		point.setY("1.2");
		points.add(point);


		Submessage submessage = new Submessage();
		submessage.setSubmessage("moveTo");
		submessage.setPoints(points);
		submessage.setAppending("1");
		submessage.setIsMilestone("1");
		//submessage.setServeTime("1000");
		submessage.setPoints(points);
		point.setSubmessage(submessage);
		List<Submessage> submessages = new ArrayList<>();
		submessages.add(submessage);

		CommandMapper commandMapper = new CommandMapper();
		commandMapper.setName("test");
		commandMapper.setSubmessages(submessages);
		submessage.setCommandMapper(commandMapper);

		String json = mapper.writeValueAsString(commandMapper);

		request = post("/cmdmappers/post")
				.content(json);
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));

		CommandMapper commandMapper1 = service.findOne(1);

	}



	@Autowired
	SubmessageRepository submessageRepository;

	@Autowired
	SubmessageService submessageService;

	@Test
	public void testDeleteSubmessage() {

		submessageService.removeSubmessage(12);
	}

	@Autowired
	TerminalRepository terminalRepository;

	@Test
	public void testDeleteTerminal(){
	}
}
