package com.br.mercorp.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T>{
	private T data ;
	private List < String > errors ;
}
