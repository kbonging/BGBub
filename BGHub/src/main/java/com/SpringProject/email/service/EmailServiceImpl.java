package com.SpringProject.email.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender emailSender;
	
//	@Autowired
//    private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void sendEmail(String to, String subject, String text)
			throws MessagingException, UnsupportedEncodingException {
		 MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

	        // 받는 사람
	        helper.setTo(to);
	        // 이메일 제목
	        helper.setSubject(subject);
	        // 이메일 내용
	        helper.setText(text, true);
	        // 보내는 사람
	        helper.setFrom(new InternetAddress("apple75391@gmail.com", "BGHub"));

	        emailSender.send(message);
	}

	@Override
	public String randomCode() {
		StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 8자리
            int index = rnd.nextInt(2); // 0~1 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 1:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }
        return key.toString();
	}
	
	public String createEmailContent(String randomCode) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>");
        text.append("<html lang='ko'>");
        text.append("<head>");
        text.append("    <meta charset='UTF-8'>");
        text.append("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        text.append("    <title>이메일 인증 메시지</title>");
        text.append("    <style>");
        text.append("        body {");
        text.append("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        text.append("            margin: 0;");
        text.append("            padding: 0;");
        text.append("            background-color: #f0f4f8;");
        text.append("            color: #333;");
        text.append("        }");
        text.append("        .container {");
        text.append("            max-width: 600px;");
        text.append("            margin: 50px auto;");
        text.append("            background-color: #ffffff;");
        text.append("            border-radius: 12px;");
        text.append("            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);");
        text.append("            overflow: hidden;");
        text.append("            border-top: 5px solid #4CAF50;");
        text.append("        }");
        text.append("        .header {");
        text.append("            background-color: #4CAF50;");
        text.append("            color: white;");
        text.append("            padding: 20px;");
        text.append("            text-align: center;");
        text.append("        }");
        text.append("        .header h1 {");
        text.append("            margin: 0;");
        text.append("            font-size: 24px;");
        text.append("        }");
        text.append("        .content {");
        text.append("            padding: 20px;");
        text.append("            text-align: center;");
        text.append("        }");
        text.append("        .content h2 {");
        text.append("            color: #333;");
        text.append("            margin-bottom: 10px;");
        text.append("        }");
        text.append("        .code-box {");
        text.append("            display: inline-block;");
        text.append("            margin: 20px 0;");
        text.append("            padding: 20px;");
        text.append("            border-radius: 8px;");
        text.append("            background-color: #f9f9f9;");
        text.append("            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);");
        text.append("            border: 2px solid #4CAF50;");
        text.append("        }");
        text.append("        .code {");
        text.append("            font-size: 36px;");
        text.append("            color: #4CAF50;");
        text.append("            font-weight: bold;");
        text.append("            padding: 10px;");
        text.append("            border-radius: 5px;");
        text.append("            background-color: #e9f7ef;");
        text.append("        }");
        text.append("        footer {");
        text.append("            padding: 20px;");
        text.append("            text-align: center;");
        text.append("            background-color: #f9f9f9;");
        text.append("            border-top: 1px solid #ddd;");
        text.append("        }");
        text.append("        footer p {");
        text.append("            margin: 0;");
        text.append("            color: #777;");
        text.append("        }");
        text.append("    </style>");
        text.append("</head>");
        text.append("<body>");
        text.append("    <div class='container'>");
        text.append("        <div class='header'>");
        text.append("            <h1>BGHub 이메일 인증</h1>");
        text.append("        </div>");
        text.append("        <div class='content'>");
        text.append("            <h2>인증번호</h2>");
        text.append("            <p>아래 인증번호를 입력해 주세요.</p>");
        text.append("            <div class='code-box'>");
        text.append("                <div class='code'>CODE: <strong>").append(randomCode).append("</strong></div>");
        text.append("            </div>");
        text.append("            <p>저희 BGHub를 이용해 주셔서 감사합니다!</p>");
        text.append("        </div>");
        text.append("        <footer>");
        text.append("            <p>본 메일은 발신전용입니다.</p>");
        text.append("        </footer>");
        text.append("    </div>");
        text.append("</body>");
        text.append("</html>");
        
        return text.toString();
    }
	
//	@Override
//	public void saveVerificationCode(String email, String code) {
//	    redisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES); // 5분간 저장
//	}
//	
//	@Override
//	public boolean verifyCode(String email, String code) {
//	    String storedCode = redisTemplate.opsForValue().get(email);
//	    return storedCode != null && storedCode.equals(code);
//	}

}
