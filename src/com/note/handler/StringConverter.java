package com.note.handler;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;  
import com.fasterxml.jackson.core.JsonProcessingException;  
import com.fasterxml.jackson.databind.JsonSerializer;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import com.fasterxml.jackson.databind.SerializerProvider;  

public class StringConverter extends  ObjectMapper  {

	private static final long serialVersionUID = 1L;

	public StringConverter() {
		 super();
		 this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {  
	            @Override  
	            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {  
	                jg.writeString("");  
	            }  
	        });  
	 }
}
