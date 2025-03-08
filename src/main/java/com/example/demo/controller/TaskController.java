package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskRepository trep;
	
	@PostMapping("/addData")
	public Task addData(@RequestBody Task t)
	{
		return trep.save(t);
	}
	
	@GetMapping("/show")
	public List<Task>getTasks()
	{
		return trep.findAll();
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Task> getTask(@PathVariable("id")long id)
	{
		Optional<Task> tsk = trep.findById(id);
		if(tsk.isPresent())
		{
			return new ResponseEntity<Task>(tsk.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Task>updateData(@PathVariable("id")long id,@RequestBody Task tsk)
	{
		Optional<Task>exist_task = trep.findById(id);
		if(exist_task.isPresent())
		{
			Task tupdate = new Task();
			tupdate.setId(tsk.getId());
			tupdate.setDate(tsk.getDate());
			tupdate.setDescr(tsk.getDescr());
			tupdate.setStatus(tsk.getStatus());
			tupdate.setName(tsk.getName());
			trep.save(tupdate);
			return new ResponseEntity<Task>(tupdate,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Task> deleteData(@PathVariable("id")long id)
	{
		 trep.deleteById(id);
		 return new ResponseEntity<Task>(HttpStatus.OK);
	}
}
