package com.totonero.bettypeservice.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BetResponseDTO {
    private String name;
    private Integer minimumAlertMinute;
    private Integer maximumAlertMinute;
}
