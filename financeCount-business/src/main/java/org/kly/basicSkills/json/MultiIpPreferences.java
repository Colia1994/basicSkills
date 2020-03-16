package org.kly.basicSkills.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author colia
 * @date 2019/10/24 22:56
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiIpPreferences {

    @JsonProperty("multi_entry")
    private int multiEntry;

    private Ips ips;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Ips{
        public Ip ip1;
        public Ip ip2;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Ip{
            public String ip;

            public String connector;
        }
    }


}
