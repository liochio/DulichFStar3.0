package ResponseObject;

import Header.Header;
import Result.Result;

public class ResponseObject {
	private Header header;
	private Result result;

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
