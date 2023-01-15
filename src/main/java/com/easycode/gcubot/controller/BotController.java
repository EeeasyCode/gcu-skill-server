package com.easycode.gcubot.controller;

import java.util.ArrayList;

import com.easycode.gcubot.vo.KeyboardVO;
import com.easycode.gcubot.vo.MessageVO;
import com.easycode.gcubot.vo.RequestMessageVO;
import com.easycode.gcubot.vo.ResponseMessageVO;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;


@RestController
public class BotController {

//========== VO로 구현 ==========

    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public KeyboardVO keyboard() {

        KeyboardVO keyboard = new KeyboardVO
                (new String[] {"챗봇이랑 대화하기", "공지사항 보기", "FAQ 보기", "1:1 문의하기"});

        return keyboard;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST, produces="application/json; charset=UTF-8")
    @ResponseBody
    public ResponseMessageVO message(@RequestBody RequestMessageVO vo)
    {
        ResponseMessageVO res_vo=new ResponseMessageVO();
        MessageVO mes_vo=new MessageVO();


//        String command = vo.getContent();
        System.out.println(vo);
//        System.out.println(command);


//        if(command.equals("메뉴")) {

            mes_vo.setText("메뉴에서 명령을 선택해주세요~");
            KeyboardVO keyboard = new KeyboardVO(new String[]
                    {"챗봇이랑 대화하기", "공지사항 보기", "FAQ 보기", "1:1 문의하기"});
            res_vo.setKeyboard(keyboard);
//        }

//        else if(command.equals("1:1 문의하기")) {
//
//            MessageButtonVO messageButton = new MessageButtonVO();
//            messageButton.setLabel("1:1 문의하러 가기");
//            messageButton.setUrl("https://www.funda.kr/v2/contact");
//            mes_vo.setMessage_button(messageButton);
//            mes_vo.setText("안녕하세요 고객님, 아래의 URL을 클릭하여 1:1 문의사항을 작성해주세요. (메뉴 다시보기 = '메뉴' 입력!)");
//        }
//        else if(command.equals("공지사항 보기")) {
//
//            MessageButtonVO messageButton = new MessageButtonVO();
//            messageButton.setLabel("공지사항 보러 가기");
//            messageButton.setUrl("https://www.funda.kr/v2/news?mode=story");
//            mes_vo.setMessage_button(messageButton);
//            mes_vo.setText("공지사항을 여기에 뿌려주는 기능을 차차 구현하려 합니다. "
//                    + "지금은 아래 링크를 클릭하여 공지사항을 확인해주세요ㅎ (메뉴 다시보기 = '메뉴' 입력!)");
//        }
//        else if(command.equals("FAQ 보기")) {
//
//            mes_vo.setText("FAQ 범위를 선택해주세요");
//            KeyboardVO keyboard = new KeyboardVO(new String[] {"공통", "대출자", "투자자", "취소"});
//            res_vo.setKeyboard(keyboard);
//        }
//        else if(command.equals("공통")) {
//
//            MessageButtonVO messageButton = new MessageButtonVO();
//            messageButton.setLabel("공통 FAQ 확인하기");
//            messageButton.setUrl("https://www.funda.kr/v2/faq");
//            mes_vo.setMessage_button(messageButton);
//            mes_vo.setText("아래 링크를 통해 공통 FAQ를 확인하세요! (메뉴 다시보기 = '메뉴' 입력!)");
//        }
//        else if(command.equals("대출자")) {
//
//            MessageButtonVO messageButton = new MessageButtonVO();
//            messageButton.setLabel("대출자 FAQ 확인하기");
//            messageButton.setUrl("https://www.funda.kr/v2/faq");
//            mes_vo.setMessage_button(messageButton);
//            mes_vo.setText("아래 링크를 통해 대출자 FAQ를 확인하세요! (메뉴 다시보기 = '메뉴' 입력!)");
//        }
//        else if(command.equals("투자자")) {
//
//            MessageButtonVO messageButton = new MessageButtonVO();
//            messageButton.setLabel("투자자 FAQ 확인하기");
//            messageButton.setUrl("https://www.funda.kr/v2/faq");
//            mes_vo.setMessage_button(messageButton);
//            mes_vo.setText("아래 링크를 통해 투자자 FAQ를 확인하세요! (메뉴 다시보기 = '메뉴' 입력!)");
//        }
//        else if(command.equals("취소")) {
//
//            mes_vo.setText("메뉴에서 명령을 선택해주세요~");
//            KeyboardVO keyboard = new KeyboardVO(new String[]
//                    {"챗봇이랑 대화하기", "공지사항 보기", "FAQ 보기", "1:1 문의하기"});
//            res_vo.setKeyboard(keyboard);
//        }
//        else if(command.equals("챗봇이랑 대화하기")){
//
//            PhotoVO photo = new PhotoVO();
//            photo.setUrl("http://www.businesscomputingworld.co.uk/wp-content/uploads/2018/01/Chatbot.jpg");
//            photo.setHeight(427);
//            photo.setWidth(540);
//            mes_vo.setPhoto(photo);
//            mes_vo.setText("(하트뿅) 저와 대화를 나눠볼까용? 아직은 매우 멍청하답니다ㅎㅎ (메뉴 다시보기 = '메뉴' 입력!)");
//        }
//        else if(command.contains("안녕")){
//            mes_vo.setText("안녕하세요?ㅎㅎ");
//        }
//        else {
//            mes_vo.setText("아직 구현하지 않은 명령어입니다. Ryan에게 문의하세요~");
//        }
//
        res_vo.setMessage(mes_vo);
        return res_vo;
    }
}
