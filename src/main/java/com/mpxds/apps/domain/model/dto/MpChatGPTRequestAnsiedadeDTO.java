package com.mpxds.apps.domain.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MpChatGPTRequestAnsiedadeDTO {
	//
    private String model;
    private List<MpMessageDTO> messages;
    
    //
    public MpChatGPTRequestAnsiedadeDTO(String model, String prompt) {
    	//
        this.model = model;
        
        this.messages = new ArrayList<>();

    	System.out.println("MpChatGPTRequestAnsiedadeDTO.init() ...000 ");
        
        this.messages.add(new MpMessageDTO("system", 
        		"Você é um assistente terapeuta, psicologo, hábil em dar dicas positivas " +
        		"e objetivas para pessoas que sofrem de transtorno de ansiedade."));
        this.messages.add(new MpMessageDTO("system", 
        		"Caso a pergunta não seja sobre o contexto sobre pessoas com transtorno de ansiedade, " + 
        		"responda com uma respota curta e objetiva, que esse tipo de pergunta está fora de contexto"));
        this.messages.add(new MpMessageDTO("user", prompt));
    }
        
}
