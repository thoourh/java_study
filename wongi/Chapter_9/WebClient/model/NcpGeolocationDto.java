package dev.thoourh.webclient.model;

public class NcpGeolocationDto {
    private Long returnCode;
    private String requestId;
    private GeolocationData geolocation;

    public NcpGeolocationDto() {
    }

    public NcpGeolocationDto(Long returnCode, String requestId, GeolocationData geolocation) {
        this.returnCode = returnCode;
        this.requestId = requestId;
        this.geolocation = geolocation;
    }

    public Long getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Long returnCode) {
        this.returnCode = returnCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public GeolocationData getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(GeolocationData geolocation) {
        this.geolocation = geolocation;
    }

    @Override
    public String toString() {
        return "NcpGeolocationDto{" +
                "returnCode=" + returnCode +
                ", requestId='" + requestId + '\'' +
                ", geolocation=" + geolocation +
                '}';
    }
}
