package com.rahul.controller;

import lombok.Data;

@Data
public class RequestPayload {
	private String prompt;
    private int max_tokens = 50;

    public RequestPayload(String prompt) {
        this.prompt = prompt;
    }
}
