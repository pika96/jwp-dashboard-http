package nextstep.jwp.http.response;

import nextstep.jwp.http.response.status.HttpStatus;

public class HttpResponse {

    private StatusLine statusLine;
    private ResponseHeader responseHeader = new ResponseHeader();
    private String responseBody = "";

    public HttpResponse() {
    }

    public void setStatusLine(String versionOfProtocol, HttpStatus httpStatus) {
        this.statusLine = new StatusLine(versionOfProtocol, httpStatus);
    }

    public void addResponseHeader(String header, String content) {
        responseHeader.addHeader(header, content);
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public void setCookie(String cookieName, String cookieValue) {
        responseHeader.addHeader("Set-Cookie", cookieName + "=" + cookieValue);
    }

    public String responseMessage() {
        return String.join("\r\n",
                statusLine.asString(),
                responseHeader.asString(),
                responseBody
        );
    }
}
