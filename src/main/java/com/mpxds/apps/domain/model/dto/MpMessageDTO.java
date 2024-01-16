package com.mpxds.apps.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MpMessageDTO {
	//
    private String role;
    private String content; //prompt
}
