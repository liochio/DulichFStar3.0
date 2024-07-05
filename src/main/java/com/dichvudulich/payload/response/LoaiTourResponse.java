package com.dichvudulich.payload.response;

import Header.Header;
import Result.Result;

public class LoaiTourResponse<T> {
	private Header header;
	private Result result;
	private T data;

	// Constructors
	public LoaiTourResponse() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
