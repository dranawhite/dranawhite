package com.dranawhite.mq;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite 2018/04/23
 */
@Data
public class QueueConfig{

	private List<String> sendQueueNameList = new ArrayList<String>();
	
}
