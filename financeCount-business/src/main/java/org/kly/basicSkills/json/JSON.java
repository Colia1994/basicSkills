package org.kly.basicSkills.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author colia
 * @date 2019/10/24 22:55
 */
public class JSON {


    public static void main(String[] args) {
        String test = "{\"multi_entry\":0,\"\":{\"ip1\":{\"ip\":\"\",\"interface\":\"\"}}}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MultiIpPreferences multiIpPreferences = objectMapper.readValue(test, MultiIpPreferences.class);
            if (null != multiIpPreferences) {
                System.out.println(multiIpPreferences.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
