package com.br.mercorp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDTO {
	private Long id;
	private int version;
    private String acronym;
    private String name;
    private String url;
}
