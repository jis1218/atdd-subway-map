package nextstep.subway.line.dto;

import nextstep.subway.line.domain.Line;
import nextstep.subway.station.domain.Station;
import nextstep.subway.station.dto.StationResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LineResponse {
    private Long id;
    private String name;
    private String color;
    private List<StationResponse> stationResponses;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public LineResponse() {
    }

    public LineResponse(Long id, String name, String color, List<StationResponse> stationResponses, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stationResponses = stationResponses;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static LineResponse of(Line line) {
        List<StationResponse> stationResponses =
                line.getSections()
                        .getStationList()
                        .stream().map(StationResponse::of)
                        .collect(Collectors.toList());
        return new LineResponse(line.getId(), line.getName(), line.getColor(), stationResponses, line.getCreatedDate(), line.getModifiedDate());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StationResponse> getStationResponses() {
        return stationResponses;
    }

    public String getColor() {
        return color;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
