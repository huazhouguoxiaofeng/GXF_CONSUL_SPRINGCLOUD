package com.gxf.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	
	private Object data;

	private String msg;
	
}
