package com.easycode.gcubot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KKORestAPI {

    //카카오톡 오픈빌더로 리턴할 스킬 API
    @RequestMapping(value = "/kkoChat/v1" , method= {RequestMethod.POST , RequestMethod.GET },headers = {"Accept=application/json"})
    public HashMap<String,Object> callAPI(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {

        HashMap<String, Object> resultJson = new HashMap<>();

        try{

            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            System.out.println(jsonInString);

            /* 발화 처리 부분 * */
            HashMap<String,Object> userRequest =  (HashMap<String,Object>)params.get("userRequest");
            String utter = userRequest.get("utterance").toString().replace("\n","");

            String rtnStr = "";
            switch (utter){
                case "뭐야" : rtnStr = "코딩32 챗봇입니다.";
                    break;
                case "ㅋㅋ" : rtnStr = "저도 기분이 좋네요";
                    break;
                default: rtnStr = "안녕하세요 코딩 32 챗봇입니다.";
            }
            /* 발화 처리 끝*/

            List<HashMap<String,Object>> outputs = new ArrayList<>();
            HashMap<String,Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();

            text.put("text",rtnStr);
            simpleText.put("simpleText",text);
            outputs.add(simpleText);

            template.put("outputs",outputs);

            resultJson.put("version","2.0");
            resultJson.put("template",template);

        }catch (Exception e){

        }

        return resultJson;
    }

}