package vip.redcode.janaza.core.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PersonDto {

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String middleName;

    private LocalDateTime janazaDateTime;

    private String janazaAddress;

    private String latitude;

    private String longitude;

    private LocalDateTime createdAt;
}
