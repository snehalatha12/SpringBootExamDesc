package com.Trainer.ExceptionHandling;

public class KeyViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public KeyViolationException(String msg) {
		super(msg);
	}
}
