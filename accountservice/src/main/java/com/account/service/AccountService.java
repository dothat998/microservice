package com.account.service;

import com.account.request.AccountDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountService {

    void add(AccountDTO accountDTO);
    void update(AccountDTO accountDTO);
    void updatePassword(AccountDTO accountDTO);
    void delete(Long id);

    List<AccountDTO>getAll();
    AccountDTO getOne(Long id);
}


