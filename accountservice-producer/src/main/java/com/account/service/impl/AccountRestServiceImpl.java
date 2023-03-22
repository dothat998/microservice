package com.account.service.impl;

import com.account.entity.AccountDTO;
import com.account.service.AccountRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AccountRestServiceImpl implements AccountRestService {


    @Autowired
    RestTemplate restTemplate;

    //URL + Header + Body
    @Override
    public AccountDTO getAccount(String username) {
        //vi du nhu gui url sang can truyen param len url thong qua PathVariable
        String url = "http://api.dothat/user/{value}";
        url = url.replace("{value}", username);

        ResponseEntity<AccountDTO[]> responseEntity =
                restTemplate.getForEntity(url, AccountDTO[].class);
        AccountDTO[] body = responseEntity.getBody();
        for (AccountDTO accountDTO : body){
            accountDTO.getEmail();
            accountDTO.getName();
        }
        return null;
    }

    //Dữ liệu trả về từ Restful Serivce có định dạng XML hoặc JSON có thể tự động được chuyển đổi (Convert) thành đói tượng Java.

    


}
