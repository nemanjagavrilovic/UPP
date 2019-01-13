package com.upp.upp.converter;
import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.task.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.upp.upp.model.TaskDto;

@Component
public class TaskToTaskDtoConverter implements Converter<Task,TaskDto> {

	@Override
	public TaskDto convert(Task arg0) {
		// TODO Auto-generated method stub
		TaskDto taskDto = new TaskDto();
		taskDto.setAssignee(arg0.getAssignee());
		taskDto.setName(arg0.getName());
		taskDto.setTaskId(arg0.getId());
		return taskDto;
	}
	public List<TaskDto> convertList(List<Task> tasks) {
		List<TaskDto> list = new ArrayList<>();
		if(tasks != null) {
			for(Task task : tasks) {
				list.add(convert(task));
			}
		}
		return list;
	}
}
