package com.mpxds.apps.domain.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MpChatGPTRequestDTO {
	//
    private String model;
    private List<MpMessageDTO> messages;

    public MpChatGPTRequestDTO(String model, String prompt) {
    	//
        this.model = model;
        
        this.messages = new ArrayList<>();
        this.messages.add(new MpMessageDTO("user", prompt));
    }
}
