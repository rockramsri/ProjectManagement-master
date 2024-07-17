/**
	 * @author Nithish
	
*/
package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.FileCount;
import com.example.demo.model.FileModel;
import com.example.demo.model.TicketGroupModel;

@Service
public class DashService {

	private MongoTemplate mongoTemplate;

	@Autowired
	private DefectService defectservice;

	@Autowired
	public DashService(MongoTemplate mongoTemplate) {

		this.mongoTemplate = mongoTemplate;
	}

	public long countFiles() {
		Query query = new Query();
		return mongoTemplate.count(query, FileModel.class);

	}

	public String addEntry(FileCount entry) {
		mongoTemplate.save(entry);
		return entry.getTime() + " " + entry.getFilesCount() + " added";

	}


}
